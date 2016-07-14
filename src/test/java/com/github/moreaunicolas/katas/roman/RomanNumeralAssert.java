package com.github.moreaunicolas.katas.roman;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;

public class RomanNumeralAssert extends AbstractAssert<RomanNumeralAssert, RomanNumeral> {

    public static RomanNumeralAssert assertThat(RomanNumeral actual) {
        return new RomanNumeralAssert(actual);
    }

    protected RomanNumeralAssert(RomanNumeral actual) {
        super(actual, RomanNumeralAssert.class);
    }

    public RomanNumeralAssert isRomanNumeral(String expected) {
        isNotNull();
        Assertions.assertThat(actual.toString())
                .as("String representation of roman numeral should be %s", expected)
                .isEqualTo(expected);
        return this;
    }

    public RomanNumeralAssert hasValue(int expected) {
        isNotNull();
        Assertions.assertThat(actual.intValue())
                .as("Integer value of roman numeral should be %s", expected)
                .isEqualTo(expected);
        return this;
    }
}
