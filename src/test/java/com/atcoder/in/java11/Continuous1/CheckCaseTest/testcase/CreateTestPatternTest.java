package com.atcoder.in.java11.Continuous1.CheckCaseTest.testcase;

import com.atcoder.in.java11.Continuous1.CheckCaseTest.utils.CheckCaseFactory;
import com.atcoder.in.java11.utils.TestUtils;
import com.atcoder.in.java11.Continuous1.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateTestPatternTest {
    private CheckCaseFactory checkCaseFactory = new CheckCaseFactory();
    private final String TEST_TARGET_METHOD = "createTestPattern";

    private String execTarget(Main.CheckCase checkCase, int testPattern) {
        Class[] parameterTypes = new Class[] {int.class};
        Object[] parameters = new Object[] { testPattern };
        return (String) TestUtils.execPrivateMethod(checkCase, TEST_TARGET_METHOD, parameterTypes, parameters);
    }

    @Test
    void クエスチョンが無い場合() {
        Main.CheckCase checkCase = checkCaseFactory.クエスチョンが無い場合();
        String actual = execTarget(checkCase, 0);
        assertEquals("0", actual);
    }

    @Test
    void クエスチョンが1つの場合() {
        Main.CheckCase checkCase = checkCaseFactory.クエスチョンが1つの場合();
        String actual = execTarget(checkCase, 0);
        assertEquals("0", actual);

        actual = execTarget(checkCase, 1);
        assertEquals("1", actual);
    }

    @Test
    void クエスチョンが2つある場合() {
        Main.CheckCase checkCase = checkCaseFactory.クエスチョンが2つある場合();
        String actual = execTarget(checkCase, 0);
        assertEquals("00", actual);

        actual = execTarget(checkCase, 1);
        assertEquals("10", actual);

        actual = execTarget(checkCase, 2);
        assertEquals("01", actual);

        actual = execTarget(checkCase, 3);
        assertEquals("11", actual);
    }

    @Test
    void クエスチョンが3つある場合() {
        Main.CheckCase checkCase = checkCaseFactory.クエスチョンが3つある場合();

        String actual = execTarget(checkCase, 0);
        assertEquals("000", actual);

        actual = execTarget(checkCase, 1);
        assertEquals("100", actual);

        actual = execTarget(checkCase, 2);
        assertEquals("010", actual);

        actual = execTarget(checkCase, 3);
        assertEquals("110", actual);

        actual = execTarget(checkCase, 4);
        assertEquals("001", actual);

        actual = execTarget(checkCase, 5);
        assertEquals("101", actual);

        actual = execTarget(checkCase, 6);
        assertEquals("011", actual);

        actual = execTarget(checkCase, 7);
        assertEquals("111", actual);
    }

//    @Test
//    void クエスチョンが最初にある場合() {
//        int actual = execTarget(checkCaseFactory.クエスチョンが最初にある場合());
//        assertEquals(2, actual);
//    }
//
//    @Test
//    void クエスチョンが最後にある場合() {
//        int actual = execTarget(checkCaseFactory.クエスチョンが最後にある場合());
//        assertEquals(2, actual);
//    }
//
//    @Test
//    void クエスチョンが続く場合() {
//        int actual = execTarget(checkCaseFactory.クエスチョンが続く場合());
//        assertEquals(8, actual);
//    }
//
//    @Test
//    void 全てクエスチョンの場合() {
//        int actual = execTarget(checkCaseFactory.全てクエスチョンの場合());
//        assertEquals(8, actual);
//    }

}
