package com.atcoder.in.java11.RANDOM;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_ {
    public static void main(String[] args) throws FileNotFoundException {
//        Scanner scan = new Scanner(System.in);
        Scanner scan = new Scanner(new File("src/main/java/com/atcoder/in/java11/RANDOM/input4.txt"));

        String[] firstStr = scan.nextLine().split(" ");
        int h = toInt(firstStr[0]);
        int w = toInt(firstStr[1]);

        // 図Sをリストで表現
        List<StringBuilder> sWidths = new ArrayList<>();
        for (int i = 0; i < w; i++) {
            sWidths.add(new StringBuilder());
        }
        for (int i = 0; i < h; i++) {
            String wValue = scan.nextLine();
            int j = 0;
            for (char ch : wValue.toCharArray()) {
                sWidths.get(j).append(ch);
                j++;
            }
        }
        List<String> sWidthsRes = new ArrayList<>();
        for (StringBuilder sb : sWidths) {
            sWidthsRes.add(sb.toString());
        }


        // 図Tをリストで表現
        List<StringBuilder> tWidths = new ArrayList<>();
        for (int i = 0; i < w; i++) {
            tWidths.add(new StringBuilder());
        }
        for (int i = 0; i < h; i++) {
            String wValue = scan.nextLine();
            int j = 0;
            for (char ch : wValue.toCharArray()) {
                tWidths.get(j).append(ch);
                j++;
            }
        }
        List<String> tWidthsRes = new ArrayList<>();
        for (StringBuilder sb : tWidths) {
            tWidthsRes.add(sb.toString());
        }

        for (String sStr : sWidthsRes) {
            boolean isMatch = false;
            int currentI = 0;
            for (String tStr : tWidthsRes) {
                // 列が一致しなければ、スキップ
                if (!sStr.equals(tStr)) {
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

            tWidthsRes.remove(currentI);

        }

        System.out.println("Yes");
    }

    public static int toInt(final String a) {
        return Integer.parseInt(a);
    }

}