package com.atcoder.in.java11.RANDOM;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
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
        Map<String, Integer> sWidthsRes = new HashMap<>();
        for (StringBuilder sb : sWidths) {
            String key = sb.toString();
            sWidthsRes.put(key,sWidthsRes.getOrDefault(key,0) + 1);
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
        Map<String, Integer> tWidthsRes = new HashMap<>();
        for (StringBuilder sb : tWidths) {
            String key = sb.toString();
            tWidthsRes.put(key,tWidthsRes.getOrDefault(key,0) + 1);
        }

        for (Map.Entry sStr : sWidthsRes.entrySet()) {
            String key = (String) sStr.getKey();
            int value = (int) sStr.getValue();
            // 列が一致しなければ、スキップ
            if (!tWidthsRes.containsKey(key)) {
                System.out.println("No");
                return;
            }

            tWidthsRes.put(key, tWidthsRes.get(key) - value);
            if (tWidthsRes.get(key).compareTo(0) == 0) {
                tWidthsRes.remove(key);
            } else if (tWidthsRes.get(key).compareTo(0) < 0) {
                System.out.println("No");
                return;
            }
        }

        System.out.println("Yes");
    }

    public static int toInt(final String a) {
        return Integer.parseInt(a);
    }

}