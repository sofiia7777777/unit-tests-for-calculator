package com.epam.tat.calculator.tests;

import com.epam.tat.module4.Calculator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorSinDoubleTest {
    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }

    @ParameterizedTest(name = "sin({0} * PI) = Math.sin({0} * PI)")
    @CsvSource({
            "0.0",
            "0.1666666667",
            "0.25",
            "0.3333333333",
            "0.5",
            "1.0",
            "1.5",
            "2.0"
    })
    @DisplayName("sin(a * PI) matches Math.sin(a * PI)")
    void sin_validAngles_matchesMathSin(double multiplier) {
        double radians = multiplier * Math.PI;
        assertEquals(Math.sin(radians), calculator.sin(radians), 0.0001);
    }

    @AfterEach
    public void tearDown() {
        calculator = null;
    }
}
