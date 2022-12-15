package com.atcoder.in.java11.Frog1;

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
        Scanner scan = new Scanner(new File("src/main/java/com/atcoder/in/java11/Frog1/input3.txt"));

        int n = scan.nextInt();
        List<Long> alist = new ArrayList<>();
        while (scan.hasNext()) {
            alist.add(scan.nextLong());
        }

        long[] dp = new long[n];
        for (int i = 0; i < n; i++) {
            dp[i] = Long.MAX_VALUE;
        }

        dp[0] = 0;
        for (int i = 1; i < n; ++i) {

            if (i - 1 >= 0) {
                long hi = alist.get(i - 1);
                long hj = alist.get(i);
                dp[i] = Math.min(dp[i], dp[i - 1] + Math.abs(hj - hi));
            }

            if (i - 2 >= 0) {
                long hi = alist.get(i - 2);
                long hj = alist.get(i);
                dp[i] = Math.min(dp[i], dp[i - 2] + Math.abs(hj - hi));
            }
        }

        out.println(dp[n - 1]);
    }

}