package com.epam.tat.calculator.tests;

import com.epam.tat.module4.Calculator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorSumDoubleTest {
    private Calculator calculator;

    @BeforeEach
    public void setUp(){
        calculator = new Calculator();
    }

    @ParameterizedTest(name = "sum_{0}_and_{1}_returns_{2}")
    @CsvSource({
            "1.5, 2.5, 4.0",
            "-1.5, -2.5, -4.0",
            "0.0, 0.0, 0.0",
            "2.5, 0.0, 2.5",
            "-1.5, 0.0, -1.5",
    })
    @DisplayName("Test sum of two double numbers")
    public void sum_twoDoubleNumbers_returnsExpectedResult(double a, double b, double expected){
        assertEquals(expected, calculator.sum(a, b),  0.0001);
    }

    @Test
    @DisplayName("sum(Double.MAX_VALUE, 0) returns Double.MAX_VALUE")
    public void sum_withDoubleMaxValue_returnsExpectedResult() {
        double result = calculator.sum(Double.MAX_VALUE, 0.0);
        assertEquals(Double.MAX_VALUE, result, 0.0001);
    }

    @Test
    @DisplayName("sum(Double.MIN_VALUE, 0) returns Double.MIN_VALUE")
    public void sum_withDoubleMinValue_returnsExpectedResult() {
        double result = calculator.sum(Double.MIN_VALUE, 0.0);
        assertEquals(Double.MIN_VALUE, result, 0.0001);
    }

    @AfterEach
    public void tearDown(){
        calculator = null;
    }
}
