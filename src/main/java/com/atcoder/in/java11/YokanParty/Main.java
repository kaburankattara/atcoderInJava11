package com.atcoder.in.java11.YokanParty;

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
        Scanner scan = new Scanner(new File("src/main/java/com/atcoder/in/java11/YokanParty/input5.txt"));
        int n = toInt(scan.next());
        int l = toInt(scan.next());
        int k = toInt(scan.next());

        List<Integer> aList = new ArrayList<>();
        while (scan.hasNext()) {
            aList.add(toInt(scan.next()));
        }

        // aのパターンを全列挙
        List<String> allPatternList = getBit(n, true);
        // aからk個切るパターンを抽出
        List<String> doPatternList = new ArrayList<>();
        for (String pattern : allPatternList) {
            int chars = (int) pattern.chars()
                    .filter(c -> c == '1')
                    .count();
            if (k == chars) {
                doPatternList.add(pattern);
            }
        }

        // 最大のスコアを算出する
        int maxScore = 0;
        for (String pattern : doPatternList) {
            int minScoreInpattern = 100000;
            int beforeDo = 0;
            for (int i = 0; i < n; i++) {
                if (pattern.charAt(i) != '1') {
                    continue;
                }

                int doIndex = aList.get(i);
                int score = doIndex - beforeDo;
                if (score < minScoreInpattern) {
                    minScoreInpattern = score;
                }

                beforeDo = doIndex;
            }

            int score = l - beforeDo;
            if (score < minScoreInpattern) {
                minScoreInpattern = score;
            }

            if (minScoreInpattern > maxScore) {
                maxScore = minScoreInpattern;
            }
        }

        out.println(maxScore);
    }

    public static int toInt(final String a) {
        return Integer.parseInt(a);
    }

    private static List<String> getBit(int length, boolean isReverse) {

        // 必要な桁数の最大値を求める
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append("1");
        }

        // 求めた最大値分、2進数を生成してListに追加する
        // 2進数は0埋めと向きに気を付ける
        List<String> result = new ArrayList<>();
        String max = sb.toString();
        int dst = Integer.parseInt(max,2);
        for (int i = 0; i <= dst; i++) {

            String pattern = Integer.toBinaryString(i);
            int paddingSize = max.length() - pattern.length();
            StringBuilder padding = new StringBuilder();
            for (int i2 = 0; i2 < paddingSize; i2++) {
                padding.append("0");
            }

            // 0埋め
            StringBuilder sb3 = new StringBuilder();
            sb3.append(padding);
            sb3.append(pattern);

            if (isReverse) {
                result.add(sb3.reverse().toString());
                continue;
            }

            result.add(sb3.toString());
        }

        return result;
    }

}