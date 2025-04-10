package com.epam.tat.calculator.tests;

import com.epam.tat.module4.Calculator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorDivDoubleTest {
    private Calculator calculator;

    @BeforeEach
    public void setUp(){
        calculator = new Calculator();
    }

    @ParameterizedTest(name = "div_{0}_by_{1}_returns_{2}")
    @CsvSource({
            "10.0, 2.0, 5.0",
            "9.0, 4.0, 2.25",
            "-9.0, 4.0, -2.25",
            "9.0, -4.0, -2.25",
            "-9.0, -4.0, 2.25",
            "0.0, 2.0, 0.0",
            "1.0, 3.0, 0.333333333333"
    })
    @DisplayName("Test division of two double values")
    public void div_twoDoubles_returnsExpectedResult(double a, double b, double expected) {
        assertEquals(expected, calculator.div(a, b), 0.0001);
    }

    @ParameterizedTest(name = "div_{0}_by_{1}_returns_{2}")
    @CsvSource({
            "1.7976931348623157E+308, 1.0, 1.7976931348623157E+308",
            "4.94065645841247E-324, 1.0, 4.94065645841247E-324"
    })
    @DisplayName("Test division of extreme values by 1")
    public void div_extremeValuesByOne_returnsSameValue(double a, double b, double expected) {
        assertEquals(expected, calculator.div(a, b), 0.000000000000001);
    }

    @AfterEach
    public void tearDown(){
        calculator = null;
    }
}
