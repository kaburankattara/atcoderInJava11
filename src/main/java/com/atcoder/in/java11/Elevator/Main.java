package com.atcoder.in.java11.Elevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
//       Scanner scan = new Scanner(System.in);
       Scanner scan = new Scanner(new File("src/main/java/com/atcoder/in/java11/Elevator/input4.txt"));

       String f1 = scan.next();
       String f2 = scan.next();

        if (f1.contains("F") && f2.contains("F")) {
            int f1n = toInt(f1.substring(0,1));
            int f2n = toInt(f2.substring(0,1));
            int max = Math.max(f1n, f2n);
            int min = Math.min(f1n, f2n);
            System.out.print(max - min);
            return;
        }
        if (f1.contains("B") && f2.contains("B")) {
            int f1n = toInt(f1.substring(1,2));
            int f2n = toInt(f2.substring(1,2));
            int max = Math.max(f1n, f2n);
            int min = Math.min(f1n, f2n);
            System.out.print(max - min);
            return;
        }

        int f1n = toInt(f1.replaceAll("F", "").replaceAll("B", ""));
        int f2n = toInt(f2.replaceAll("F", "").replaceAll("B", ""));
        System.out.print(f1n + f2n - 1);
    }

    public static int toInt(final String a) {
        return Integer.parseInt(a);
    }

}