package com.epam.tat.calculator.tests;

import com.epam.tat.module4.Calculator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorMultLongTest {
    private Calculator calculator;

    @BeforeEach
    public void setUp(){
        calculator = new Calculator();
    }

    @ParameterizedTest(name = "mult_{0}_and_{1}_returns_{2}")
    @CsvSource({
            "2, 3, 6",
            "-2, 3, -6",
            "2, -3, -6",
            "-2, -3, 6",
            "0, 5, 0",
            "5, 0, 0",
            "0, 0, 0",
            "1, 999999, 999999",
            "-1, 999999, -999999"
    })
    @DisplayName("Test multiplication of two values")
    void mult_twoValues_returnsExpectedResult(long a, long b, long expected) {
        assertEquals(expected, calculator.mult(a, b));
    }

    @ParameterizedTest
    @CsvSource({
            "9223372036854775807, 9223372036854775807",
            "-9223372036854775808, -9223372036854775808"
    })
    @DisplayName("Test multiplication of an extreme value by 1")
    public void mult_extremeValueByOne_returnsSameExtremeValue(long a, long expected){
        assertEquals(expected, calculator.mult(a, 1));
    }

    @AfterEach
    public void tearDown(){
        calculator = null;
    }
}
