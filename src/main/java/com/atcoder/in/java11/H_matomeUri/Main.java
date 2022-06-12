package com.atcoder.in.java11.H_matomeUri;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
//        Scanner scan = new Scanner(System.in);
        Scanner scan = new Scanner(new File("src/com/atcoder/in/java11/H_matomeUri/input2.txt"));
        Main main = new Main();

        Shohins shohins = main.getShohins(scan);
        int actionCount = toInt(scan.next());
        for (int i = 0; i < actionCount; i++) {
            shohins.use(scan);
        }

        shohins.print();
    }

    public static int toInt(final String a) {
        return Integer.parseInt(a);
    }

    public Shohins getShohins(final Scanner scan) {
        return new Shohins(scan);
    }

    public class Shohin {
        public int simpleUse;
        public int shokaiZaiko;
        public boolean isKisu;

        public Shohin(final int zaiko, final boolean isKisu) {
            this.simpleUse = 0;
            this.shokaiZaiko = zaiko;
            this.isKisu = isKisu;
        }

        public void simpleUse(final int n) {
            simpleUse = simpleUse + n;
        }

        public int getZaiko(final int useSet, final int useAll) {
            return shokaiZaiko - getUse(useSet, useAll);
        }

        public int getUse(final int useSet, final int useAll) {
            if (isKisu) {
                return simpleUse + useSet + useAll;
            }
            return simpleUse + useAll;
        }
    }

    public class Shohins {
        public Shohin[] shohinList;
        public Shohin[] shohinListForSet;

        public int minSetZaiko;
        public int minAllZaiko;
        public int useSet = 0;
        public int useAll = 0;

        public Shohins(final Scanner scan) {
            int shohinCount = toInt(scan.next());
            int kisuShohinCount = shohinCount % 2 == 0 ? shohinCount / 2 : shohinCount / 2 + 1;

            shohinList = new Shohin[shohinCount];
            shohinListForSet = new Shohin[kisuShohinCount];
            final int zaiko1 = toInt(scan.next());
            Shohin shohin1 = new Shohin(zaiko1, true);
            this.shohinList[0] = shohin1;
            minAllZaiko = zaiko1;
            shohinListForSet[0] = shohin1;
            minSetZaiko = zaiko1;

            boolean isKisu = false;
            int idxKisu = 1;
            for (int idx = 1; idx < shohinCount; idx++) {

                final int zaiko = toInt(scan.next());
                Shohin shohin = new Shohin(zaiko, isKisu);
                this.shohinList[idx] = shohin;

                if (zaiko < minAllZaiko) {
                    minAllZaiko = zaiko;
                }

                if (isKisu) {
                    shohinListForSet[idxKisu] = shohin;
                    if (zaiko < minSetZaiko) {
                        minSetZaiko = zaiko;
                    }
                    idxKisu++;
                }
                isKisu = !isKisu;
            }

        }

        public void use(final Scanner scan) {
            final char action = scan.next().charAt(0);
            final int arg1 = toInt(scan.next());

            if (action == '1') {
                simpleUse(arg1 - 1, toInt(scan.next()));
                return;
            }

            if (action == '2') {
                setUse(arg1);
                return;
            }

            if (action == '3') {
                allUse(arg1);
                return;
            }
        }

        public void simpleUse(final int idx, final int use) {
            Shohin shohin = this.shohinList[idx];
            int zaiko = shohin.getZaiko(useSet, useAll);
            if (zaiko < use) {
                return;
            }

            shohin.simpleUse(use);
            zaiko = zaiko - use;

            if (zaiko < minAllZaiko) {
                minAllZaiko = zaiko;
            }

            if (shohin.isKisu && zaiko < minSetZaiko) {
                minSetZaiko = zaiko;
            }
        }

        public void setUse(final int use) {

            if (minSetZaiko < use) {
                return;
            }

            minSetZaiko = minSetZaiko - use;
            useSet = useSet + use;

            if (minSetZaiko < minAllZaiko) {
                minAllZaiko = minSetZaiko;
            }
        }

        public void allUse(final int use) {

            if (minAllZaiko < use) {
                return;
            }

            minAllZaiko = minAllZaiko - use;
            useAll = useAll + use;

            minSetZaiko = minSetZaiko - use;
        }

        public void print() {
            int useSum = 0;
            for (Shohin shohin : shohinList) {
                useSum = useSum + shohin.getUse(useSet, useAll);
            }
            System.out.println(useSum);
        }
    }
}
