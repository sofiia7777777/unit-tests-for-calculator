package com.epam.tat.calculator.tests;

import com.epam.tat.module4.Calculator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorMultDoubleTest {
    private Calculator calculator;

    @BeforeEach
    public void setUp(){
        calculator = new Calculator();
    }

    @ParameterizedTest(name = "mult_{0}_and_{1}_returns_{2}")
    @CsvSource({
            "3.5, 2.5, 8.0",
            "3.5, -2.5, -9.0",
            "-3.5, -2.5, 8.0",
            "5.0, 0.0, 0.0",
            "0.0, 2.0, 0.0",
            "999.99, 1, 999.0",
    })
    @DisplayName("Test multiplication of two values")
    void mult_twoValues_returnsExpectedResult(double a, double b, double expected) {
        assertEquals(expected, calculator.mult(a, b));
    }

    @ParameterizedTest
    @CsvSource({
            "1.7976931348623157E+308, 1.7976931348623157E+308",
            "4.94065645841247E-324, 4.94065645841247E-324"
    })
    @DisplayName("Test multiplication of an extreme value by 1")
    public void mult_extremeValueByOne_returnsSameExtremeValue(double a, double expected){
        double result = calculator.mult(a, 1);
        assertEquals(expected, result, 0.000000000000001);
    }

    @AfterEach
    public void tearDown(){
        calculator = null;
    }
}
