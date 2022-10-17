package com.atcoder.in.java11.Continuous1.CheckCaseTest.testcase;

import com.atcoder.in.java11.Continuous1.CheckCaseTest.utils.CheckCaseFactory;
import com.atcoder.in.java11.Continuous1.CheckCaseTest.utils.CheckCaseRapperForTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindQuestionCountTest {
    private CheckCaseFactory checkCaseFactory = new CheckCaseFactory();

    @Test
    void クエスチョンが無い場合() {
        CheckCaseRapperForTest checkCase = new CheckCaseRapperForTest(checkCaseFactory.クエスチョンが無い場合());
        assertEquals(0, checkCase.findQuestionCount());
    }

    @Test
    void クエスチョンが1つの場合() {
        CheckCaseRapperForTest checkCase = new CheckCaseRapperForTest(checkCaseFactory.クエスチョンが1つの場合());
        assertEquals(1, checkCase.findQuestionCount());
    }

    @Test
    void クエスチョンが2つある場合() {
        CheckCaseRapperForTest checkCase = new CheckCaseRapperForTest(checkCaseFactory.クエスチョンが2つある場合());
        assertEquals(2, checkCase.findQuestionCount());
    }

    @Test
    void クエスチョンが3つある場合() {
        CheckCaseRapperForTest checkCase = new CheckCaseRapperForTest(checkCaseFactory.クエスチョンが3つある場合());
        assertEquals(3, checkCase.findQuestionCount());
    }

    @Test
    void クエスチョンが最初にある場合() {
        CheckCaseRapperForTest checkCase = new CheckCaseRapperForTest(checkCaseFactory.クエスチョンが最初にある場合());
        assertEquals(1, checkCase.findQuestionCount());
    }

    @Test
    void クエスチョンが最後にある場合() {
        CheckCaseRapperForTest checkCase = new CheckCaseRapperForTest(checkCaseFactory.クエスチョンが最後にある場合());
        assertEquals(1, checkCase.findQuestionCount());
    }

    @Test
    void クエスチョンが続く場合() {
        CheckCaseRapperForTest checkCase = new CheckCaseRapperForTest(checkCaseFactory.クエスチョンが続く場合());
        assertEquals(3, checkCase.findQuestionCount());
    }

    @Test
    void 全てクエスチョンの場合() {
        CheckCaseRapperForTest checkCase = new CheckCaseRapperForTest(checkCaseFactory.全てクエスチョンの場合());
        assertEquals(3, checkCase.findQuestionCount());
    }
}
