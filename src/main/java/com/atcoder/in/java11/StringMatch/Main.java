package com.atcoder.in.java11.StringMatch;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
//       Scanner scan = new Scanner(System.in);
       Scanner scan = new Scanner(new File("src/main/java/com/atcoder/in/java11/StringMatch/input3.txt"));

       String s = scan.nextLine();
       List<Character> chars = getChars(s);
       List<String> keys = getCreateKeys(chars, s);

       int resultCount = 0;
       for (String key : keys) {
           System.out.println(key + "：" + s.matches(key));
           if (s.matches(key)) {
               resultCount++;
           }
       }

       System.out.println(resultCount);
    }

    public static int toInt(final String a) {
        return Integer.parseInt(a);
    }

    public static List<Character> getChars(final String S) {
        List<Character> chars = new ArrayList<>();
        for (char ch : S.toCharArray()) {
            if (!chars.contains(ch)) {
                chars.add(ch);
            }
        }
        chars.add('.');

        return chars;
    }

    public static List<String> getCreateKeys(List<Character> chars, String s) {
        List<String> keyList = new ArrayList<>();
        // 1文字
        for (char ch: chars) {
            keyList.add(".*" + ch + ".*");
        }
        if (s.length() < 2) {
            return keyList;
        }

        // 2文字
        for (char ch: chars) {
            for (char ch2: chars) {
                String str = "" + ch + ch2;
                keyList.add(".*" + str + ".*");
            }
        }
        if (s.length() < 3) {
            return keyList;
        }
        // 3文字
        for (char ch: chars) {
            for (char ch2: chars) {
                for (char ch3: chars) {
                    String str = "" + ch + ch2 + ch3;
                    keyList.add(".*" + str + ".*");
                }
            }
        }
        return keyList;
    }

}