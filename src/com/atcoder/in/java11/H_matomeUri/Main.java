package com.atcoder.in.java11.H_matomeUri;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
//        Scanner scan = new Scanner(System.in);
        Scanner scan = new Scanner(new File("src/com/atcoder/in/java11/H_matomeUri/input2.txt"));
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

        public int getUse(final int useSetArg, final int useAll) {
            int useSet = isKisu ? useSetArg : 0;
            return simpleUse + useSet + useAll;
        }

        public boolean hasZaiko(final int use, final int useSet, final int useAll) {
            return use <= getZaiko(useSet, useAll);
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
            int shohinCount = toInt(scan.nextLine());
            int kisuShohinCount = shohinCount % 2 == 0 ? shohinCount / 2 : shohinCount / 2 + 1;

            String[] shohinList2 = scan.nextLine().split(" ");

            shohinList = new Shohin[shohinCount];
            shohinListForSet = new Shohin[kisuShohinCount];
            final int zaiko1 = toInt(shohinList2[0]);
            Shohin shohin1 = new Shohin(zaiko1, true);
            this.shohinList[0] = shohin1;
            minAllZaiko = zaiko1;
            shohinListForSet[0] = shohin1;
            minSetZaiko = zaiko1;

            boolean isKisu = false;
            int idxKisu = 1;
            for (int idx = 1; idx < shohinCount; idx++) {

                final int zaiko = toInt(shohinList2[idx]);
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
            if (!shohin.hasZaiko(use, useSet, useAll)) {
                return;
            }

            shohin.simpleUse(use);
            setMinZaikosuForAll(shohin);
            setMinZaikosuForSet(idx, shohin);
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

        void print() {
            int useSum = 0;
            for (Shohin shohin : shohinList) {
                useSum = useSum + shohin.getUse(useSet, useAll);
            }
            System.out.println(useSum);
        }

        void setMinZaikosuForAll(final Shohin shohin) {
            final int zaiko = shohin.getZaiko(useSet, useAll);
            if (zaiko < minAllZaiko) {
                minAllZaiko = zaiko;
            }
        }

        void setMinZaikosuForSet(final int idx, final Shohin shohin) {
            if (shohin.isKisu) {
                setMinZaikosuForSet(shohin);
            }
        }

        void setMinZaikosuForSet(final Shohin shohin) {
            final int zaiko = shohin.getZaiko(useSet, useAll);
            if (zaiko < minSetZaiko) {
                minSetZaiko = zaiko;
            }
        }
    }
}
