package com.atcoder.in.java11.RectangleDetection;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
//       Scanner scan = new Scanner(System.in);
       Scanner scan = new Scanner(new File("src/main/java/com/atcoder/in/java11/RectangleDetection/input3.txt"));

        Main main = new Main();
        S s = main.getS(scan);

        System.out.println(s.getA() + " " + s.getB());
        System.out.println(s.getC() + " " + s.getD());

    }

    public static int toInt(final String a) {
        return Integer.parseInt(a);
    }

    public S getS(Scanner scan) {
        return new S(scan);
    }

    public class S {
        public Character[][] charMap;
        public List<String> stringList;

        public S(Scanner scan) {
            charMap = new Character[10][10];
            stringList = new ArrayList<>();

            int i = 0;
            while (scan.hasNext()) {

                String s = scan.nextLine();
                stringList.add(s);

                int j = 0;
                for (char ch : s.toCharArray()) {
                    charMap[i][j] = ch;
                    j++;
                }

                i++;
            }
        }

        public int getA() {

            int a = 1;
            for (String s : stringList) {
                if (s.contains("#")) {
                    break;
                }

                a++;
            }

            return a;
        }

        public int getB() {

            int b = 9;
            for (; b >= 0; b--) {
                if (stringList.get(b).contains("#")) {
                    break;
                }

                b--;
            }

            return ++b;
        }

        public boolean hadSharp(Character[] chs) {
            for (Character ch : chs) {
                if (ch == '#') {
                    return true;
                }
            }

            return false;
        }

        public int getC() {
            for (Character[] chs : charMap) {
                if (!hadSharp(chs)) {
                    continue;
                }

                for (int j = 0; j < 10; j++) {
                    if (chs[j] == '#') {
                        return ++j;
                    }
                }
            }

            return 99;
        }

        public int getD() {

            int dLine = 9;
            for (; dLine >= 0; dLine--) {
                if (!hadSharp(charMap[dLine])) {
                    continue;
                }

                Character[] chs = charMap[dLine];
                for (int j = 9; j >= 0; j--) {
                    if (chs[j] == '#') {
                        return ++j;
                    }
                }
            }

            return 99;
        }
    }

}