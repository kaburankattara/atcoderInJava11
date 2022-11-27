package com.atcoder.in.java11.LOOKUP;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
//        Scanner scan = new Scanner(new File("src/main/java/com/atcoder/in/java11/LOOKUP/input4.txt"));

        String s = scan.nextLine();
        String t = scan.nextLine();

        if (s.contains(t)) {
            System.out.println("Yes");
            return;
        }
        System.out.println("No");
    }

}