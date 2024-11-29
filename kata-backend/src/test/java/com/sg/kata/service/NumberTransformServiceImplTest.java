package com.sg.kata.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class NumberTransformServiceImplTest {
     private NumberTransformServiceImpl service;

    @BeforeEach
    void setUp() {
        service = new NumberTransformServiceImpl();
    }


    @ParameterizedTest
    @CsvSource({
        "1, 1",
        "3, FOOFOO",         // Divisible par 3 et contient 3 une fois
        "33, FOOFOOFOO",     // Divisible par 3 et contient 3 deux fois
        "5, BARBAR",         // Divisible par 5 et contient 5
        "15, FOOBARBAR",        // Divisible par 3 et 5
        "7, QUIX",           // Contient 7
        "9, FOO",           // Contient 7
        "51, FOOBAR",        // Divisible par 3 et contient 5
        "53, BARFOO"
    })
    void transform_ShouldReturnExpectedResult(int input, String expected) {
        assertEquals(expected, service.transform(input));
    }

    @Test
    void transform_ShouldThrowException_WhenNumberIsNegative() {
        assertThrows(IllegalArgumentException.class, () -> service.transform(-1));
    }

    @Test
    void transform_ShouldThrowException_WhenNumberIsGreaterThan100() {
        assertThrows(IllegalArgumentException.class, () -> service.transform(101));
    }
}
