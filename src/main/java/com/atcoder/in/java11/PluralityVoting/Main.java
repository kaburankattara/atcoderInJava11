package com.atcoder.in.java11.PluralityVoting;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
//       Scanner scan = new Scanner(System.in);
       Scanner scan = new Scanner(new File("src/main/java/com/atcoder/in/java11/PluralityVoting/input4.txt"));

       String param = scan.next();
        StringBuilder sbA = new StringBuilder();
        StringBuilder sbB = new StringBuilder();
        StringBuilder sbC = new StringBuilder();
       for (char ch : param.toCharArray()) {
           if (ch == 'a') {
               sbA.append(ch);
               continue;
           }
           if (ch == 'b') {
               sbB.append(ch);
               continue;
           }
           if (ch == 'c') {
               sbC.append(ch);
               continue;
           }
       }

        char maxnName = 'a';
        int maxnValue = sbA.toString().length();

        int bLength = sbB.toString().length();
        if (maxnValue < bLength) {
            maxnName = 'b';
            maxnValue = bLength;
        }

        int cLength = sbC.toString().length();
        if (maxnValue < cLength) {
            maxnName = 'c';
        }
        System.out.print(maxnName);
    }
}