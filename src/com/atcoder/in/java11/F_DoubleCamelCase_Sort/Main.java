package com.atcoder.in.java11.F_DoubleCamelCase_Sort;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import static java.lang.Integer.parseInt;

public class Main {

    /**
     * F - DoubleCamelCase Sort
     *
     * 問題文
     * 文字列 S が与えられる。これは、1 つ以上の単語を (間に空白などを挟まずに) 連結したものである。ここで、各単語は 2 文字以上であり、最初の文字と最後の文字のみが英大文字、それ以外の文字は全て英小文字である。
     *
     * これらの単語を辞書順に並べ (大文字小文字の違いは無視する)、同様に連結して出力するプログラムを作成せよ。
     *
     * 例えば、S= FisHDoGCaTAAAaAAbCAC とする。これは FisH, DoG, CaT, AA, AaA, AbC, AC の 7 つの単語を連結したものである。これらを辞書順に並べると AA, AaA, AbC, AC, CaT, DoG, FisH となるため、AAAaAAbCACCaTDoGFisH と出力すればよい。
     *
     * 制約
     * S は長さ 2 以上 100,000 以下の文字列である。
     * S の各文字は英大文字または英小文字である。
     * S は問題文で述べたような単語の連結である。
     *
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
//        Scanner scan = new Scanner(new File("src/com/atcoder/in/java11/F_DoubleCamelCase_Sort/input.txt"));

        // マス目を認識
        String firstline = scan.nextLine();
        String[] strings = firstline.split("(?<=[A-Z])(?=[A-Z][a-z])");
        List<String> stringList = new ArrayList<>();
        for (String a : strings) {
            String[] strings2 = a.split("(?<=[A-Z])(?=[A-Z]{2})");
            for (String b : strings2) {
                stringList.add(b);
            }
        }

        String[] strings2 = stringList.toArray(new String[stringList.size()]);
        Arrays.sort(strings2);

        for (String a : strings2) {
            System.out.print(a);
        }

    }

}
