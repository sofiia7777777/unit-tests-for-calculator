package com.epam.tat.calculator.tests;

import com.epam.tat.module4.FixedCalculator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CalculatorCtgDoubleTest {
    private FixedCalculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new FixedCalculator();
    }

    @ParameterizedTest(name = "ctg({0} * PI) = 1 / Math.tan({0} * PI)")
    @CsvSource({
            "0.1666666667",
            "0.25",
            "0.3333333333",
            "0.5",
            "1.5"
    })
    void ctg_validAngles_matchesMathCtg(double multiplier) {
        double radians = multiplier * Math.PI;
        assertEquals(1 / Math.tan(radians), calculator.ctg(radians), 0.0001);
    }

    @ParameterizedTest(name = "ctg({0} * PI) is near infinity")
    @CsvSource({
            "0.0",
            "1.0",
            "2.0"
    })
    @DisplayName("ctg(a * PI) returns very large value when undefined")
    void ctg_undefinedAngles_returnsLargeValue(double multiplier) {
        double radians = multiplier * Math.PI;
        double result = calculator.ctg(radians);

        assertTrue(Math.abs(result) > 1e15);
    }

    @AfterEach
    public void tearDown() {
        calculator = null;
    }
}
