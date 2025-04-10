package com.epam.tat.calculator.tests;

import com.epam.tat.module4.Calculator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorSubDoubleTest {
    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @ParameterizedTest(name = "sub_{0}_minus_{1}_returns_{2}")
    @CsvSource({
            "5.5, 2.5, 3.0",
            "-5.5, -2.5, -3.0",
            "0.0, 0.0, 0.0",
            "2.0, 0.0, 2.0",
            "0.0, 2.0, -2.0"
    })
    @DisplayName("Test subtraction of two double values")
    public void sub_twoDoubles_returnsExpectedResult(double a, double b, double expected) {
        assertEquals(expected, calculator.sub(a, b), 0.0001);
    }

    @ParameterizedTest(name = "sub_{0}_minus_0_returns_{1}")
    @CsvSource({
            "1.7976931348623157E+308, 1.7976931348623157E+308",
            "4.94065645841247E-324, 4.94065645841247E-324"
    })
    @DisplayName("Test subtraction of double extreme values minus 0")
    void sub_ExtremeValueMinusZero_returnsSameExtremeValue(double value, double expected) {
        double result = calculator.sub(value, 0);
        assertEquals(expected, result);
    }

    @AfterEach
    public void tearDown(){
        calculator = null;
    }
}
