package com.atcoder.in.java11.B;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String N = scan.next();
        String S = scan.next();
        scan.close();

        List<Character> charList = new ArrayList<Character>();
        char[] chars = S.toCharArray();
        for (int i = Integer.parseInt(N) - 1; i >= 0; i--) {
            if (!charList.contains(chars[i])) {
                charList.add(0, chars[i]);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : charList) {
            sb.append(c);
        }

        System.out.println(sb.toString());
    }
}
