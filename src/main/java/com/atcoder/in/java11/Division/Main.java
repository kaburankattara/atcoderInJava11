package com.atcoder.in.java11.Division;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
//        Scanner scan = new Scanner(System.in);
        Scanner scan = new Scanner(new File("src/main/java/com/atcoder/in/java11/Division/input2.txt"));

        Main main = new Main();
        int empCount = toInt(scan.nextLine());
        Division division1 = main.getDivision(empCount);
        Division division2 = main.getEmptyDivision();
        Division division3 = main.getEmptyDivision();
        HappinessMap happinessMap = main.getHappinessMap(empCount, scan);

        happinessMap.separateDivision(division1, division2, division3);

        System.out.println(division1.getHappiness(happinessMap) + division2.getHappiness(happinessMap) + division3.getHappiness(happinessMap));
    }

    public static int toInt(final String a) {
        return Integer.parseInt(a);
    }

    public Division getDivision(int empCount) {
        return new Division(empCount);
    }
    public Division getEmptyDivision() {
        return new Division();
    }

    public HappinessMap getHappinessMap(int empCount, Scanner scan) {
        return new HappinessMap(empCount, scan);
    }

    public class Division {
        List<Integer> empList;

        public Division() {
            empList = new ArrayList<>();
        }

        public Division(int empCount) {
            this();
            for (int i = 1; i <= empCount; i++) {
                empList.add(i);
            }
        }

        public void remove(int targetNo) {
            for (Integer empNo : empList) {
                if (empNo == targetNo) {
                    empList.remove(empNo);
                    break;
                }
            }
        }

        public void add(int empNo) {
            empList.add(empNo);
        }

        public boolean hasNegative(int target, HappinessMap map) {
            for (Integer empNo : empList) {
                if (map.isNegative(target, empNo)) {
                    return true;
                }
            }
            return false;
        }

        public boolean hasEmp(int empNo) {
            return empList.contains(empNo);
        }

        public int getHappiness(HappinessMap map) {
            int result = 0;
            for (int i = 0, len = empList.size() - 1; i < len; i++) {
                for (int j = i + 1, len2 = empList.size(); j <= len; j++) {
                    String key = map.createKey(empList.get(i), empList.get(j));
                    int happiness = map.getHappiness(key);
                    result = result + happiness;
                }
            }
            return result;
        }

    }

    public class HappinessMap {
        public Map<String, Integer> happinessMap;

        public HappinessMap(int empCount, Scanner scan) {
            happinessMap = new HashMap<>();
            for (int i = 1; i < empCount; i++) {
                for (int j = i + 1; j <= empCount; j++) {
                    happinessMap.put(this.createKey(i, j), toInt(scan.next()));
                }
            }
        }

        public void separateDivision(Division division1, Division division2, Division division3) {
            for (Map.Entry entry : happinessMap.entrySet()) {
                int nowHappiness = (int)entry.getValue();
                if (0 <= nowHappiness) {
                    continue;
                }

                // TODO 10人だとバグる
                int afterEmpNo = Character.getNumericValue(entry.getKey().toString().charAt(1));

                if (!division1.hasEmp(afterEmpNo) || !division1.hasNegative(afterEmpNo, this)) {
                    continue;
                }

                division1.remove(afterEmpNo);

                if (!division2.hasNegative(afterEmpNo, this)) {
                    division2.add(afterEmpNo);
                    continue;
                }

                division3.add(afterEmpNo);
            }
        }

        public String createKey(int empNo1, int empNo2) {
            if (empNo1 < empNo2) {
                return empNo1 + "" + empNo2;
            }
            return empNo2 + "" + empNo1;
        }

        public boolean isNegative(int empNo1, int empNo2) {
                String mapKey = createKey(empNo1, empNo2);
                return happinessMap.get(mapKey) < 0;
        }

        public int getHappiness(String key) {
            return happinessMap.get(key);
        }

    }

}