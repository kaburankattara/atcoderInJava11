package com.atcoder.in.java11.Intersection;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
//       Scanner scan = new Scanner(System.in);
       Scanner scan = new Scanner(new File("src/main/java/com/atcoder/in/java11/Intersection/input1.txt"));

       int redStart = toInt(scan.next());
       int redEnd = toInt(scan.next());
       int blueStart = toInt(scan.next());
       int blueEnd = toInt(scan.next());

        if (redStart < blueStart && blueStart <= redEnd && redEnd < blueEnd) {
            System.out.println(redEnd - blueStart);
            return;
        }
        if (blueStart < redStart && redStart <= blueEnd && blueEnd < redEnd) {
            System.out.println(blueEnd - redStart);
            return;
        }

        if (redStart <= blueStart && blueEnd <= redEnd) {
            System.out.println(blueEnd - blueStart);
            return;
        }
        if (blueStart <= redStart && redEnd <= blueEnd) {
            System.out.println(redEnd - redStart);
            return;
        }

        if (redStart < blueStart && redEnd < blueStart) {
           System.out.println(0);
           return;
       }
        if (blueStart < redStart && blueEnd < redStart) {
            System.out.println(0);
            return;
        }



    }

    public static int toInt(final String a) {
        return Integer.parseInt(a);
    }
}