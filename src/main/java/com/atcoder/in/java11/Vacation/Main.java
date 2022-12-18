package com.atcoder.in.java11.Vacation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static PrintStream out = System.out;

    public static void main(String[] args) throws FileNotFoundException {
//        Scanner scan = new Scanner(System.in);
        Scanner scan = new Scanner(new File("src/main/java/com/atcoder/in/java11/Vacation/input3.txt"));
        DayHappinesses dayHappinesses = new DayHappinesses(scan);
        out.println(dayHappinesses.plan());
    }

}

class DayHappinesses {
    public  DayHappinesses(Scanner scan) {
        n = scan.nextInt();
        while (scan.hasNext()) {
            dayHappinessList.add(new DayHappiness(scan));
        }
    }

    List<DayHappiness> dayHappinessList = new ArrayList<>();
    List<Task> doList = new ArrayList<>();

    long n;

    long happinessPoint;

    public long plan() {
        for (int i = 0; i < n; i++) {
            DayHappiness dayHappiness = dayHappinessList.get(i);
            Task max = dayHappiness.getMax();

            if (i - 1 < 0) {
                doList.add(max);
                addHappinessPoint(max.point);
                continue;
            }

            Task prevTask = doList.get(i - 1);
            if (max.task == prevTask.task) {
                Task second = dayHappiness.getSecondMax();
                doList.add(second);
                addHappinessPoint(second.point);
                continue;
            }

            doList.add(max);
            addHappinessPoint(max.point);
        }

        return happinessPoint;
    }
    public void addHappinessPoint(int point) {
        happinessPoint = happinessPoint + point;
    }
}

class DayHappiness {
    public  DayHappiness(Scanner scan) {
        a = new Task('a', scan.nextInt());
        b = new Task('b', scan.nextInt());
        c = new Task('c', scan.nextInt());
    }

    Task a;
    Task b;
    Task c;

    public Task getMax() {
        int tmp = Math.max(a.point, b.point);
        Task tmpTask = tmp == a.point ? a : b;

        tmp = Math.max(tmpTask.point, c.point);
        tmpTask = tmp == tmpTask.point ? tmpTask : c;
        return tmpTask;
    }

    public Task getSecondMax() {
        Task max =getMax();
        if (max.task == 'a') {
            int tmp = Math.max(b.point, c.point);
            return tmp == b.point ? b : c;
        }

        if (max.task == 'b') {
            int tmp = Math.max(a.point, c.point);
            return tmp == a.point ? a : c;
        }

        int tmp = Math.max(a.point, b.point);
        return tmp == a.point ? a : b;
    }
}

class Task {
    public Task(char task, int point) {
        this.task = task;
        this.point = point;
    }
    char task;
    int point;
}