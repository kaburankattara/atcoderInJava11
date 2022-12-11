package com.atcoder.in.java11.SandwichNumber;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private static PrintStream out = System.out;

    public static void main(String[] args) throws FileNotFoundException {
//        Scanner scan = new Scanner(System.in);
        Scanner scan = new Scanner(new File("src/main/java/com/atcoder/in/java11/SandwichNumber/input1.txt"));
        String s = scan.next();

        Pattern pattern = Pattern.compile("^[A-Z]{1}[0-9]{6}[A-Z]{1}$");
        Matcher matcher = pattern.matcher(s);
        if (matcher.find()) {
            int n = Integer.parseInt(s.substring(1, s.length() - 1));
            if (100000 <= n && n <= 999999) {
                System.out.println("Yes");
                return;
            }
        }
        System.out.println("No");
    }

    public static int toInt(final String a) {
        return Integer.parseInt(a);
    }

}