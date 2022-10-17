package com.atcoder.in.java11.Continuous1.CheckCaseTest.testcase;

import com.atcoder.in.java11.Continuous1.CheckCaseTest.utils.CheckCaseFactory;
import com.atcoder.in.java11.Continuous1.CheckCaseTest.utils.CheckCaseRapperForTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SetTestPatternToSTest {
    private CheckCaseFactory checkCaseFactory = new CheckCaseFactory();

    @Test
    void クエスチョンが無い場合() {
        CheckCaseRapperForTest checkCase = new CheckCaseRapperForTest(checkCaseFactory.クエスチョンが無い場合());
        assertEquals("111", checkCase.setTestPatternToS("0"));
    }

    @Test
    void クエスチョンが1つの場合() {
        CheckCaseRapperForTest checkCase = new CheckCaseRapperForTest(checkCaseFactory.クエスチョンが1つの場合());
        assertEquals("101", checkCase.setTestPatternToS("0"));
        assertEquals("111", checkCase.setTestPatternToS("1"));
    }

    @Test
    void クエスチョンが2つある場合() {
        CheckCaseRapperForTest checkCase = new CheckCaseRapperForTest(checkCaseFactory.クエスチョンが2つある場合());
        assertEquals("10101", checkCase.setTestPatternToS("00"));
        assertEquals("11101", checkCase.setTestPatternToS("10"));
        assertEquals("10111", checkCase.setTestPatternToS("01"));
        assertEquals("11111", checkCase.setTestPatternToS("11"));
    }

    @Test
    void クエスチョンが3つある場合() {
        CheckCaseRapperForTest checkCase = new CheckCaseRapperForTest(checkCaseFactory.クエスチョンが3つある場合());
        assertEquals("1010101", checkCase.setTestPatternToS("000"));
        assertEquals("1110101", checkCase.setTestPatternToS("100"));
        assertEquals("1011101", checkCase.setTestPatternToS("010"));
        assertEquals("1111101", checkCase.setTestPatternToS("110"));
        assertEquals("1010111", checkCase.setTestPatternToS("001"));
        assertEquals("1110111", checkCase.setTestPatternToS("101"));
        assertEquals("1011111", checkCase.setTestPatternToS("011"));
        assertEquals("1111111", checkCase.setTestPatternToS("111"));
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
