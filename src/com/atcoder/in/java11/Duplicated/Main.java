package com.atcoder.in.java11.Duplicated;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
       Scanner scan = new Scanner(System.in);
//       Scanner scan = new Scanner(new File("src/com/atcoder/in/java11/Duplicated/input2.txt"));

       int N = toInt(scan.next());
       int duplicatedNum = 0;
       List<Integer> nums = new ArrayList<Integer>();
       for (int i = 0; i <= N; i++) {
           nums.add(null);
       }

       for (int i = 0; i < N; i++) {
           int num = toInt(scan.next());
           if (nums.get(num) != null) {
               duplicatedNum = num;
           }
           nums.set(num, num);
       }

       if (duplicatedNum == 0) {
           System.out.println("Correct");
           return;
       }

       for (int i = 1; i <= N; i++) {
           if (nums.get(i) == null) {
               System.out.println(duplicatedNum + " " + i);
           }
       }
    }

    public static int toInt(final String a) {
        return Integer.parseInt(a);
    }

}