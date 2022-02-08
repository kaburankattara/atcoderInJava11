package com.atcoder.in.java11.C;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String N = scan.next();
        scan.close();

        System.out.println(Integer.toString(Integer.parseInt(N),36).toUpperCase());
    }
}
