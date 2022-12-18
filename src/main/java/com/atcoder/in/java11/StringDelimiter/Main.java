package com.atcoder.in.java11.StringDelimiter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static PrintStream out = System.out;

    public static void main(String[] args) throws FileNotFoundException {
//        Scanner scan = new Scanner(System.in);
        Scanner scan = new Scanner(new File("src/main/java/com/atcoder/in/java11/StringDelimiter/input3.txt"));

        int n = scan.nextInt();
        String s = scan.next();

        StringManager stringManager = new StringManager(s);
        stringManager.convert();
        out.println(stringManager.getString());
    }

}

class StringManager {

    public  StringManager(String s) {
        StringBuilder sb = new StringBuilder();
        boolean isStarted = false;
        for (char ch : s.toCharArray()) {
            if ((sb.length() == 0) && ch == '"') {
                isStarted = true;
                sb.append(ch);
                continue;
            }

            if (!(sb.length() == 0) && ch == '"' && isStarted) {
                sb.append(ch);
                strings.add(sb.toString());
                sb = new StringBuilder();
                isStarted = false;

                continue;
            }

            if (!(sb.length() == 0) && ch == '"' && !isStarted) {
                strings.add(sb.toString());
                sb = new StringBuilder();
                sb.append(ch);
                isStarted = true;

                continue;
            }

            if (ch != '"') {
                sb.append(ch);
                continue;
            }
        }

        if (!(sb.length() == 0)) {
            strings.add(sb.toString());
        }
    }

    List<String> strings = new ArrayList<>();

    public void convert() {
        for (int i = 0, len = strings.size(); i < len; i++) {
            String s = strings.get(i);
            if (s.charAt(0) != '"') {
                strings.set(i, s.replaceAll(",", "."));
            }
        }
    }

    public String getString() {
        StringBuilder sb = new StringBuilder();
        for (String s : strings) {
            sb.append(s);
        }
        return sb.toString();
    }
}