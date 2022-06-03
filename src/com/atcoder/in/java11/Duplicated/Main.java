package com.atcoder.in.java11.Duplicated;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Main main = new Main();
        Scanner scan = new Scanner(System.in);
//        Scanner scan = new Scanner(new File("src/com/atcoder/in/java11/Duplicated/input2.txt"));

        Nums nums = main.getNums(scan);
        nums.duplicatedcheck(scan);
    }

    public static int toInt(final String a) {
        return Integer.parseInt(a);
    }

    public Nums getNums(Scanner scan) {
        return new Nums(scan);
    }

    public class Num {
        public int num;
        public boolean exist;
        public boolean duplicated;

        public Num(int num) {
            this.num = num;
            this.exist = false;
            this.duplicated = false;
        }

        public void setExist() {
            if (exist) {
                duplicated = true;
            }
            this.exist = true;
        }

    }

    public class Nums {
        public int N;
        public List<Num> numList;

        public Nums(Scanner scan) {
            this.N = toInt(scan.next());
            List<Num> numList = new ArrayList<>();

            for (int i = 1; i <= N; i++){
                numList.add(new Num(i));
            }
            this.numList = numList;
        }

        public void duplicatedcheck(Scanner scan) {

            for (int i = 0; i < N; i++) {
                setExist(toInt(scan.next()));
            }

            findDuplicated();
        }

        public void setExist(int n) {
            getNum(n).setExist();
        }

        public void findDuplicated() {
            Num duplicatedNum = null;
            for (Num num : numList) {
                if (num.duplicated) {
                    duplicatedNum = num;
                    break;
                }
            }

            if (duplicatedNum == null) {
                System.out.println("Correct");
                return;
            }

            Num notExistNum = null;
            for (Num num : numList) {
                if (!num.exist) {
                    notExistNum = num;
                    break;
                }
            }

            System.out.println(duplicatedNum.num + " " + notExistNum.num);

        }

        public Num getNum(int n) {
            for (Num num : numList) {
                if (num.num == n) {
                    return num;
                }
            }

            return null;
        }

    }

}