package com.atcoder.in.java11.Frog2;

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
        Scanner scan = new Scanner(new File("src/main/java/com/atcoder/in/java11/Frog2/input4.txt"));

        int n = scan.nextInt();
        int k = scan.nextInt();
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
            for (int j = 1; j <= k; ++j) {
                if (i - j < 0) {
                    continue;
                }
                long hi = alist.get(i - j);
                long hj = alist.get(i);
                dp[i] = Math.min(dp[i], dp[i - j] + Math.abs(hj - hi));
            }
        }

        out.println(dp[n - 1]);
    }

}