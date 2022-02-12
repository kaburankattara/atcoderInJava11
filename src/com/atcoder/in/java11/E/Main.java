package com.atcoder.in.java11.E;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

public class Main {

    private static String MAP_KEY_VALUE = "value";


    /**
     * やること
     * マップに詰める
     * 底辺がない行、列があれば削る
     * 回転の表現として対応する升目の変換
     * 起点の調整
     * 升目同士の判定
     *
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
//        Scanner scan = new Scanner(System.in);
        Scanner scan = new Scanner(new File("src/com/atcoder/in/java11/E/input.txt"));

        // マス目を認識
        String firstline = scan.next();
        String[] masume = firstline.split(" ");
        int H = parseInt(masume[0]);
        int W = parseInt(masume[1]);

        // Sを取得
        Map<Integer, String> smap = new HashMap<Integer, String>();
        for (int h = 0; h < H; h++) {
            smap.put(h, scan.next());
//            scan.next().charAt(0);
        }

        // Tを取得
        Map<Integer, String> tmap = new HashMap<Integer, String>();
        for (int h = 0; h < H; h++) {
            tmap.put(h, scan.next());
        }

    }

}
