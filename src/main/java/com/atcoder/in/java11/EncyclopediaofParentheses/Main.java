package com.atcoder.in.java11.EncyclopediaofParentheses;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.*;

public class Main {

   private static PrintStream out = System.out;

    public static void main(String[] args) throws FileNotFoundException {
//        Scanner scan = new Scanner(System.in);
        Scanner scan = new Scanner(new File("src/main/java/com/atcoder/in/java11/EncyclopediaofParentheses/input4.txt"));
        int n = scan.nextInt();

        // 奇数は全て不正
        if (n % 2 == 1) {
            return;
        }

        List<String> patternList = getBit(n, true);
        List<String> resultList = new ArrayList<>();
        pattern : for (String pattern : patternList) {
            // 整合性判定
            int isOK = 0;
            StringBuilder sb = new StringBuilder();
            for (char ch : pattern.toCharArray()) {
                if (isOK < 0) {
                    continue pattern;
                }

                if (ch == '0') {
                    sb.append('(');
                    isOK++;
                    continue;
                }

                sb.append(')');
                isOK--;
            }

            if (isOK != 0) {
                continue;
            }

            resultList.add(sb.toString());
        }

        // ソート
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        };
        Collections.sort(resultList, comparator);

        for (String result : resultList) {
            out.println(result);
        }
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
            sb3.append(padding.toString());
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