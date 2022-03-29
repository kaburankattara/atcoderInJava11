package com.atcoder.in.java11.E_logofsns;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

public class Main {


    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
//        Scanner scan = new Scanner(new File("src/com/atcoder/in/java11/E_logofsns/input.txt"));

        // マス目を認識
        String firstline = scan.nextLine();
        String[] param = firstline.split(" ");
        int peoplecount = parseInt(param[0]);

        // sns利用者別にmapをセット
        Main main = new Main();
        Peoples peoples = main.createPeoples(peoplecount);

        while (scan.hasNext()) {
            peoples.action(scan.nextLine());
        }

        peoples.print();

    }

    public int toInt(String a) {
        return Integer.parseInt(a);
    }


    public Peoples createPeoples(int peopleCount) {
        return new Peoples(peopleCount);
    }

    class Peoples {

        public List<People> peopleList = new ArrayList<People>();

        Peoples(int peopleCount) {
            peopleList.add(null);
            for (int i = 1; i <= peopleCount; i++) {
                peopleList.add(i, new People());
            }
        }

        void action(String actionLine) {

            String[] param = actionLine.split(" ");
            if ("1".equals(param[0])) {
                follow(toInt(param[1]), toInt(param[2]));
                return;
            }

            if ("2".equals(param[0])) {
                followReturn(toInt(param[1]));
                return;
            }

            if ("3".equals(param[0])) {
                followFollow(toInt(param[1]));
                return;
            }
        }

        void follow(int from, int to) {
            peopleList.get(from).followList.put(to, "Y");
        }

        void followReturn(int from) {
            People fromPeople = peopleList.get(from);

            int idx = 0;
            for (People toPeople : peopleList) {

                if (toPeople == null) {
                    idx++;
                    continue;
                }

                if ("Y".equals(toPeople.isFollow(from))) {
                    fromPeople.followList.put(idx, "Y");
                }
                idx++;
            }

        }

        void followFollow(int from) {
            People people = peopleList.get(from);

            if (people.followList.size() == 0) {
                return;
            }

            List<Integer> fl = new ArrayList<Integer>();
            for (int fromFollow : people.followList.keySet()) {
                fl.add(fromFollow);
            }

            for (int fromFollow : fl) {

                if (peopleList.get(fromFollow).followList.size() == 0) {
                    continue;
                }

                for (int toFollow : peopleList.get(fromFollow).followList.keySet()) {
                    peopleList.get(from).followList.put(toFollow, "Y");
                }
            }
        }

        void print() {

            if (peopleList.size() == 1) {
                return;
            }

            int idx = 1;
            peopleList.remove(0);
            for (People people : peopleList) {
                for (int i = 1; i <= peopleList.size(); i++) {
                    System.out.print(people.isFollow(i));
                }
                idx++;
                System.out.println();
            }
        }
    }

    public class People {
        public Map<Integer, String> followList = new HashMap<Integer, String>();

        public String isFollow(int idx) {
            String r = followList.get(idx);
            return r == null ? "N" : "Y";
        }
    }


}
