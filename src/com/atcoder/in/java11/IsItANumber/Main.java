package com.atcoder.in.java11.IsItANumber;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Main main = new Main();
//        Scanner scan = new Scanner(System.in);
        Scanner scan = new Scanner(new File("src/com/atcoder/in/java11/IsItANumber/input4.txt"));

        String arg = scan.next();
        boolean isOK = true;
        for (char ch : arg.toCharArray()) {
            if (!Character.isDigit(ch)) {
                System.out.println("error");
                isOK = false;
                break;
            }
        }
        if (isOK) {
            System.out.println(toInt(arg) * 2);
        }
    }

    public static int toInt(final String a) {
        return Integer.parseInt(a);
    }
}