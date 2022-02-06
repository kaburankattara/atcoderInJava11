package com.atcoder.in.java11.A;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        char n = 'n';
        char o = 'o';
        char x = 'x';

        int maxccount = 0;
        char maxcountChar = n;
        int ccount = 0;
        char countChar = n;
        for (char ch: str.toCharArray()) {

            if (o == ch) {
                if (o != countChar) {
                    countChar = o;
                    ccount = 0;
                }
                ccount++;

                if (ccount > maxccount) {
                    maxccount = ccount;
                    maxcountChar = countChar;
                }

                continue;
            }

            if (x == ch) {
                if (x != countChar) {
                    countChar = x;
                    ccount = 0;
                }
                ccount++;

                if (ccount > maxccount) {
                    maxccount = ccount;
                    maxcountChar = countChar;
                }

                continue;
            }

            countChar = n;
        }

        scan.close();

        if (maxccount > 2) {
            if (o == maxcountChar) {
                System.out.println(o);
                return;
            }

            System.out.println(x);
            return;
        }

        System.out.println("draw");
        scan.close();
    }
}
