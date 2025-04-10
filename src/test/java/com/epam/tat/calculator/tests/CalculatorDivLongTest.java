package com.epam.tat.calculator.tests;

import com.epam.tat.module4.Calculator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorDivLongTest {
    private Calculator calculator;

    @BeforeEach
    public void setUp(){
        calculator = new Calculator();
    }

    @ParameterizedTest(name = "div_{0}_by_{1}_returns_{2}")
    @CsvSource({
            "10, 2, 5",
            "9, 4, 2",
            "-9, 4, -2",
            "9, -4, -2",
            "-9, -4, 2",
            "0, 1, 0",
            "1, 1, 1"
    })
    @DisplayName("Test integer division")
    public void div_twoValues_returnsExpectedQuotient(long a, long b, long expected) {
        assertEquals(expected, calculator.div(a, b));
    }

    @Test
    @DisplayName("Test division by zero throws NumberFormatException")
    public void div_byZero_throwsException() {
        assertThrows(NumberFormatException.class, () -> calculator.div(10, 0));
    }

    @AfterEach
    public void tearDown(){
        calculator = null;
    }
}
