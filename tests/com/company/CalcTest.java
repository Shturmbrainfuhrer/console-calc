package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalcTest {

    @Test
    void makePostfixPlusTest1() {
        var postfixExpression = Calc.makePostfix("2+3");
        assertEquals(postfixExpression, "2 3 +");
    }

    @Test
    void makePostfixPlusTest2() {
        var postfixExpression = Calc.makePostfix("25+37");
        assertEquals(postfixExpression, "25 37 +");
    }

    @Test
    void makePostfixTest1() {
        var postfixExpression = Calc.makePostfix("2+3*4");
        assertEquals(postfixExpression, "2 3 4 * +");
    }

    @Test
    void makePostfixTest2() {
        var postfixExpression = Calc.makePostfix("2+3/4");
        assertEquals(postfixExpression, "2 3 4 / +");
    }

    @Test
    void makePostfixTest3() {
        var postfixExpression = Calc.makePostfix("(21+9)*7-8");
        assertEquals(postfixExpression, "21 9 + 7 * 8 -");
    }

    @Test
    void makePostfixTest4() {
        var postfixExpression = Calc.makePostfix("(21+9)*(7-8)");
        assertEquals(postfixExpression, "21 9 + 7 8 - *");
    }

    @Test
    void makePostfixTest5() {
        var postfixExpression = Calc.makePostfix("(23+1)*2-10");
        assertEquals(postfixExpression, "23 1 + 2 * 10 -");
    }

    @Test
    void calcPostfixPlusTest() {
        assertEquals(Calc.calcPostfix("2 3 +"), 5.0);
    }

    @Test
    void calcPostfixMinusTest() {
        assertEquals(Calc.calcPostfix("2 3 -"), -1.0);
    }

    @Test
    void calcPostfixMultiplyTest() {
        assertEquals(Calc.calcPostfix("2 3 *"), 6.0);
    }

    @Test
    void calcPostfixDivideTest() {
        assertEquals(Calc.calcPostfix("6 3 /"), 2.0);
    }

    @Test
    void calcPostfixTest2() {
        assertEquals(Calc.calcPostfix("21 9 + 7 8 - *"), -30.0);
    }

    @Test
    void calcPostfixTest3() {
        assertEquals(Calc.calcPostfix("23 1 + 2 * 10 -"), 38.0);
    }
}