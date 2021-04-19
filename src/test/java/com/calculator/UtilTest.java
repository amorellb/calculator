package com.calculator;

import com.calculator.service.Util;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UtilTest {

    @ParameterizedTest
    @ValueSource(strings = {"addition", "subtraction", "multiplication", "division", "remainder"})
    void doOperationOutput(String operation) throws Exception {
        switch (operation) {
            case "addition":
            case "multiplication":
                assertEquals(4.0, Util.doOperation(operation, 2.0, 2.0));
                break;
            case "subtraction":
            case "division":
                assertEquals(2.0, Util.doOperation(operation, 4.0, 2.0));
                break;
            case "remainder":
                assertEquals(0.0, Util.doOperation(operation, 4.0, 2.0));
                break;
            default:
                break;
        }
    }

    @Test
    void checkIsBoolean() {
        assertTrue(Util.isDouble("5.0"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"addition", "subtraction", "multiplication", "division", "remainder"})
    void checkRightOperation(String operation) {
        switch (operation) {
            case "addition":
            case "multiplication":
            case "subtraction":
            case "division":
            case "remainder":
                assertTrue(Util.isAValidOperationInput(operation));
                break;
            default:
                break;
        }
    }

    @Test
    void checkRightNumber() {
        assertTrue(Util.isAValidNumberInput(0.0));
    }
}
