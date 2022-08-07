package com.atcoder.in.java11.Shiftonly;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
//       Scanner scan = new Scanner(System.in);
       Scanner scan = new Scanner(new File("src/main/java/com/atcoder/in/java11/Shiftonly/input3.txt"));

       int n = toInt(scan.next());
       int[] a = new int[n];

       for (int i = 0; i < n; i++) {
           a[i] = toInt(scan.next());
       }

       int canCount = 0;
       breakLabel:while (1 == 1) {
           for (int i = 0; i < n; i++) {
               int target = a[i];
               boolean isNotGusu = (target % 2) == 1;
               if (isNotGusu) {
                   break breakLabel;
               }
               a[i] = target / 2;
           }
           canCount++;
       }

       System.out.println(canCount);

    }

    public static int toInt(final String a) {
        return Integer.parseInt(a);
    }

}