package com.atcoder.in.java11.flip;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
//       Scanner scan = new Scanner(System.in);
       Scanner scan = new Scanner(new File("src/main/java/com/atcoder/in/java11/flip/input3.txt"));

       String s = scan.next();
       StringBuilder sb = new StringBuilder();
       for (char ch : s.toCharArray()) {
           sb.append(ch == '0' ? '1' : '0');
       }

       System.out.println(sb.toString());
    }

}