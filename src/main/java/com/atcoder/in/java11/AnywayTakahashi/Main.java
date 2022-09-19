package com.atcoder.in.java11.AnywayTakahashi;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
//       Scanner scan = new Scanner(System.in);
       Scanner scan = new Scanner(new File("src/main/java/com/atcoder/in/java11/AnywayTakahashi/input3.txt"));

       int a = toInt(scan.next());
       int b = toInt(scan.next());
       int c = toInt(scan.next());
       int d = toInt(scan.next());


       System.out.println((a + b) * (c - d));
       System.out.println("Takahashi");

    }

    public static int toInt(final String a) {
        return Integer.parseInt(a);
    }

}