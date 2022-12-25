package com.atcoder.in.java11.CashRegister;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {

    private static PrintStream out = System.out;

    public static void main(String[] args) throws FileNotFoundException {
//        Scanner scan = new Scanner(System.in);
        Scanner scan = new Scanner(new File("src/main/java/com/atcoder/in/java11/CashRegister/input3.txt"));
        String s = scan.next();
        int count = 0;
        boolean isz = false;
        for (char ch : s.toCharArray()) {
            if (ch == '0' && isz) {
                count++;
                isz = false;
                continue;
            }

            if (ch == '0' && !isz) {
                isz = true;
                continue;
            }

            if (ch != '0' && isz) {
                count = count + 2;
                isz = false;
                continue;
            }

            count++;
        }

        if (isz) {
            count++;
        }

        out.println(count);
    }

}