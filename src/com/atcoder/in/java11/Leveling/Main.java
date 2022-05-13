package com.atcoder.in.java11.Leveling;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Main main = new Main();
//        Scanner scan = new Scanner(System.in);
        Scanner scan = new Scanner(new File("src/com/atcoder/in/java11/Leveling/input2.txt"));

        Map map = main.getMap(scan);
        System.out.println(map.calcCostToTarget());

    }

    public static int toInt(final String a) {
        return Integer.parseInt(a);
    }

    public Map getMap(Scanner scan) {
        return new Map(scan);
    }

    public class Now extends Section {
        public int targetH;
        public int targetW;
//        public int withoutH;
//        public int withoutW;

        public Now(int h, int w, int targetH, int targetW) {
            super(true, h, w, 0);
            this.targetH = targetH;
            this.targetW = targetW;
//            this.withoutH = h;
//            this.withoutW = 0;
        }

        public int move(Section section) {
            this.h = section.h;
            this.w = section.w;
            int cost = section.isOk ? 0 : section.cost;
            System.out.println("座標：" + h + "," + w + "にコスト：" + cost + "で移動しました");
            section.isOk = true;
            section.cost = 0;
            return cost;
        }

        public void setNextTrget() {
            this.targetH = 0;
            this.targetW = this.w;
        }

        public boolean isTargetNow() {
            return this.h == this.targetH && this.w == this.targetW;
        }

//        public boolean isWithout(int h, int w) {
//            return h == this.withoutH && w == this.withoutW;
//        }

        public boolean isNeedTop() {
            return targetH < h;
        }
        public boolean isNeedRight() {
            return w < targetW;
        }
        public boolean isNeedLeft() {
            return targetW < w;
        }
        public boolean isNeedBottom() {
            return h < targetH;
        }
    }

    public class Section {
        public boolean isOk;
        public int h;
        public int w;
        public int cost;

        public Section(boolean isOk, int h, int w, int cost) {
            this.isOk = isOk;
            this.h = h;
            this.w = w;
            this.cost = cost;
        }

        public boolean isEquals(int h, int w) {
            return this.h == h && this.w == w;
        }

    }
    public class Sections {
        List<Section> sectionList;
        public Comparator<Section> comparator;

        public Sections(List<Section> sectionList) {
            this.sectionList = sectionList;
            this.comparator = new Comparator<Section>() {
                @Override
                public int compare(Section o1, Section o2) {
                    return Integer.compare(o1.cost, o2.cost);
                }
            };
        }

        public Section selectSection(Now now, Map map) {
            // ターゲットの方角のもののみを選ぶ
            if (!now.isNeedTop() && now.h != 0) {
                remove(now.h - 1, now.w);
            }
            if (!now.isNeedRight() && now.w != map.maxW) {
                remove(now.h, now.w + 1);
            }
            if (!now.isNeedBottom() && now.h != map.maxH) {
                remove(now.h + 1, now.w);
            }
            if (!now.isNeedLeft() && now.w != 0) {
                remove(now.h, now.w - 1);
            }

            // セクションを低コスト順にする
            sort();
            return sectionList.get(0);

        }

        public void remove(int h, int w) {
            int i = 0;
            boolean hasSection = false;
            for (Section section: sectionList) {
                if (section.isEquals(h, w)) {
                    hasSection = true;
                    break;
                }
                i++;
            }

            if (hasSection) {
                sectionList.remove(i);
            }
        }

        public int hasCountByCost(int cost) {
            int count = 0;
            for (Section section : sectionList) {
                if (section.cost == cost) {
                    count++;
                }
            }
            return count;
        }

        public void sort() {
            Collections.sort(sectionList, comparator);
        }

    }
    public class Map {
        public Section[][] sections;
        public int cost;
        int maxH;
        int maxW;

        public Map(Scanner scan) {
            maxH = toInt(scan.next()) - 1;
            maxW = toInt(scan.next()) - 1;

            sections = new Section[maxH + 1][maxW + 1];
            cost = 0;

            for (int i = 0; i <= maxH; i++) {
                for (int j = 0; j <= maxW; j++) {
                    sections[i][j] = new Section(false, i, j, toInt(scan.next()));
                }
            }

            sections[maxH][0].isOk = true;
            sections[maxH][maxW].isOk = true;
        }

        public Section getSection(int h, int w) {
            return sections[h][w];
        }

        public Sections getCanMoveSections(Now now) {

            List<Section> sectionList = new ArrayList<>();

            // top
            if (now.h > 0) {
                int h = now.h - 1;
                int w = now.w;
                sectionList.add(getSection(h, w));
//                if (!now.isWithout(h, w)) {
//                    sectionList.add(getSection(h, w));
//                }
            }

            // right
            if (now.w < this.maxW) {
                int h = now.h;
                int w = now.w + 1;
                sectionList.add(getSection(h, w));
//                if (!now.isWithout(h, w)) {
//                    sectionList.add(getSection(h, w));
//                }
            }

            // bottom
            if (now.h < this.maxH) {
                int h = now.h + 1;
                int w = now.w;
                sectionList.add(getSection(h, w));
//                if (!now.isWithout(h, w)) {
//                    sectionList.add(getSection(h, w));
//                }
            }

            // left
            if (now.w > 0) {
                int h = now.h;
                int w = now.w - 1;
                sectionList.add(getSection(h, w));
//                if (!now.isWithout(h, w)) {
//                    sectionList.add(getSection(h, w));
//                }
            }

            return new Sections(sectionList);
        }

        public int calcCostToTarget() {
            int resultCost = 0;

            // スタート位置を決める
            Now now = new Now(maxH, 0, maxH, maxW);

            // 第一ゴールにたどり着くまでループする
            while (!now.isTargetNow()) {
                // 移動の選択肢を取得する
                Sections sections = getCanMoveSections(now);

                // 移動する向きを優先にコストの低い方角を選択する
                Section nextSection = sections.selectSection(now, this);

                // 移動する
                int cost = now.move(nextSection);

                resultCost = resultCost + cost;
            }

            // スタート位置を決める
            now.setNextTrget();

            // 第一ゴールにたどり着くまでループする
            while (!now.isTargetNow()) {
                // 移動の選択肢を取得する
                Sections sections = getCanMoveSections(now);

                // 移動する向きを優先にコストの低い方角を選択する
                Section nextSection = sections.selectSection(now, this);

                // 移動する
                now.move(nextSection);
                resultCost = resultCost + nextSection.cost;
            }

            return resultCost;
        }
    }


}