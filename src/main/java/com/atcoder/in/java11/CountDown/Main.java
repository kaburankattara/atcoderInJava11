package com.atcoder.in.java11.CountDown;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {

    private static PrintStream out = System.out;

    public static void main(String[] args) throws FileNotFoundException {
//        Scanner scan = new Scanner(System.in);
        Scanner scan = new Scanner(new File("src/main/java/com/atcoder/in/java11/CountDown/input2.txt"));
        int n = scan.nextInt();
        for(; n >= 0; n--) {
            System.out.println(n);
        }
    }

}