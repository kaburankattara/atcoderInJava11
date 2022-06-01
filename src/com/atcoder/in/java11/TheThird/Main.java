package com.atcoder.in.java11.TheThird;

import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
//        Scanner scan = new Scanner(new File("src/com/atcoder/in/java11/TheThird/input3.txt"));

        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2, o1);
            }
        };
        List<Integer> array = new ArrayList<>();

        for (int i = 0; i < 6; i++ ) {
            array.add(toInt(scan.next()));
        }
        Collections.sort(array, comparator);

        System.out.println(array.get(2));
    }

    public static int toInt(final String a) {
        return Integer.parseInt(a);
    }

}