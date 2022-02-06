package com.atcoder.in.java11.A;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        scan.close();

        char[] chars = str.toCharArray();
        String result = "draw";
        if (chars[0] == chars[1] && chars[1] == chars[2]) {
            result = chars[0] == 'o' ? "o" : "x";
        }

        if (chars[1] == chars[2] && chars[2] == chars[3]) {
            result = chars[1] == 'o' ? "o" : "x";
        }

        if (chars[2] == chars[3] && chars[3] == chars[4]) {
            result = chars[2] == 'o' ? "o" : "x";
        }

        System.out.println(result);
    }
}
