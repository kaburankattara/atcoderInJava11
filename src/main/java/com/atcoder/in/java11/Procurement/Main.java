package com.atcoder.in.java11.Procurement;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Main main = new Main();
//        Scanner scan = new Scanner(System.in);
        Scanner scan = new Scanner(new File("src/com/atcoder/in/java11/Procurement/input1.txt"));
        SetSellings setSellings = main.getSetSellings(scan);

        System.out.println(setSellings.getAnswerCost());

    }

    public static int toInt(final String a) {
        return Integer.parseInt(a);
    }


    public SetSellings getSetSellings(Scanner scan) {
        return new SetSellings(scan);
    }

    public class SetSelling {
        public int cost;
        public char[] parts;

        public SetSelling(char[] parts, int cost) {
            this.cost = cost;
            this.parts = parts;
        }

        public boolean isNeed(char[] checker, int partsTypeCount) {
            boolean isNeed = false;

            for (int i = 0; i < partsTypeCount; i++) {
                if (parts[i] == 'Y' && checker[i] == 0) {
                    isNeed = true;
                    checker[i] = 1;
                }
            }

            return isNeed;
        }

        public int getCostDivideY() {
            int i = 0;
            for (char part : parts) {
                if ('Y' == part) {
                    i++;
                }
            }

            if (i == 0) {
                return cost;
            }

            return cost / i;
        }
    }

    public class SetSellings {
        public List<SetSelling> setSellingList;
        public Comparator<SetSelling> comparator;
        public int partsTypeCount;
        public int setSellingCount;

        public SetSellings(Scanner scan) {
            List<SetSelling> setSellingList = new ArrayList<>();
            this.partsTypeCount = toInt(scan.next());
            this.setSellingCount = toInt(scan.next());

            for (int i = 0; i < setSellingCount; i++) {
                setSellingList.add(new SetSelling(scan.next().toCharArray(), toInt(scan.next())));
            }
            this.setSellingList = setSellingList;

            this.comparator = new Comparator<SetSelling>() {
                @Override
                public int compare(SetSelling o1, SetSelling o2) {
//                    return Integer.compare(o1.getCostDivideY(), o2.getCostDivideY());
                    return Integer.compare(o1.cost, o2.cost);
                }
            };

            sort();
        }

        public void sort() {
            Collections.sort(setSellingList, comparator);
        }

        public int getAnswerCost() {
            char[] checker = new char[partsTypeCount];
            for (int i = 0; i < partsTypeCount; i++) {
                checker[i] = 0;
            }

            int rcost = 0;
            for (SetSelling setSelling : setSellingList) {

                if (setSelling.isNeed(checker, partsTypeCount)) {
                    rcost = rcost + setSelling.cost;
                }

                if (isAnswerOK(checker)) {
                    return rcost;
                }
            }
            return -1;
        }

        public boolean isAnswerOK(char[] checker) {
            for (char cr : checker) {
                if (cr == 0) {
                    return false;
                }
            }
            return true;
        }

    }

}