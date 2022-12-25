package com.atcoder.in.java11.FirstQueryProblem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {

    private static PrintStream out = System.out;

    public static void main(String[] args) throws FileNotFoundException {
//        Scanner scan = new Scanner(System.in);
        Scanner scan = new Scanner(new File("src/main/java/com/atcoder/in/java11/FirstQueryProblem/input3.txt"));
        int n = scan.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scan.nextInt();
        }
        int q = scan.nextInt();
        while (scan.hasNext()) {
            int queryType = scan.nextInt();

            if (queryType == 2) {
                int idx = scan.nextInt() - 1;
                out.println(a[idx]);
                continue;
            }

            int idx = scan.nextInt() - 1;
            int value = scan.nextInt();
            a[idx] = value;

        }
    }

}