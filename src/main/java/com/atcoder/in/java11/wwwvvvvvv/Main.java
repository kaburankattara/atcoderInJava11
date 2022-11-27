package com.atcoder.in.java11.wwwvvvvvv;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
//        Scanner scan = new Scanner(new File("src/main/java/com/atcoder/in/java11/wwwvvvvvv/input3.txt"));

        Main main = new Main();
        String s = scan.nextLine();
        String tmpS = s.replaceAll("v", "1");
        tmpS = tmpS.replaceAll("w", "2");

        int res = 0;
        for (char ch : tmpS.toCharArray()) {
            res = res + Character.getNumericValue(ch);
        }
        System.out.println(res);
    }

}