package com.example.calculator.controller;

import com.example.calculator.model.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CalculatorController.class)
public class CalculatorControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private Calculator calculator;

    @BeforeEach
    public void setup() {
        standaloneSetup(this.mvc);
    }

    @Test
    void messageWelcome() throws Exception {
        RequestBuilder request = get("/calculator/welcome");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("Bem vindo à CALCULATOR API REST.", result.getResponse().getContentAsString());
    }

    @Test
    void addNumbers() throws Exception {
        Mockito.when(this.calculator.sum(25.0, 25.0)).thenReturn(50.0);
        RequestBuilder request = get("/calculator/addNumbers").param("number1", "25.0").param("number2", "25.0");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("50.0", result.getResponse().getContentAsString());
    }

    @Test
    void subNumbers() throws Exception {

        Mockito.when(this.calculator.sub(25.0, 25.0)).thenReturn(0.0);
        RequestBuilder request = get("/calculator/subNumbers").param("number1", "25.0").param("number2", "25.0");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("0.0", result.getResponse().getContentAsString());
    }

    @Test
    void divideNumbers() throws Exception {
        Mockito.when(this.calculator.divide(10.0, 2.0)).thenReturn(5.0);
        RequestBuilder request = get("/calculator/divideNumbers").param("number1", "10.0").param("number2", "2.0");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("5.0", result.getResponse().getContentAsString());
    }

    @Test
    void factorial() throws Exception {
        Mockito.when(this.calculator.factorial(3)).thenReturn(6);
        RequestBuilder request = get("/calculator/factorial").param("factorial", "3");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("6", result.getResponse().getContentAsString());
    }

    @Test
    void calculeDayBetweenDate() throws Exception {
        Mockito.when(this.calculator.calculeDayBetweenDate(LocalDate.of(2020, 3, 15), LocalDate.of(2020, 3, 29))).thenReturn(14);
        RequestBuilder request = get("/calculator/calculeDayBetweenDate").param("localDate1", "2020-03-15").param("localDate2", "2020-03-29");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("14", result.getResponse().getContentAsString());
    }

    @Test
    void integerToBinary() throws Exception {
        Mockito.when(this.calculator.integerToBinary(20)).thenReturn(10100);
        RequestBuilder request = get("/calculator/integerToBinary").param("number1", "20");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("10100", result.getResponse().getContentAsString());
    }

    @Test
    void integerToHexadecimal() throws Exception {
        Mockito.when(this.calculator.integerToHexadecimal(170)).thenReturn("aa");
        RequestBuilder request = get("/calculator/integerToHexadecimal").param("number1", "170");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("aa", result.getResponse().getContentAsString());
    }
}
