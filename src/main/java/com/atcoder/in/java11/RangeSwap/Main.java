package com.atcoder.in.java11.RangeSwap;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {

    private static PrintStream out = System.out;

    public static void main(String[] args) throws FileNotFoundException {
//        Scanner scan = new Scanner(System.in);
        Scanner scan = new Scanner(new File("src/main/java/com/atcoder/in/java11/RangeSwap/input4.txt"));

        int n = scan.nextInt();
        int p = scan.nextInt();
        int q = scan.nextInt();
        int r = scan.nextInt();
        int s = scan.nextInt();

        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = scan.nextInt();
        }

        StringBuilder sb = new StringBuilder();
        int sa = r - p;
        for (int i = 1; i <= n; i++) {
            int res = a[i];
            if (p <= i && i <= q) {
                res = a[i + sa];
            }
            if (r <= i && i <= s) {
                res = a[i - sa];
            }
            sb.append(res + " ");
        }

        out.println(sb.toString().trim());
    }

}