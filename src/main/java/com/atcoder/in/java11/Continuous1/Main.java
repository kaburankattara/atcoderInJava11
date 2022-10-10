package com.atcoder.in.java11.Continuous1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
//       Scanner scan = new Scanner(System.in);
       Scanner scan = new Scanner(new File("src/main/java/com/atcoder/in/java11/Continuous1/input1.txt"));
       Main main = new Main();
       int T = toInt(scan.next());

       for (int i = 0; i < T; i++) {
           CheckCase checkCase = main.createCheckCase(scan);
           System.out.println(checkCase.check());
       }

    }

    public static int toInt(final String a) {
        return Integer.parseInt(a);
    }

    public CheckCase createCheckCase(final Scanner scan) {
        return new CheckCase(scan);
    }

    public class CheckCase {
        char QUESTION = '?';
        // ?の数
        int qCount;
        // sの文字数
        int n;
        // 1を続ける数
        int k;
        // 文字列
        String s;

        public CheckCase(Scanner scan) {
            this.n = toInt(scan.next());
            this.k = toInt(scan.next());
            this.s = scan.next();
            this.qCount = findQuestionCount();
        }

        public String check() {
            // 2の?乗のパターンがある
            int matchCount = 0;
            int matchStart = 0;
            int matchEnd = 0;
            for (int i = 1, len = getTestPatterCount(); i <= len; i++) {

                String testPattern = createTestPattern(i);
                String settedS = setTestPatterToS(testPattern);
                Pattern p = Pattern.compile("1{" + this.k + "}");
                int a = 1 + this.k;
                Pattern p2 = Pattern.compile("1{" + a + "}");
                Matcher matcher = p.matcher(settedS);
                Matcher matcher2 = p2.matcher(settedS);
//                System.out.println("【ケース：" + s + "】" + settedS);
                if (matcher.find() && !matcher2.find()
                        && (matchStart != matcher.start() || matchEnd != matcher.end())) {
                    matchCount++;
                    matchStart = matcher.start();
                    matchEnd = matcher.end();
                }

                // OKパターンが2回以上出たらNoにする
                if (matchCount > 1) {
                    return "No";
                }
            }

            // OKが1つで全パターンのテストが終わればYes
            // 全てNGの場合はNoにする
            return matchCount == 1 ? "Yes" : "No";
        }

        private int findQuestionCount() {
            int i = 0;
            for (char ch : s.toCharArray()) {
                if (ch == QUESTION) {
                    i++;
                }
            }

            return i;
        }

        private int getTestPatterCount() {
            int res = 1;
            for (int i = 0; i < qCount; i++) {
                res = res * 2;
            }

            return res;
        }

        private String createTestPattern(int patternNo) {
            StringBuilder sb = new StringBuilder();

            // パターン番号を2進数に変換し、逆向きの文字列で格納
            String testPattern = Integer.toBinaryString(patternNo);
            for(int i = testPattern.length() - 1; 0 <= i; i--) {
                sb.append(testPattern.substring(i, i + 1));
            }

            // 生成したパターンで桁数が足らない場合があるため、桁埋めする
            for(int i = testPattern.length() - 1; i < qCount; i++) {
                sb.append('0');
            }

            return sb.toString();
        }

        private String setTestPatterToS(String testPattern) {
            int qi = 0;

            StringBuilder sb = new StringBuilder();
            for(char ch : this.s.toCharArray() ) {
                if (ch != QUESTION) {
                    sb.append(ch);
                    continue;
                }

                sb.append(testPattern.substring(qi, qi + 1));
                qi++;
            }

            return sb.toString();
        }
    }


}