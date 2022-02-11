package com.atcoder.in.java11.D;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private static String MAP_KEY_VALUE = "value";

    private static String MAP_KEY_NO_ZERO = "noZero";

    private static String MAP_KEY_ZERO = "zero";

    private static String REGEX = "(^[0]*)";

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
//        Scanner scan = new Scanner(new File("src/com/atcoder/in/java11/D/input.txt"));
        Pattern p = Pattern.compile(REGEX);

        List<Map<String,String>> list = new ArrayList<Map<String,String>>();
        while (scan.hasNext()) {
            String target = scan.next();
            Matcher matcher = p.matcher(target);

            Map<String,String> map = new HashMap<String,String>();
            map.put(MAP_KEY_VALUE, target);
            map.put(MAP_KEY_NO_ZERO, target.replaceAll(REGEX, ""));
            map.put(MAP_KEY_ZERO, matcher.find() ? matcher.group () : "");

            list.add(map);
        }

        quick_sort(list, 0, list.size() - 1);

        for (Map<String,String> result : list) {
            System.out.println(result.get(MAP_KEY_VALUE));
        }
    }

    static void quick_sort(List<Map<String,String>> d, int left, int right) {
        if (left>=right) {
            return;
        }
        Map<String,String> p = d.get((left+right)/2);
        int l = left, r = right;
        Map<String,String> tmp;
        while(l<=r) {

            while(d.get(l).get(MAP_KEY_NO_ZERO).length() < p.get(MAP_KEY_NO_ZERO).length()
                    || d.get(l).get(MAP_KEY_NO_ZERO).compareTo(p.get(MAP_KEY_NO_ZERO)) < 0
                    || (d.get(l).get(MAP_KEY_NO_ZERO).compareTo(p.get(MAP_KEY_NO_ZERO)) == 0
                        && d.get(l).get(MAP_KEY_ZERO).length() > p.get(MAP_KEY_ZERO).length())) { l++; }

            while(d.get(r).get(MAP_KEY_NO_ZERO).length() > p.get(MAP_KEY_NO_ZERO).length()
                    ||d.get(r).get(MAP_KEY_NO_ZERO).compareTo(p.get(MAP_KEY_NO_ZERO)) > 0
                    || (d.get(r).get(MAP_KEY_NO_ZERO).compareTo(p.get(MAP_KEY_NO_ZERO)) == 0
                        && d.get(r).get(MAP_KEY_ZERO).length() < p.get(MAP_KEY_ZERO).length())) { r--; }

            if (l<=r) {
                tmp = d.get(l); d.set(l, d.get(r)); d.set(r, tmp);
                l++; r--;
            }
        }
        quick_sort(d, left, r);  // ピボットより左側をクイックソート
        quick_sort(d, l, right); // ピボットより右側をクイックソート
    }
}
