package com.epam.tat.calculator.tests;

import com.epam.tat.module4.Calculator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorSqrtDoubleTest {
    private Calculator calculator;

    @BeforeEach
    public void setUp(){
        calculator = new Calculator();
    }

    @ParameterizedTest(name = "sqrt(abs({0})) = {1}")
    @CsvSource({
            "4.0, 2.0",
            "9.0, 3.0",
            "-4.0, 2.0",
            "-9.0, 3.0",
            "0.0, 0.0",
            "0.0001, 0.01",
            "1000000.0, 1000.0"
    })
    @DisplayName("Test sqrt with absolute values")
    public void sqrt_withAbsValue_returnsExpectedResult(double input, double expected) {
        assertEquals(expected, calculator.sqrt(input), 0.0001);
    }

    @AfterEach
    public void tearDown(){
        calculator = null;
    }
}
