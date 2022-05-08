package com.atcoder.in.java11.H_matomeUri;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
//        Scanner scan = new Scanner(System.in);
        Scanner scan = new Scanner(new File("src/com/atcoder/in/java11/H_matomeUri/input.txt"));
        Main main = new Main();

        Shohins shohins = main.getShohins(scan);
        int actionCount = parseInt(scan.nextLine());
        for (int i = 0; i < actionCount; i++) {
            shohins.use(scan.nextLine());
        }

        shohins.print();
    }

    public int toInt(final String a) {
        return Integer.parseInt(a);
    }

    public Shohins getShohins(final Scanner scan) {
        return new Shohins(scan);
    }

    public class Shohin {
        public int zaiko;
        public int syokaiZaiko;
        public boolean isKisu;

        public Shohin(final int zaiko, final boolean isKisu) {
            this.zaiko = zaiko;
            this.syokaiZaiko = zaiko;
            this.isKisu = isKisu;
        }

        public void use(final int n) {
            zaiko = zaiko - n;
        }

        public boolean hasZaiko(final int n) {
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

        public void use(final String actionStr) {
            final String[] actionItems = actionStr.split(" ");
            final char action = actionItems[0].charAt(0);

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

        public void simpleUse(final int idx, final int use) {
            Shohin shohin = this.shohinList[idx];
            if (!shohin.hasZaiko(use)) {
                return;
            }

            shohin.use(use);
            setMinZaikosuForAll(shohin);
            setMinZaikosuForSet(idx, shohin);
        }

        public void setUse(final int use) {

            if (minZaikosuForSet < use) {
                return;
            }

            for (Shohin shohin : shohinListForSet){
                shohin.use(use);
                setMinZaikosuForAll(shohin);
                setMinZaikosuForSet(shohin);
            }
        }

        public void allUse(final int use) {

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

        void setMinZaikosuForAll(final Shohin shohin) {
            if (shohin.zaiko < minZaikosuForAll) {
                minZaikosuForAll = shohin.zaiko;
            }
        }

        void setMinZaikosuForSet(final int idx, final Shohin shohin) {
            if (shohin.isKisu) {
                setMinZaikosuForSet(shohin);
            }
        }

        void setMinZaikosuForSet(final Shohin shohin) {
            if (shohin.zaiko < minZaikosuForSet) {
                minZaikosuForSet = shohin.zaiko;
            }
        }
    }
}
