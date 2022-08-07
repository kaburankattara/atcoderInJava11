package com.atcoder.in.java11.Product;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
//       Scanner scan = new Scanner(System.in);
       Scanner scan = new Scanner(new File("src/main/java/com/atcoder/in/java11/Product/input2.txt"));

       int a = toInt(scan.next());
       int b = toInt(scan.next());

       int c = (a * b) % 2;
       String result = c == 1 ? "Odd" : "Even";

       System.out.println(result);
    }

    public static int toInt(final String a) {
        return Integer.parseInt(a);
    }

}