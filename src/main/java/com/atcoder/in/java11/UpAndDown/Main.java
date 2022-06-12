package com.atcoder.in.java11.UpAndDown;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Main main = new Main();
//        Scanner scan = new Scanner(System.in);
        Scanner scan = new Scanner(new File("src/com/atcoder/in/java11/UpAndDown/input1.txt"));

        int dateCount = toInt(scan.next());
        int beforeDaySale = toInt(scan.next());

        for (int i = 1; i < dateCount; i++) {
            int todaySale = toInt(scan.next());
            if (beforeDaySale < todaySale) {
                System.out.println("up " + (todaySale - beforeDaySale));

            } else if (beforeDaySale > todaySale) {
                System.out.println("down " + (beforeDaySale - todaySale));

            } else {
                System.out.println("stay");

            }
            beforeDaySale = todaySale;
        }
    }

    public static int toInt(final String a) {
        return Integer.parseInt(a);
    }

}