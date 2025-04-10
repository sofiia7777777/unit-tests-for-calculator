package com.epam.tat.calculator.tests;

import com.epam.tat.module4.FixedCalculator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CalculatorTgDoubleTest {
    private FixedCalculator calculator;

    @BeforeEach
    public void setUp(){
        calculator = new FixedCalculator();
    }

    @ParameterizedTest(name = "tg({0} * PI) = Math.tan({0} * PI)")
    @CsvSource({
            "0.0",
            "0.5",
            "1.0",
            "1.5",
            "2.0",
            "0.1666666667",
            "0.25",
            "0.3333333333"
    })
    void tg_validAngles_matchesMathTan(double multiplier) {
        double radians = multiplier * Math.PI;
        assertEquals(Math.tan(radians), calculator.tg(radians), 0.0001);
    }

    @ParameterizedTest(name = "tg({0} * PI) is near infinity")
    @CsvSource({
            "0.5",
            "1.5"
    })
    @DisplayName("tg(a * PI) returns very large value when undefined")
    void tg_undefinedAngles_returnsLargeValue(double multiplier) {
        double radians = multiplier * Math.PI;
        double result = calculator.tg(radians);

        assertTrue(Math.abs(result) > 1e15);
    }

    @AfterEach
    public void tearDown(){
        calculator = null;
    }
}
