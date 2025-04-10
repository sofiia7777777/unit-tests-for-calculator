package com.epam.tat.calculator.tests;

import com.epam.tat.module4.FixedCalculator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorCosDoubleTest {
    private FixedCalculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new FixedCalculator();
    }

    @ParameterizedTest(name = "cos({0} * PI) = Math.cos({0} * PI)")
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
    @DisplayName("cos(a * PI) matches Math.cos(a * PI)")
    void cos_validAngles_matchesMathCos(double multiplier) {
        double radians = multiplier * Math.PI;
        assertEquals(Math.cos(radians), calculator.cos(radians), 0.0001);
    }

    @AfterEach
    public void tearDown() {
        calculator = null;
    }
}
