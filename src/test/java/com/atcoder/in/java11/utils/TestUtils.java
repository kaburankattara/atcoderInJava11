package com.atcoder.in.java11.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestUtils {
    private StandardInputSnatcher in = new StandardInputSnatcher();

    public static Object execPrivateMethod(Object target, String execMethodName) {
        return execPrivateMethod(target, execMethodName);
    }

    public static Object execPrivateMethod(Object target, String execMethodName, Class[] parameterTypes, Object[] parameters) {
        try {
            Method method = target.getClass().getDeclaredMethod(execMethodName, parameterTypes);
            method.setAccessible(true);

            return method.invoke(target, parameters);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new TestException(e);
        }
    }

}