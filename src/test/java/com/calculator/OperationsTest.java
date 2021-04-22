package com.calculator;

import com.calculator.service.Operations;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/*Clase para realizar tests a los método de la clase Operations*/
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class OperationsTest {

    @Test
    void normalAddition() {
        assertEquals(4.0, Operations.addition(2.0, 2.0));
    }

    @Test
    void normalSubtraction() {
        assertEquals(2.0, Operations.subtraction(4.0, 2.0));
    }

    @Test
    void normalMultiplication() {
        assertEquals(4.0, Operations.multiplication(2.0, 2.0));
    }

    @Test
    void normalDivision() throws Exception {
        assertEquals(2.0, Operations.division(4.0, 2.0));
    }

    @Test
    void normalRemainder() {
        assertEquals(0.0, Operations.remainder(4.0, 2.0));
    }
}
