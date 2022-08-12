package com.example.calculator.model;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Period;

@Component
public class Calculator {
    public Double sum(Double number1, Double number2) {
        if (number1 == null || number2 == null) {
            throw new NullPointerException("Número 1 e número 2 são obrigatórios.");
        }
       return number1 + number2;
    }

    public Double sub(Double number1, Double number2) {
        if (number1 == null || number2 == null) {
            throw new NullPointerException("Número 1 e número 2 são obrigatórios.");
        }
        return number1 - number2;
    }

    public Double divide (Double number1, Double number2)  {
        if (number2 == 0) {
            throw new ArithmeticException("Divisão por zero não é permitido.");
        }
        if (number1 == null || number2 == null) {
            throw new NullPointerException("Número 1 e número 2 são obrigatórios.");
        }
        return number1 / number2;
    }

    public Integer factorial(Integer factorial) {
        if (factorial == null) {
            throw new NullPointerException("Número é obrigatório");
        }
        if (factorial==1 || factorial==0) {
            return 1;
        } else {
            return (factorial * factorial(factorial -1));
        }
    }

    // Exemplos:
    // Integer = 1 -> Binary = 1
    // Integer = 5 -> Binary = 101
    // Integer = 20 -> Binary = 10100
    public Integer integerToBinary(Integer integer) {
        return Integer.valueOf(Integer.toBinaryString(integer));
    }

    // Exemplos:
    // Integer = 1 -> Hexadecimal = "1"
    // Integer = 5 -> Hexadecimal = "37"
    // Integer = 170 -> Binary = "AA"
    public String integerToHexadecimal(Integer integer) {
        return Integer.toHexString(integer);
    }

    // Exemplos
    // Date 1 = LocalDate.of(2020, 3, 15);
    // Date 2 = LocalDate.of(2020, 3, 29)
    // Total de dias = 14
    public int calculeDayBetweenDate(LocalDate date1, LocalDate date2) {
       Period periodo = Period.between(date1, date2);
       int diferencaDia = Math.abs(periodo.getDays());
       return diferencaDia;
    }
}
