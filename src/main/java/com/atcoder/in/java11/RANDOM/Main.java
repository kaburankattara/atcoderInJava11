package com.atcoder.in.java11.RANDOM;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
//        Scanner scan = new Scanner(System.in);
        Scanner scan = new Scanner(new File("src/main/java/com/atcoder/in/java11/RANDOM/input4.txt"));

        String[] firstStr = scan.nextLine().split(" ");
        final int h = toInt(firstStr[0]);
        final int w = toInt(firstStr[1]);

        // 図Sをリストで表現
        List<List<Character>> sWidths = new ArrayList<>();
        for (int i = 0; i < w; i++) {
            sWidths.add(new ArrayList<>());
        }
        for (int i = 0; i < h; i++) {
            String wValue = scan.nextLine();
            int j = 0;
            for (char ch : wValue.toCharArray()) {
                sWidths.get(j).add(ch);
                j++;
            }
        }

        // 図Tをリストで表現
        List<List<Character>> tWidths = new ArrayList<>();
        for (int i = 0; i < w; i++) {
            tWidths.add(new ArrayList<>());
        }
        for (int i = 0; i < h; i++) {
            String wValue = scan.nextLine();
            int j = 0;
            for (char ch : wValue.toCharArray()) {
                tWidths.get(j).add(ch);
                j++;
            }
        }

        for (List<Character> sStr : sWidths) {
            boolean isMatch = false;
            int currentI = 0;
            for (List<Character> tStr : tWidths) {
                // 列が一致しなければ、スキップ
                if (!isEquals(sStr, tStr, h)) {
                    currentI++;
                    continue;
                }

                isMatch = true;
                break;
            }

            // 図Sの列にマッチする列が図Tになければ、結果はNo
            if (!isMatch) {
                System.out.println("No");
                return;
            }

            tWidths.remove(currentI);

        }

        System.out.println("Yes");
    }

    public static int toInt(final String a) {
        return Integer.parseInt(a);
    }

    public static boolean isEquals(final List<Character> list1, final List<Character> list2, final int length) {
        for (int i = 0; i < length; i++) {
            if (!(list1.get(i).charValue() == list2.get(i).charValue())) {
                return false;
            }
        }
        return true;
    }
}