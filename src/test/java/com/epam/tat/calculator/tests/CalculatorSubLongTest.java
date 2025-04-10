package com.epam.tat.calculator.tests;

import com.epam.tat.module4.Calculator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorSubLongTest {
    private Calculator calculator;

    @BeforeEach
    public void setUp(){
        calculator = new Calculator();
    }

    @ParameterizedTest(name = "sub_{0}_minus_{1}_returns_{2}")
    @CsvSource({
            "3, 2, 1",
            "1, 1, 0",
            "-3, -4, 1",
            "0, 0, 0",
            "0, -5, 5",
            "-7, 0, -7",
            "1000, -500, 1500"
    })
    @DisplayName("Test subtraction of two values")
    public void sub_twoNumbers_returnsExpectedResult(long a, long b, long expected){
        assertEquals(expected, calculator.sub(a, b));
    }

    @ParameterizedTest(name = "sub_{0}_minus_0_returns_{1}")
    @CsvSource({
            "9223372036854775807, 9223372036854775807",
            "-9223372036854775808, -9223372036854775808"
    })
    @DisplayName("Test subtraction of extreme values minus 0")
    void sub_ExtremeValueMinusZero_returnsSameExtremeValue(long value, long expected) {
        long result = calculator.sub(value, 0);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test subtraction of 0 minus extreme value")
    void sub_zeroMinusMaxValue_returnsExpectedResult() {
        long value = Long.MAX_VALUE;
        long expected = -Long.MAX_VALUE;

        long result = calculator.sub(0, value);
        assertEquals(expected, result);
    }

    @AfterEach
    public void tearDown(){
        calculator = null;
    }
}
