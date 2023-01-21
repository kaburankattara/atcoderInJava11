package com.atcoder.in.java11.MoneyinHand;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.*;

public class Main {

    private static PrintStream out = System.out;

    public static void main(String[] args) throws FileNotFoundException {
//        Scanner scan = new Scanner(System.in);
        Scanner scan = new Scanner(new File("src/main/java/com/atcoder/in/java11/MoneyinHand/input3.txt"));

        int moneyTypeCount = scan.nextInt();
        int shiharaiKingaku = scan.nextInt();
        Saihu saihu = new Saihu(scan, moneyTypeCount);
        List<Integer> koukaList = saihu.getKoukaList();
        int maxKoukaI = koukaList.size() - 1;

        while (shiharaiKingaku != 0) {
            if (maxKoukaI < 0) {
                break;
            }
            int useKouka = koukaList.get(maxKoukaI);
            if (!saihu.hasKouka(useKouka)) {
                maxKoukaI = maxKoukaI - 1;
                continue;
            }
            if (useKouka > shiharaiKingaku) {
                maxKoukaI = maxKoukaI - 1;
                continue;
            }

            saihu.toridasu(useKouka);
            shiharaiKingaku = shiharaiKingaku - useKouka;
        }

        if (shiharaiKingaku == 0) {
            out.println("Yes");
            return;
        }
        out.println("No");
    }

}

class Saihu {
    Map<Integer, Integer> saihu = new HashMap<Integer, Integer>();

    public Saihu(Scanner scan, int moneyTypeCount) {
        for (int i = 0; i < moneyTypeCount; i++) {
            saihu.put(scan.nextInt(), scan.nextInt());
        }
    }

    public List<Integer> getKoukaList() {
        List<Integer> res = new ArrayList<>();
        for (Map.Entry entry : saihu.entrySet()) {
            res.add((Integer) entry.getKey());
        }
        return res;
    }

    public boolean hasKouka(Integer kouka) {
        return saihu.get(kouka) > 0;
    }

    public Integer toridasu(Integer kouka) {
        saihu.put(kouka, saihu.get(kouka) - 1);
        return kouka;
    }
}