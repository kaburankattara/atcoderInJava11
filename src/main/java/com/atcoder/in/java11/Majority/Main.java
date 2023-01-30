package com.atcoder.in.java11.Majority;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {

    private static PrintStream out = System.out;

    public static void main(String[] args) throws FileNotFoundException {
//        Scanner scan = new Scanner(System.in);
        Scanner scan = new Scanner(new File("src/main/java/com/atcoder/in/java11/Majority/input3.txt"));
        int n = scan.nextInt();
        int forCount = 0;
        for (int i = 0; i < n; i++) {
            if ("For".equals(scan.next())) {
                forCount++;
            }
        }

        String res = n / 2 < forCount ? "Yes" : "No";
        out.println(res);
    }

}