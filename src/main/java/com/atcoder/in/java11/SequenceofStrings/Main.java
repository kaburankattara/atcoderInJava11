package com.atcoder.in.java11.SequenceofStrings;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {

    private static PrintStream out = System.out;

    public static void main(String[] args) throws FileNotFoundException {
//        Scanner scan = new Scanner(System.in);
        Scanner scan = new Scanner(new File("src/main/java/com/atcoder/in/java11/SequenceofStrings/input2.txt"));
        int n = scan.nextInt();
        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            strings[i] = scan.next();
        }

        for (int i = n - 1; i > -1; i--) {
            out.println(strings[i]);
        }
    }

}