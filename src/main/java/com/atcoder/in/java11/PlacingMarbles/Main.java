package com.atcoder.in.java11.PlacingMarbles;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
//       Scanner scan = new Scanner(System.in);
       Scanner scan = new Scanner(new File("src/main/java/com/atcoder/in/java11/PlacingMarbles/input2.txt"));

       String s = scan.next();

       int bidamaCount = 0;
       for (char ch : s.toCharArray()) {
           if (ch == '1') {
               bidamaCount++;
           }
       }

       System.out.println(bidamaCount);
    }

    public static int toInt(final String a) {
        return Integer.parseInt(a);
    }

}