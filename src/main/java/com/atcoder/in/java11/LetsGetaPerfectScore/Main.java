package com.atcoder.in.java11.LetsGetaPerfectScore;

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
        Scanner scan = new Scanner(new File("src/main/java/com/atcoder/in/java11/LetsGetaPerfectScore/input2.txt"));
        int n = scan.nextInt();
        int m = scan.nextInt();

        char[][] s = new char[n][m];
        for (int i = 0; i < n; i++) {
            int j = 0;
            for (char res : scan.next().toCharArray()) {
                s[i][j] = res;
                j++;
            }
        }

        int okCount = 0;
        for (Pair pair : getPairs(n)) {
            if (isOK(pair, s, m)) {
                okCount++;
            }
        }

        out.println(okCount);
    }

    private static List<Pair> getPairs(int n) {
        List<Pair> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    continue;
                }
                res.add(new Pair(i, j));
            }
        }
        return res;
    }

    private static boolean isOK(Pair pair, char[][] s, int m) {
        for (int i = 0; i < m; i++) {
            char n1res = s[pair.n1][i];
            char n2res = s[pair.n2][i];

            if (n1res != 'o' && n2res != 'o') {
                return false;
            }
        }
        return true;
    }
}

class Pair {
    public Pair(int n1, int n2) {
        this.n1 = n1;
        this.n2 = n2;
    }

    public int n1;
    public int n2;
}