package com.epam.tat.calculator.tests;

import com.epam.tat.module4.Calculator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorIsPositiveBooleanTest {
    private Calculator calculator;

    @BeforeEach
    public void setUp(){
        calculator = new Calculator();
    }

    @ParameterizedTest(name = "isPositive({0}) = {1}")
    @CsvSource({
            "7, true",
            "1, true",
            "0, false",
            "-1, false",
            "-100, false",
            "1000000000, true",
            "-1000000000, false"
    })
    @DisplayName("Test isPositive method")
    void isPositive_inputValue_returnsExpectedResult(long value, boolean expected) {
        assertEquals(expected, calculator.isPositive(value));
    }

    @ParameterizedTest(name = "isPositive({0}) = {1}")
    @CsvSource({
            "Long.MAX_VALUE, true",
            "Long.MIN_VALUE, false"
    })
    @DisplayName("Test isPositive method with boundary values")
    public void isPositive_boundaryValues_returnsExpectedResult(String value, boolean expected) {
        long longValue = value.equals("Long.MAX_VALUE") ? Long.MAX_VALUE : Long.MIN_VALUE;
        assertEquals(expected, calculator.isPositive(longValue));
    }

    @AfterEach
    public void tearDown(){
        calculator = null;
    }
}
