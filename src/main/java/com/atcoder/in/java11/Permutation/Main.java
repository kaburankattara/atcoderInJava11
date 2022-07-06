package com.atcoder.in.java11.Permutation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
//       Scanner scan = new Scanner(System.in);
        Scanner scan = new Scanner(new File("src/main/java/com/atcoder/in/java11/Permutation/input3.txt"));
        Main main = new Main();
        A a = main.getA(scan);
        a.print();
    }

    public static int toInt(final String a) {
        return Integer.parseInt(a);
    }

    public A getA(Scanner scan) {
        return new A(scan);
    }

    public class A {
        int n;
        int[] a;

        public A(Scanner scan) {
            n = toInt(scan.next());
            a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = toInt(scan.next());
            }

        }

        public int calc(int x) {
            int j = 0;
            int i = x - 1;
            int tmp = 0;
            while (x != tmp) {
                tmp = a[i];
                i = tmp - 1;
                j++;
            }

            return j;
        }

        public int[] getXs() {
            int[] xs = new int[n];
            for (int i = 1; i <= n; i++) {
                xs[i-1] = i;
            }
            return xs;
        }

        public void print() {
            int[] xs = getXs();
            System.out.print(calc(xs[0]));
            for (int i = 1, len = xs.length; i < len; i++) {
                System.out.print(" " + calc(xs[i]));
            }
        }

    }

}