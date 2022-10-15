package com.atcoder.in.java11.BrokenRounding;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
//       Scanner scan = new Scanner(System.in);
       Scanner scan = new Scanner(new File("src/main/java/com/atcoder/in/java11/BrokenRounding/input4.txt"));
       Main main = new Main();
        String x = scan.next();
        int k = toInt(scan.next());

        BigDecimal bd = new BigDecimal(x);
        for (int i = 1; i <= k; i++) {
            double keta = Math.pow(10, i);
            BigDecimal ketaDecimal = new BigDecimal(keta);
            BigDecimal bd2 = bd.divide(ketaDecimal);
            BigDecimal bd3 = bd2.setScale(0, BigDecimal.ROUND_HALF_UP);
            bd = bd3.multiply(ketaDecimal);
        }
        System.out.println(bd);

    }

    public static int toInt(final String a) {
        return Integer.parseInt(a);
    }


}