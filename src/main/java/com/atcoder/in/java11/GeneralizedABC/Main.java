package com.atcoder.in.java11.GeneralizedABC;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {

    private static PrintStream out = System.out;

    public static void main(String[] args) throws FileNotFoundException {
//        Scanner scan = new Scanner(System.in);
        Scanner scan = new Scanner(new File("src/main/java/com/atcoder/in/java11/GeneralizedABC/input2.txt"));
        int k = scan.nextInt();
        int n = 64;

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= k; i++) {
            sb.append(String.valueOf((char)(i + n)));
        }

        out.println(sb.toString());
    }

}