package com.atcoder.in.java11.Continuous1.CheckCaseTest.utils;

import com.atcoder.in.java11.Continuous1.Main;
import com.atcoder.in.java11.utils.TestUtils;

public class CheckCaseRapperForTest {

    private Main.CheckCase checkCase;

    public CheckCaseRapperForTest(Main.CheckCase checkCase) {
        this.checkCase = checkCase;
    }

    public int findQuestionCount() {
        return (int)TestUtils.execPrivateMethod(checkCase, "findQuestionCount");
    }

    public int getTestPatterCount() {
        return (int) TestUtils.execPrivateMethod(checkCase, "getTestPatterCount");
    }

    public String createTestPattern(int testPattern) {
        Class[] parameterTypes = new Class[] {int.class};
        Object[] parameters = new Object[] { testPattern };
        return (String) TestUtils.execPrivateMethod(checkCase, "createTestPattern", parameterTypes, parameters);
    }

    public String setTestPatternToS(String testPattern) {
        Class[] parameterTypes = new Class[] {String.class};
        Object[] parameters = new Object[] { testPattern };
        return (String) TestUtils.execPrivateMethod(checkCase, "setTestPatternToS", parameterTypes, parameters);
    }

    public int getOneCount(String testPattern) {
        Class[] parameterTypes = new Class[] {String.class};
        Object[] parameters = new Object[] { testPattern };
        return (int) TestUtils.execPrivateMethod(checkCase, "getOneCount", parameterTypes, parameters);
    }

}