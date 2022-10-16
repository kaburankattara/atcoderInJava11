package com.atcoder.in.java11.Continuous1.CheckCaseTest.testcase;

import com.atcoder.in.java11.Continuous1.CheckCaseTest.utils.CheckCaseFactory;
import com.atcoder.in.java11.utils.TestUtils;
import com.atcoder.in.java11.Continuous1.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetTestPatterCountTest {
    private CheckCaseFactory checkCaseFactory = new CheckCaseFactory();
    private final String TEST_TARGET_METHOD = "getTestPatterCount";

    private int execTarget(Main.CheckCase checkCase) {
        return (int) TestUtils.execPrivateMethod(checkCase, TEST_TARGET_METHOD);
    }
    
    @Test
    void クエスチョンが無い場合() {
        int actual = execTarget(checkCaseFactory.クエスチョンが無い場合());
        assertEquals(0, actual);
    }

    @Test
    void クエスチョンが1つの場合() {
        int actual = execTarget(checkCaseFactory.クエスチョンが1つの場合());
        assertEquals(2, actual);
    }

    @Test
    void クエスチョンが2つある場合() {
        int actual = execTarget(checkCaseFactory.クエスチョンが2つある場合());
        assertEquals(4, actual);
    }

    @Test
    void クエスチョンが3つある場合() {
        int actual = execTarget(checkCaseFactory.クエスチョンが3つある場合());
        assertEquals(8, actual);
    }

    @Test
    void クエスチョンが最初にある場合() {
        int actual = execTarget(checkCaseFactory.クエスチョンが最初にある場合());
        assertEquals(2, actual);
    }

    @Test
    void クエスチョンが最後にある場合() {
        int actual = execTarget(checkCaseFactory.クエスチョンが最後にある場合());
        assertEquals(2, actual);
    }

    @Test
    void クエスチョンが続く場合() {
        int actual = execTarget(checkCaseFactory.クエスチョンが続く場合());
        assertEquals(8, actual);
    }

    @Test
    void 全てクエスチョンの場合() {
        int actual = execTarget(checkCaseFactory.全てクエスチョンの場合());
        assertEquals(8, actual);
    }
    
}