package com.atcoder.in.java11.CountConnectedComponents;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.*;

public class Main {

    private static PrintStream out = System.out;

    public static void main(String[] args) throws FileNotFoundException {
//        Scanner scan = new Scanner(System.in);
        Scanner scan = new Scanner(new File("src/main/java/com/atcoder/in/java11/CountConnectedComponents/input3.txt"));

        int n = scan.nextInt();
        int m = scan.nextInt();

        Graphs graphs = new Graphs();
        graphs.setTens(n);

        for (int i = 0; i < m; i++) {
            int u = scan.nextInt();
            int v = scan.nextInt();

            graphs.set(u, v);
        }
        out.println(graphs.renketsuSeibun());
    }
}

class Graph {
    List<Integer> tens = new ArrayList<>();

    public boolean isIn(int u, int v) {
        return tens.contains(u) || tens.contains(v);
    }

    public void add(int u, int v) {
        if (!tens.contains(u)) {
            tens.add(u);
        }
        if (!tens.contains(v)) {
            tens.add(v);
        }
    }
    public void merge(Graph graph) {
        for (Integer ten : graph.tens) {
            if (!tens.contains(ten)) {
                tens.add(ten);
            }
        }
    }
}
class Graphs {
    public Map<Integer, Integer> tens = new HashMap<>();

    public List<Graph> graphList = new ArrayList<>();

    public void setTens(int n) {
        for (int i = 1; i <= n; i++) {
            tens.put(i, i);
        }
    }

    public void set(int u, int v) {
        useTens(u, v);

        Graph graph = getAttrGraph(u, v);
        if (graph != null) {
            graph.add(u, v);
            return;
        }

        Graph newGraph = new Graph();
        newGraph.add(u, v);
        graphList.add(newGraph);
    }

    public Graph getAttrGraph(int u, int v) {
        Map<Integer, Graph> resGraphMap = new HashMap<>();
        for (int i = 0, len = graphList.size(); i < len; i++) {
            Graph graph = graphList.get(i);
            if (graph.isIn(u, v)) {
                resGraphMap.put(i, graph);
            }
        }

        int resGraphSize = resGraphMap.size();
        if (resGraphSize == 0) {
            return null;
        }

        if (resGraphSize == 1) {
            for (Map.Entry<Integer, Graph> entry : resGraphMap.entrySet()) {
                return entry.getValue();
            }
        }

        Graph dest = new Graph();
        Graph source = new Graph();
        int i = 0;
        for (Map.Entry<Integer, Graph> entry : resGraphMap.entrySet()) {
            if (i == 0) {
                dest = entry.getValue();
                i++;
                continue;
            }
            graphList.remove(entry.getKey());
            source = entry.getValue();
        }

        dest.merge(source);
        return dest;
    }

    public void useTens(int u, int v) {
        if (tens.containsKey(u)) {
            tens.remove(u);
        }
        if (tens.containsKey(v)) {
            tens.remove(v);
        }
    }

    public int renketsuSeibun() {
        return tens.size() + graphList.size();
    }
}
