package com.atcoder.in.java11.Power;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {

    private static PrintStream out = System.out;

    public static void main(String[] args) throws FileNotFoundException {
//        Scanner scan = new Scanner(System.in);
        Scanner scan = new Scanner(new File("src/main/java/com/atcoder/in/java11/Power/input3.txt"));
        int a = scan.nextInt();
        int b = scan.nextInt();

        int res = a;
        for (int i  = 1; i < b; i++) {
            res = res * a;
        }

        out.println(res);
    }

}