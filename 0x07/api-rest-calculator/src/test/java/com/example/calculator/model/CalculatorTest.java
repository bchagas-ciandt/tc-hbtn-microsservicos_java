package com.example.calculator.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Null;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

public class CalculatorTest {

    @Autowired
    private Calculator calculator;

    @BeforeEach
    public void setup() {
        calculator = new Calculator();
    }

    @Test
    void sumTest() {
        assertEquals(3, calculator.sum(2.0, 1.0));
    }

    @Test
    public void numbersNullSumTest() {
        assertThrows(NullPointerException.class, () -> calculator.sum(null, 1.0));
    }

    @Test
    void subTest() {
        assertEquals(5, calculator.sub(10.0, 5.0));
    }

    @Test
    void divideTest() {
        assertEquals(5, calculator.divide(10.0, 2.0));
    }

    @Test
    public void divisionByZeroTest() {
        assertThrows(ArithmeticException.class, () -> calculator.divide(10.0, 0.0));
    }

    @Test
    void factorialTest() {
        assertEquals(6, calculator.factorial(3));
    }

    @Test
    void integerToBinaryTest() {
        assertEquals(101, calculator.integerToBinary(5));
    }

    @Test
    void integerToHexadecimalTest() {
        assertEquals("AA".toLowerCase(), calculator.integerToHexadecimal(170));
    }

    @Test
    void calculeDayBetweenDateTest() {
        assertEquals(14, calculator.calculeDayBetweenDate(LocalDate.of(2020, 3, 15), LocalDate.of(2020, 3, 29)));
    }
}
