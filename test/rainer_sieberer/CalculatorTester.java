package rainer_sieberer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;

import assignment3_int.Calculator;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CalculatorTester {

    private Calculator calculator;

    @BeforeEach
    void init()
    {
        calculator = new RPN();
    }

    @Test
    @DisplayName("testing simple addition")
    void testSimpleAddition()
    {
        String[] input = {"1.5","2","+"};
        assertTrue( 3.5 == calculator.calc(input));
    }

    @Test
    @DisplayName("calculating a mixed term")
    void calculateMixedTerm()
    {
        String[] input = {"5","3","-","2","/","70","*","2","/","1","+"};
        assertTrue( 36.0 == calculator.calc(input));
    }

    @Test
    @DisplayName("trying to calculate nonsense")
    void calculateLongTerm()
    {
        String[] input = {"3","1","+","5"};
        assertThrows(Exception.class, () -> calculator.calc(input));
    }

    @Test
    @DisplayName("trying to calculate nothing")
    void calculateNothing()
    {
        String[] input = new String[0];
        assertThrows(Exception.class, () -> calculator.calc(input));
    }

    @Test
    @DisplayName("invalid characters in input")
    void calculateInvalidInputInNumber()
    {
        String[] input = {"3","1asdf","+",};
        assertThrows(Exception.class, () -> calculator.calc(input));
    }

    @Test
    @DisplayName("invalid characters at operator")
    void calculateInvalidInputInsteadOp()
    {
        String[] input = {"3","1","AAAAA",};
        assertThrows(Exception.class, () -> calculator.calc(input));
    }

    @Test
    @DisplayName("division by 0")
    void calculateWithDivisonBy0()
    {
        String[] input = {"1","0","/",};
        assertThrows(Exception.class, () -> calculator.calc(input));
    }


}
