package com.atcoder.in.java11.Continuous1.CheckCaseTest.testcase;

import com.atcoder.in.java11.Continuous1.CheckCaseTest.utils.CheckCaseFactory;
import com.atcoder.in.java11.Continuous1.CheckCaseTest.utils.CheckCaseRapperForTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateTestPatternTest {
    private CheckCaseFactory checkCaseFactory = new CheckCaseFactory();

    @Test
    void クエスチョンが無い場合() {
        CheckCaseRapperForTest checkCase = new CheckCaseRapperForTest(checkCaseFactory.クエスチョンが無い場合());
        assertEquals("0", checkCase.createTestPattern(0));
    }

    @Test
    void クエスチョンが1つの場合() {
        CheckCaseRapperForTest checkCase = new CheckCaseRapperForTest(checkCaseFactory.クエスチョンが1つの場合());
        assertEquals("0", checkCase.createTestPattern(0));
        assertEquals("1", checkCase.createTestPattern(1));
    }

    @Test
    void クエスチョンが2つある場合() {
        CheckCaseRapperForTest checkCase = new CheckCaseRapperForTest(checkCaseFactory.クエスチョンが2つある場合());
        assertEquals("00", checkCase.createTestPattern(0));
        assertEquals("10", checkCase.createTestPattern(1));
        assertEquals("01", checkCase.createTestPattern(2));
        assertEquals("11", checkCase.createTestPattern(3));
    }

    @Test
    void クエスチョンが3つある場合() {
        CheckCaseRapperForTest checkCase = new CheckCaseRapperForTest(checkCaseFactory.クエスチョンが3つある場合());
        assertEquals("000", checkCase.createTestPattern(0));
        assertEquals("100", checkCase.createTestPattern(1));
        assertEquals("010", checkCase.createTestPattern(2));
        assertEquals("110", checkCase.createTestPattern(3));
        assertEquals("001", checkCase.createTestPattern(4));
        assertEquals("101", checkCase.createTestPattern(5));
        assertEquals("011", checkCase.createTestPattern(6));
        assertEquals("111", checkCase.createTestPattern(7));
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
