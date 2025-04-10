package com.epam.tat.calculator.tests;

import com.epam.tat.module4.Calculator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.ParameterizedTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorIsNegativeBooleanTest {
    private Calculator calculator;

    @BeforeEach
    public void setUp(){
        calculator = new Calculator();
    }

    @ParameterizedTest(name = "isNegative({0}) = {1}")
    @CsvSource({
            "7, false",
            "1, false",
            "0, false",
            "-1, true",
            "-100, true",
            "1000000000, false",
            "-1000000000, true"
    })
    @DisplayName("Test isNegative method")
    public void isNegative_inputValue_returnsExpectedResult(long value, boolean expected){
        assertEquals(expected, calculator.isNegative(value));
    }

    @ParameterizedTest(name = "isNegative({0}) = {1}")
    @CsvSource({
            "Long.MAX_VALUE, false",
            "Long.MIN_VALUE, true"
    })
    @DisplayName("Test isNegative method with boundary values")
    public void isNegative_boundaryValues_returnsExpectedResult(String value, boolean expected) {
        long longValue = value.equals("Long.MAX_VALUE") ? Long.MAX_VALUE : Long.MIN_VALUE;
        assertEquals(expected, calculator.isNegative(longValue));
    }

    @AfterEach
    public void tearDown(){
        calculator = null;
    }
}
