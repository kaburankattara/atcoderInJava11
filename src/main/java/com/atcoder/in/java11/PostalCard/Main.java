package com.atcoder.in.java11.PostalCard;

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
        Scanner scan = new Scanner(new File("src/main/java/com/atcoder/in/java11/PostalCard/input1.txt"));
        int n = scan.nextInt();
        int m = scan.nextInt();
        String[] s = new String[n];
        List<String> t = new ArrayList();

        for(int i = 0; i < n; i++) {
            s[i] = scan.next();
        }
        for(int i = 0; i < m; i++) {
            String t2 = scan.next();
            if (!t.contains(t2)) {
                t.add(t2);
            }
        }

        int res = 0;
        for (String s2 : s) {
            int len =s2.length();
            for (String t2 : t) {
                if (s2.substring(len - 3).equals(t2)) {
                    res++;
                }
            }
        }

        out.println(res);
    }

}