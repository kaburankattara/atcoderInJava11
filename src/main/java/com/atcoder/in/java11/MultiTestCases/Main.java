package com.atcoder.in.java11.MultiTestCases;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {

    private static PrintStream out = System.out;

    public static void main(String[] args) throws FileNotFoundException {
//        Scanner scan = new Scanner(System.in);
        Scanner scan = new Scanner(new File("src/main/java/com/atcoder/in/java11/MultiTestCases/input1.txt"));
        int t = scan.nextInt();

        for (int i = 0; i < t; i++) {
            Test test = new Test(scan);
            out.println(test.getKisuCount());
        }
    }

}

class Test {
    int[] numbers;

    public Test(Scanner scan) {
        int n = scan.nextInt();
        numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scan.nextInt();
        }
    }

    public int getKisuCount(){
        int count = 0;
        for (int num : numbers) {
            if (num % 2 == 1) {
                count++;
            }
        }
        return count;
    }
}
