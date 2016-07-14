package com.github.moreaunicolas.katas.roman;

import org.junit.ComparisonFailure;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static com.github.moreaunicolas.katas.roman.RomanNumeralAssert.assertThat;
import static org.mockito.Mockito.doReturn;

@RunWith(MockitoJUnitRunner.class)
public class RomanNumeralAssertTests {

    @Mock
    private RomanNumeral romanNumeral;

    @Test(expected = ComparisonFailure.class)
    public void isRomanNumeralShouldThrowWhenAssertionIsFalse() {
        doReturn("I").when(romanNumeral).toString();

        assertThat(romanNumeral).isRomanNumeral("II");
    }

    @Test(expected = AssertionError.class)
    public void isRomanNumeralShouldThrowWhenActualIsNull() {
        assertThat(null).isRomanNumeral("I");
    }

    @Test
    public void isRomanNumeralShouldDoNothingWhenAssertionIsTrue() {
        doReturn("I").when(romanNumeral).toString();

        assertThat(romanNumeral).isRomanNumeral("I");
    }

    @Test(expected = ComparisonFailure.class)
    public void hasValueShouldThrowWhenAssertionIsFalse() {
        doReturn(1).when(romanNumeral).intValue();

        assertThat(romanNumeral).hasValue(2);
    }

    @Test(expected = AssertionError.class)
    public void hasValueShouldThrowWhenActualIsNull() {
        assertThat(null).hasValue(1);
    }

    @Test
    public void hasValueShouldDoNothingWhenAssertionIsTrue() {
        doReturn(1).when(romanNumeral).intValue();

        assertThat(romanNumeral).hasValue(1);
    }
}
