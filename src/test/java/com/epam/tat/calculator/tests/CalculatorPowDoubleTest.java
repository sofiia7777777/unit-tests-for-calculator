package com.epam.tat.calculator.tests;

import com.epam.tat.module4.Calculator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorPowDoubleTest {
    private Calculator calculator;

    @BeforeEach
    public void setUp(){
        calculator = new Calculator();
    }

    @ParameterizedTest(name = "pow({0}, {1}) = {2}")
    @CsvSource({
            "2.0, 3.0, 8.0",
            "2.0, 2.9, 4.0",
            "5.0, 0.0, 1.0",
            "2.0, -2.0, 0.25",
            "-2.0, 3.0, -8.0",
            "-2.0, 2.9, 4.0",
            "0.0, 2.0, 0.0",
            "0.0, 0.0, 1.0",
            "9.0, 0.9, 1.0",
            "2.0, -2.9, 0.125"
    })
    @DisplayName("Test pow with floor applied to exponent")
    void pow_withFlooredExponent_returnsExpectedResult(double a, double b, double expected) {
        assertEquals(expected, calculator.pow(a, b), 0.0001);
    }

    @AfterEach
    public void tearDown(){
        calculator = null;
    }
}
