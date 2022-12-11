package com.atcoder.in.java11.CircularPlaylist;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static PrintStream out = System.out;

    public static void main(String[] args) throws FileNotFoundException {
//        Scanner scan = new Scanner(System.in);
        Scanner scan = new Scanner(new File("src/main/java/com/atcoder/in/java11/CircularPlaylist/input1.txt"));
        long n = scan.nextLong();
        long t = scan.nextLong();
        List<Long> ns = new ArrayList<>();
        long playListSec = 0;
        while (scan.hasNext()) {
            long sec = scan.nextLong();
            ns.add(sec);
            playListSec = playListSec + sec;
        }

        if (t > playListSec) {
            t = t % playListSec;
        }

        int now = -1;
        long nowSec = -1;
        int i = 0;
        while (t > 0) {
            // 全体再生時間から再生時間をひく
            long nsec = ns.get(i);
            t = t - nsec;
            // 今の曲
            now = i;

            if (t < 0) {
                nowSec = nsec + t;
            }

            i = i < n - 1? i + 1 : 0;
        }

        System.out.println(now + 1 + " " + nowSec);
    }

}