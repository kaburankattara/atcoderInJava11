package com.atcoder.in.java11.Landslide;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
//       Scanner scan = new Scanner(System.in);
       Scanner scan = new Scanner(new File("src/main/java/com/atcoder/in/java11/Landslide/input3.txt"));

       int N = toInt(scan.nextLine());
       int J = 2 * N - 1;
       char[][] result = new char[N][J];
       int i = 0;
       while (i < N) {
           int j = 0;
           for (char ch :  scan.nextLine().toCharArray()) {
               result[i][j] = ch;
               j++;
           }
           i++;
       }

        i = N - 1;
        while (0 < i) {
            int j = 0;
            while (j < J) {
                if (result[i][j] != 'X') {
                    j++;
                    continue;
                }

                if (j != 0 && result[i-1][j-1] == '#') {
                    result[i-1][j-1] = 'X';
                }
                if (j != J-1 && result[i-1][j+1] == '#') {
                    result[i-1][j+1] = 'X';
                }
                if (result[i-1][j] == '#') {
                    result[i-1][j] = 'X';
                }
                j++;
            }
            i--;
        }

        i = 0;
        while (i < N) {
            StringBuilder sb = new StringBuilder();
            int j = 0;
            while (j < J) {
                sb.append(result[i][j]);
                j++;
            }
            System.out.println(sb.toString());
            i++;
        }
    }

    public static int toInt(final String a) {
        return Integer.parseInt(a);
    }

}