package com.atcoder.in.java11.TournamentResult;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
//       Scanner scan = new Scanner(System.in);
       Scanner scan = new Scanner(new File("src/main/java/com/atcoder/in/java11/TournamentResult/input1.txt"));

       int N = toInt(scan.nextLine());
       char[][] result = new char[N][N];
       for (int i = 0; i < N; i++) {
           String record = scan.nextLine();
           int j = 0;
           for (char ch : record.toCharArray()) {
               result[i][j] = ch;
               j++;
           }
       }

       for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!(result[i][j] == 'W' && result[j][i] == 'L')
                        && !(result[i][j] == 'L' && result[j][i] == 'W')
                        && !(result[i][j] == 'D' && result[j][i] == 'D')
                        && !(i == j && result[j][i] == '-')) {
                    System.out.println("incorrect");
                    return;
                }
            }
        }
        System.out.println("correct");
    }

    public static int toInt(final String a) {
        return Integer.parseInt(a);
    }
}