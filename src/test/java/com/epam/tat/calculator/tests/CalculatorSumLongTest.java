package com.epam.tat.calculator.tests;

import com.epam.tat.module4.Calculator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorSumLongTest {
    private Calculator calculator;

    @BeforeEach
    public void setUp(){
        calculator = new Calculator();
    }

    @ParameterizedTest(name = "sum_{0}_and_{1}_returns_{2}")
    @CsvSource({
            "2, 3, 5",
            "-1, 1, 0",
            "-3, -4, -7",
            "0, 0, 0",
            "1000, -500, 500"
    })
    public void sum_twoNumbers_returnsExpectedResult(long a, long b, long expected){
        assertEquals(expected, calculator.sum(a, b));
    }

    @Test
    @DisplayName("sum(Long.MAX_VALUE, 0) returns Long.MAX_VALUE")
    void sum_maxValueAndZero_returnsMaxValue() {
        long a = Long.MAX_VALUE;
        long b = 0;
        long expected = Long.MAX_VALUE;

        assertEquals(expected, calculator.sum(a, b));
    }

    @Test
    @DisplayName("sum(Long.MIN_VALUE, 0) returns Long.MIN_VALUE")
    void sum_minValueAndZero_returnsMinValue() {
        long a = Long.MIN_VALUE;
        long b = 0;
        long expected = Long.MIN_VALUE;

        assertEquals(expected, calculator.sum(a, b));
    }

    @AfterEach
    public void tearDown(){
        calculator = null;
    }
}
