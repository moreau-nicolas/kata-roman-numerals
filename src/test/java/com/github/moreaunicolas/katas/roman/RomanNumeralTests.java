package com.github.moreaunicolas.katas.roman;

import org.junit.Test;

public class RomanNumeralTests {

    @Test
    public void arabic0convertsToEmptyString() {
        RomanNumeralAssert.assertThat(RomanNumeral.valueOf(0)).isRomanNumeral("");
    }

    @Test
    public void arabic1convertsToRomanI() {
        RomanNumeralAssert.assertThat(RomanNumeral.valueOf(1)).isRomanNumeral("I");
    }

    @Test
    public void arabic2convertsToRomanII() {
        RomanNumeralAssert.assertThat(RomanNumeral.valueOf(2)).isRomanNumeral("II");
    }

    @Test
    public void arabic3convertsToRomanIII() {
        RomanNumeralAssert.assertThat(RomanNumeral.valueOf(3)).isRomanNumeral("III");
    }

    @Test
    public void arabic4convertsToRomanIV() {
        RomanNumeralAssert.assertThat(RomanNumeral.valueOf(4)).isRomanNumeral("IV");
    }

    @Test
    public void arabic5convertsToRomanV() {
        RomanNumeralAssert.assertThat(RomanNumeral.valueOf(5)).isRomanNumeral("V");
    }

    @Test
    public void arabic6convertsToRomanVI() {
        RomanNumeralAssert.assertThat(RomanNumeral.valueOf(6)).isRomanNumeral("VI");
    }

    @Test
    public void arabic7convertsToRomanVII() {
        RomanNumeralAssert.assertThat(RomanNumeral.valueOf(7)).isRomanNumeral("VII");
    }

    @Test
    public void arabic9convertsToRomanIX() {
        RomanNumeralAssert.assertThat(RomanNumeral.valueOf(9)).isRomanNumeral("IX");
    }

    @Test
    public void arabic10convertsToRomanX() {
        RomanNumeralAssert.assertThat(RomanNumeral.valueOf(10)).isRomanNumeral("X");
    }

    @Test
    public void arabic40convertsToRomanXL() {
        RomanNumeralAssert.assertThat(RomanNumeral.valueOf(40)).isRomanNumeral("XL");
    }

    @Test
    public void arabic50convertsToRomanL() {
        RomanNumeralAssert.assertThat(RomanNumeral.valueOf(50)).isRomanNumeral("L");
    }

    @Test
    public void arabic90convertsToRomanXC() {
        RomanNumeralAssert.assertThat(RomanNumeral.valueOf(90)).isRomanNumeral("XC");
    }

    @Test
    public void arabic100convertsToRomanC() {
        RomanNumeralAssert.assertThat(RomanNumeral.valueOf(100)).isRomanNumeral("C");
    }

    @Test
    public void arabic400convertsToRomanCD() {
        RomanNumeralAssert.assertThat(RomanNumeral.valueOf(400)).isRomanNumeral("CD");
    }

    @Test
    public void arabic500convertsToRomanD() {
        RomanNumeralAssert.assertThat(RomanNumeral.valueOf(500)).isRomanNumeral("D");
    }

    @Test
    public void arabic900convertsToRomanCM() {
        RomanNumeralAssert.assertThat(RomanNumeral.valueOf(900)).isRomanNumeral("CM");
    }

    @Test
    public void arabic1000convertsToRomanM() {
        RomanNumeralAssert.assertThat(RomanNumeral.valueOf(1000)).isRomanNumeral("M");
    }

    @Test
    public void arabic1515convertsToRomanMDXV() {
        RomanNumeralAssert.assertThat(RomanNumeral.valueOf(1515)).isRomanNumeral("MDXV");
    }

    @Test
    public void arabic3999convertsToRomanMMMCMXCIX() {
        RomanNumeralAssert.assertThat(RomanNumeral.valueOf(3999)).isRomanNumeral("MMMCMXCIX");
    }

    @Test(expected = IllegalArgumentException.class)
    public void negativeValuesAreNotSupported() {
        RomanNumeral.valueOf(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void valuesGreaterThanOrEqualTo4000AreNotSupported() {
        RomanNumeral.valueOf(4000);
    }

    @Test
    public void emptyStringConvertsToArabic0() {
        RomanNumeralAssert.assertThat(RomanNumeral.parse("")).hasValue(0);
    }

    @Test
    public void romanIConvertsToArabic1() {
        RomanNumeralAssert.assertThat(RomanNumeral.parse("I")).hasValue(1);
    }

    @Test
    public void romanIIConvertsToArabic2() {
        RomanNumeralAssert.assertThat(RomanNumeral.parse("II")).hasValue(2);
    }

    @Test
    public void romanMDXVConvertsToArabic1515() {
        RomanNumeralAssert.assertThat(RomanNumeral.parse("MDXV")).hasValue(1515);
    }

    @Test
    public void romanMMMCMXCIXConvertsTo3999() {
        RomanNumeralAssert.assertThat(RomanNumeral.parse("MMMCMXCIX")).hasValue(3999);
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannotParseZZZ() {
        RomanNumeral.parse("ZZZ");
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannotParseVX() {
        RomanNumeral.parse("VX");
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannotParseVL() {
        RomanNumeral.parse("VL");
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannotParseVC() {
        RomanNumeral.parse("VC");
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannotParseVD() {
        RomanNumeral.parse("VD");
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannotParseVM() {
        RomanNumeral.parse("VM");
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannotParseXD() {
        RomanNumeral.parse("XD");
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannotParseXM() {
        RomanNumeral.parse("XM");
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannotParseVIIIVIII() {
        RomanNumeral.parse("VIIIVIII");
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannotParseIIII() {
        RomanNumeral.parse("IIII");
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannotParseXXXX() {
        RomanNumeral.parse("XXXX");
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannotParseLLLL() {
        RomanNumeral.parse("LLLL");
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannotParseCCCC() {
        RomanNumeral.parse("CCCC");
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannotParseDDDD() {
        RomanNumeral.parse("DDDD");
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannotParseMMMM() {
        RomanNumeral.parse("MMMM");
    }
}