package com.atcoder.in.java11.DoubleCamelCaseSort;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
//        Scanner scan = new Scanner(System.in);
        Scanner scan = new Scanner(new File("src/main/java/com/atcoder/in/java11/DoubleCamelCaseSort/input2.txt"));

        String firstline = scan.nextLine();
        List<String> stringList = split(firstline);

        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.toUpperCase().compareTo(o2.toUpperCase());
            }
        };
        Collections.sort(stringList, comparator);

        StringBuilder sb = new StringBuilder();
        for (String str : stringList) {
            sb.append(str);
        }
        System.out.println(sb.toString());
    }

    public static int toInt(final String a) {
        return Integer.parseInt(a);
    }

    public static List<String> split(String args) {
        List<String> result = new ArrayList<>();
        boolean start = false;
        boolean stop = true;
        StringBuilder sb = new StringBuilder();
        for (char ch : args.toCharArray()) {
            if (stop && 'A' <= ch && ch <= 'Z') {
                start = true;
                stop = false;
                sb.append(ch);
                continue;
            }
            if (start && 'a' <= ch && ch <= 'z') {
                sb.append(ch);
                continue;
            }
            if (start && 'A' <= ch && ch <= 'Z') {
                start = false;
                stop = true;
                sb.append(ch);
                result.add(sb.toString());
                sb = new StringBuilder();
                continue;
            }

        }
        return result;
    }


}