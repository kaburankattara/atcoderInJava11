package com.atcoder.in.java11.ARecursiveFunction;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
//       Scanner scan = new Scanner(System.in);
       Scanner scan = new Scanner(new File("src/main/java/com/atcoder/in/java11/ARecursiveFunction/input4.txt"));
       System.out.println(fMethod(toInt(scan.next())));
    }

    public static int toInt(final String a) {
        return Integer.parseInt(a);
    }

    public static int fMethod(int n) {
        if (n == 0) {
            return 1;
        }
        return n * fMethod(n - 1);
    }
}