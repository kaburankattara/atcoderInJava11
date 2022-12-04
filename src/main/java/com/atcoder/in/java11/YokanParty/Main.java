package com.atcoder.in.java11.YokanParty;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Yokan {

    int n;
    int l;
    int k;
    List<Integer> aList = new ArrayList<>();

    Yokan(Scanner scan) {
        n = scan.nextInt();
        l = scan.nextInt();
        k = scan.nextInt();

        while (scan.hasNext()) {
            aList.add(scan.nextInt());
        }
    }

    public boolean cut(int kijunScore) {
        // 何個に切れたか
        int num = 0;
        // 前回の切れ目
        int pre = 0;

        for (int i = 0; i < n; ++i) {
            // 基準スコアを超えたら切断
            if (aList.get(i) - pre >= kijunScore) {
                ++num;
                pre = aList.get(i);
            }
        }
        // 最後のピースが基準スコア以上なら加算
        if (l - pre >= kijunScore) {
            ++num;
        }

        return (num >= k + 1);
    }

}

public class Main {

    private static PrintStream out = System.out;

    public static void main(String[] args) throws FileNotFoundException {
//        Scanner scan = new Scanner(System.in);
        Scanner scan = new Scanner(new File("src/main/java/com/atcoder/in/java11/YokanParty/input5.txt"));
        Yokan yokan = new Yokan(scan);

        int left = -1;
        int right = yokan.l + 1;
        while (right - left > 1) {
            // 基準スコアを算出
            int kijunScore = (left + right) / 2;

            // 基準スコア以上でカット出来るなら、スタート位置(left)を進める
            if (yokan.cut(kijunScore)) {
                left = kijunScore;
                continue;
            }

            // 基準スコアでカット出来ないなら、基準スコアを最大の長さに設定する
            right = kijunScore;
        }

        out.println(left);
    }



}