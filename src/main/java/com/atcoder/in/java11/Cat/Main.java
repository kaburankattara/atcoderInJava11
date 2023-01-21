package com.atcoder.in.java11.Cat;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {

    private static PrintStream out = System.out;

    public static void main(String[] args) throws FileNotFoundException {
//        Scanner scan = new Scanner(System.in);
        Scanner scan = new Scanner(new File("src/main/java/com/atcoder/in/java11/Cat/input3.txt"));

        int n = scan.nextInt();
        String s =scan.next();

        out.println(s.replaceAll("na", "nya"));
    }

}