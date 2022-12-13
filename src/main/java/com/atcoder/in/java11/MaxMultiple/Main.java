package com.atcoder.in.java11.MaxMultiple;

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
        Scanner scan = new Scanner(new File("src/main/java/com/atcoder/in/java11/MaxMultiple/input2.txt"));
        int n = scan.nextInt();
        int k = scan.nextInt();
        int d = scan.nextInt();
        List<Long> a = new ArrayList<>();
        while (scan.hasNext()) {
            a.add(scan.nextLong());
        }

        long[][][] dp = new long[n + 1][k + 1][d];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < k + 1; j++) {
                for (int l = 0; l < d; l++) {
                    dp[i][j][l] = -1;
                }
            }
        }

        dp[0][0][0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k + 1; j++) {
                for (int l = 0; l < d; l++) {
                    long now = dp[i][j][l];
                    if (now == -1) {
                        continue;
                    }

                    //a_i を選ばない場合の遷移
                    dp[i + 1][j][l] = dp[i + 1][j][l] > dp[i][j][l] ? dp[i + 1][j][l] : now;

                    //a_i を選ぶ場合の遷移
                    if (j != k) {
                        dp[i + 1][j + 1][((int)(l + a.get(i)) % d)] = dp[i + 1][j + 1][(int)((l + a.get(i)) % d)] > dp[i][j][l] + a.get(i) ? dp[i + 1][j + 1][(int)((l + a.get(i)) % d)] : now + a.get(i);
                    }
                }
            }
        }

        out.println(dp[n][k][0]);
    }
    
}