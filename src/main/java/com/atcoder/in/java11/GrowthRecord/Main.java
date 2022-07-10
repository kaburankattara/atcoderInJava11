package com.atcoder.in.java11.GrowthRecord;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
//       Scanner scan = new Scanner(System.in);
       Scanner scan = new Scanner(new File("src/main/java/com/atcoder/in/java11/GrowthRecord/input3.txt"));

        // 今の年齢
        int N = toInt(scan.next());
        // 身長を算出する歳
        int M = toInt(scan.next());
        // 身長が伸びた最後の歳
        int X = toInt(scan.next());
        // 今の身長
        int T = toInt(scan.next());
        // 伸び幅
        int D = toInt(scan.next());

        // 身長が止まってからの歳の場合
        if (X <= M) {
            System.out.println(T);
            return;
        }

        int x = X;
        int t = T;
        while (x != M) {
            t = t - D;
            x--;
        }
       System.out.println(t);
    }

    public static int toInt(final String a) {
        return Integer.parseInt(a);
    }
}