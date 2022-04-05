package com.atcoder.in.java11.H_matomeUri;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

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

        int shohinCount = parseInt(scan.nextLine());
        String[] shohinList = scan.nextLine().split(" ");
        int actionCount = parseInt(scan.nextLine());

        Main main = new Main();

        Shohins shohins = main.getShohins(shohinList);
        while (scan.hasNext()) {
            shohins.use(scan.nextLine());
        }

        shohins.print();
    }

    public int toInt(String a) {
        return Integer.parseInt(a);
    }

    public Shohins getShohins(String[] shohinList) {
        return new Shohins(shohinList);
    }


    public class Shohin {
        public int zaiko = 0;
        public int syokaiZaiko = 0;

        public Shohin(int zaiko) {
            this.zaiko = zaiko;
            this.syokaiZaiko = zaiko;
        }

        public void use(int n) {
            zaiko = zaiko - n;
        }

        public boolean hasZaiko(int n) {
            return n <= zaiko;
        }
    }
    public class Shohins {
        public List<Shohin> shohinList = new ArrayList<>();
        public List<Shohin> shohinListForSet = new ArrayList<>();

        public int minZaikosuForSet = -1;
        public int minZaikosuForAll = -1;

        public Shohins(String[] shohinList) {

            boolean isKisu = true;
            boolean isFirst = true;

            for (String shohinZaiko : shohinList){
                int zaiko = toInt(shohinZaiko);
                Shohin shohin = new Shohin(zaiko);

                this.shohinList.add(shohin);
                if (isFirst || zaiko < minZaikosuForAll) {
                    minZaikosuForAll = zaiko;
                }

                if (isKisu) {
                    shohinListForSet.add(shohin);
                    if (isFirst || zaiko < minZaikosuForSet) {
                        minZaikosuForSet = zaiko;
                    }
                }
                isKisu = !isKisu;
                isFirst = false;
            }
        }

        public void use(String actionStr) {
            String[] action = actionStr.split(" ");

//            System.out.println("");
//            System.out.println("action：" + actionStr);
//            System.out.println("全商品の最小在庫：" + minZaikosuForAll);
//            System.out.println("セット商品の最小在庫：" + minZaikosuForSet);
//            int idx = 1;
//            for (Shohin shohin : shohinList) {
//                System.out.println("商品" + idx + "の在庫：" + shohin.zaiko);
//                idx++;
//            }

            if (action.length == 3) {
                simpleUse(toInt(action[1])-1, toInt(action[2]));
                return;
            }

            if ("2".equals(action[0])) {
                setUse(toInt(action[1]));
                return;
            }

            if ("3".equals(action[0])) {
                allUse(toInt(action[1]));
                return;
            }
        }

        public void simpleUse(int idx, int use) {
            Shohin shohin = this.shohinList.get(idx);
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
            if (idx % 2 == 0 ) {
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
