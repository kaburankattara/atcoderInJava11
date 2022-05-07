package com.atcoder.in.java11.H_matomeUri;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Main {

    /**
     * H - まとめ売り  /
     * 実行時間制限: 4 sec / メモリ制限: 1024 MB
     *
     * 注意
     * この問題に対する言及は、2019年12月29日 05:00 JST まで禁止されています。言及がなされた場合、賠償が請求される可能性があります。
     *
     * 試験後に総合得点や認定級を公表するのは構いませんが、どの問題が解けたかなどの情報は発信しないようにお願いします。
     *
     * 問題文
     * あなたは、トレーディングカードを販売しようとしている。 それぞれのカードの種類には 1,...,N の番号がついている。 はじめ、カード i(1≦i≦N) の在庫数は C
     * i
     * ​
     *   枚である。
     *
     * あなたは、以下のような Q 件のクエリ S
     * 1
     * ​
     *  ,…,S
     * Q
     * ​
     *   を順番に処理しなければならない。
     *
     * 単品販売：カード x を a 枚販売する。ただし、在庫が足りない場合は何もしない。1 x a という形式で与えられる。
     * セット販売：番号が奇数であるカードをそれぞれ a 枚ずつ販売する。ただし、一種類でも在庫が足りない場合は何もしない。2 a という形式で与えられる。
     * 全種類販売：カードを全種類 a 枚ずつ販売する。ただし、一種類でも在庫が足りない場合は何もしない。3 a という形式で与えられる。
     * 最終的に販売するカードの合計枚数を出力せよ。
     *
     * 制約
     * 1≦N≦200,000
     * 1≦C
     * i
     * ​
     *  ≦10
     * 9
     *
     * 1≦Q≦200,000
     * S
     * i
     * ​
     *   は以下のいずれかの形式の文字列である。
     * 1 x a (1≦x≦N かつ 1≦a≦10
     * 9
     *  )
     * 2 a (1≦a≦10
     * 9
     *  )
     * 3 a (1≦a≦10
     * 9
     *  )
     * 入力で与えられる数は全て整数である。
     *
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
//        Scanner scan = new Scanner(System.in);
        Scanner scan = new Scanner(new File("src/com/atcoder/in/java11/H_matomeUri/input.txt"));
        Main main = new Main();

        Shohins shohins = main.getShohins(scan);
        int actionCount = parseInt(scan.nextLine());
        while (scan.hasNext()) {
            shohins.use(scan.nextLine());
        }

        shohins.print();
    }

    public int toInt(String a) {
        return Integer.parseInt(a);
    }

    public Shohins getShohins(final Scanner scan) {
        return new Shohins(scan);
    }


    public class Shohin {
        public int zaiko = 0;
        public int syokaiZaiko = 0;
        public boolean isKisu;

        public Shohin(final int zaiko, final boolean isKisu) {
            this.zaiko = zaiko;
            this.syokaiZaiko = zaiko;
            this.isKisu = isKisu;
        }

        public void use(int n) {
            zaiko = zaiko - n;
        }

        public boolean hasZaiko(int n) {
            return n <= zaiko;
        }
    }

    public class Shohins {
        public Shohin[] shohinList;
        public Shohin[] shohinListForSet;

        public int minZaikosuForSet;
        public int minZaikosuForAll;

        public Shohins(final Scanner scan) {
            int shohinCount = toInt(scan.nextLine());
            int kisuShohinCount = shohinCount % 2 == 0 ? shohinCount / 2 : shohinCount / 2 + 1;

            String[] shohinList2 = scan.nextLine().split(" ");

            shohinList = new Shohin[shohinCount];
            shohinListForSet = new Shohin[kisuShohinCount];
            final int zaiko1 = toInt(shohinList2[0]);
            Shohin shohin1 = new Shohin(zaiko1, true);
            this.shohinList[0] = shohin1;
            minZaikosuForAll = zaiko1;
            shohinListForSet[0] = shohin1;
            minZaikosuForSet = zaiko1;

            boolean isKisu = false;
            int idxKisu = 1;
            for (int idx = 1; idx < shohinCount; idx++) {
                final int zaiko = toInt(shohinList2[idx]);
                Shohin shohin = new Shohin(zaiko, isKisu);
                this.shohinList[idx] = shohin;

                if (zaiko < minZaikosuForAll) {
                    minZaikosuForAll = zaiko;
                }

                if (isKisu) {
                    shohinListForSet[idxKisu] = shohin;
                    if (zaiko < minZaikosuForSet) {
                        minZaikosuForSet = zaiko;
                    }
                    idxKisu++;
                }
                isKisu = !isKisu;
            }

        }

        public void use(String actionStr) {
            String[] actionItems = actionStr.split(" ");
            char action = actionItems[0].charAt(0);

            if (action == '1') {
                simpleUse(toInt(actionItems[1])-1, toInt(actionItems[2]));
                return;
            }

            if (action == '2') {
                setUse(toInt(actionItems[1]));
                return;
            }

            if (action == '3') {
                allUse(toInt(actionItems[1]));
                return;
            }
        }

        public void simpleUse(int idx, int use) {
            Shohin shohin = this.shohinList[idx];
            if (!shohin.hasZaiko(use)) {
                return;
            }

            shohin.use(use);
            setMinZaikosuForAll(shohin);
            setMinZaikosuForSet(idx, shohin);
        }

        public void setUse(int use) {

            if (minZaikosuForSet < use) {
                return;
            }

            for (Shohin shohin : shohinListForSet){
                shohin.use(use);
                setMinZaikosuForAll(shohin);
                setMinZaikosuForSet(shohin);
            }
        }

        public void allUse(int use) {

            if (minZaikosuForAll < use) {
                return;
            }

            for (Shohin shohin : shohinList) {
                shohin.use(use);
                setMinZaikosuForAll(shohin);
            }
        }

        void print() {
            int useSum = 0;
            for (Shohin shohin : shohinList) {
                useSum = useSum + (shohin.syokaiZaiko - shohin.zaiko);
            }
            System.out.println(useSum);
        }

        void setMinZaikosuForAll(Shohin shohin) {
            if (shohin.zaiko < minZaikosuForAll) {
                minZaikosuForAll = shohin.zaiko;
            }
        }

        void setMinZaikosuForSet(int idx, Shohin shohin) {
            if (shohin.isKisu) {
                setMinZaikosuForSet(shohin);
            }
        }

        void setMinZaikosuForSet(Shohin shohin) {
            if (shohin.zaiko < minZaikosuForSet) {
                minZaikosuForSet = shohin.zaiko;
            }
        }
    }
}
