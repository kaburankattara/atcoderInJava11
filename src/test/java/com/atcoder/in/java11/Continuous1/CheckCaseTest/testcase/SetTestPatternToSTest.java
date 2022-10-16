package com.atcoder.in.java11.Continuous1.CheckCaseTest.testcase;

import com.atcoder.in.java11.Continuous1.CheckCaseTest.utils.CheckCaseFactory;
import com.atcoder.in.java11.utils.TestUtils;
import com.atcoder.in.java11.Continuous1.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SetTestPatternToSTest {
    private CheckCaseFactory checkCaseFactory = new CheckCaseFactory();
    private final String TEST_TARGET_METHOD = "setTestPatternToS";

    private String execTarget(Main.CheckCase checkCase, String testPattern) {
        Class[] parameterTypes = new Class[] {String.class};
        Object[] parameters = new Object[] { testPattern };
        return (String) TestUtils.execPrivateMethod(checkCase, TEST_TARGET_METHOD, parameterTypes, parameters);
    }

    @Test
    void クエスチョンが無い場合() {
        Main.CheckCase checkCase = checkCaseFactory.クエスチョンが無い場合();
        String actual = execTarget(checkCase, "0");
        assertEquals("111", actual);
    }

    @Test
    void クエスチョンが1つの場合() {
        Main.CheckCase checkCase = checkCaseFactory.クエスチョンが1つの場合();
        String actual = execTarget(checkCase, "0");
        assertEquals("101", actual);

        actual = execTarget(checkCase, "1");
        assertEquals("111", actual);
    }

    @Test
    void クエスチョンが2つある場合() {
        Main.CheckCase checkCase = checkCaseFactory.クエスチョンが2つある場合();
        String actual = execTarget(checkCase, "00");
        assertEquals("10101", actual);

        actual = execTarget(checkCase, "10");
        assertEquals("11101", actual);

        actual = execTarget(checkCase, "01");
        assertEquals("10111", actual);

        actual = execTarget(checkCase, "11");
        assertEquals("11111", actual);
    }

    @Test
    void クエスチョンが3つある場合() {
        Main.CheckCase checkCase = checkCaseFactory.クエスチョンが3つある場合();

        String actual = execTarget(checkCase, "000");
        assertEquals("1010101", actual);

        actual = execTarget(checkCase, "100");
        assertEquals("1110101", actual);

        actual = execTarget(checkCase, "010");
        assertEquals("1011101", actual);

        actual = execTarget(checkCase, "110");
        assertEquals("1111101", actual);

        actual = execTarget(checkCase, "001");
        assertEquals("1010111", actual);

        actual = execTarget(checkCase, "101");
        assertEquals("1110111", actual);

        actual = execTarget(checkCase, "011");
        assertEquals("1011111", actual);

        actual = execTarget(checkCase, "111");
        assertEquals("1111111", actual);
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
