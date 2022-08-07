package com.atcoder.in.java11.WelcometoAtCoder;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
//       Scanner scan = new Scanner(System.in);
       Scanner scan = new Scanner(new File("src/main/java/com/atcoder/in/java11/WelcometoAtCoder/input2.txt"));

       int a = toInt(scan.next());
       int b = toInt(scan.next());
       int c = toInt(scan.next());
       String s = scan.next();

       System.out.println((a+b+c) + " " + s);

    }

    public static int toInt(final String a) {
        return Integer.parseInt(a);
    }

}