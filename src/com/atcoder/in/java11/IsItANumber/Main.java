package com.atcoder.in.java11.IsItANumber;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
//        Scanner scan = new Scanner(new File("src/com/atcoder/in/java11/IsItANumber/input2.txt"));

        String arg = scan.next();
        Pattern p = Pattern.compile("^[0-9]+$");
        Matcher m = p.matcher(arg);

        if(m.find()){
            int num = toInt(arg);
            System.out.println(num * 2);
            return;
        }
        System.out.print("error");
    }

    public static int toInt(final String a) {
        return Integer.parseInt(a);
    }

}