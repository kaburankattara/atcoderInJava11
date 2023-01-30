package com.atcoder.in.java11.PathGraph;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.*;

public class Main {

    private static PrintStream out = System.out;

    public static void main(String[] args) throws FileNotFoundException {
//        Scanner scan = new Scanner(System.in);
        Scanner scan = new Scanner(new File("src/main/java/com/atcoder/in/java11/PathGraph/input3.txt"));
        int n = scan.nextInt();
        int m = scan.nextInt();
        Graph graph = new Graph(n);
        for (int i = 1; i <= n; i++) {
            graph.addNode(new Node(i));
        }

        for (int i = 1; i <= m; i++) {
            int from = scan.nextInt();
            int to = scan.nextInt();
            graph.addPath(from, new Path(from, to));
            graph.addPath(to, new Path(to, from));
        }

        out.println(graph.isMukoGraph() ? "Yes" : "No");
    }
}

class Graph {

    public Graph(int n) {
        this.n = n;
    }
    int n;
    Map<Integer, Node> nodesMap = new HashMap<>();

    public void addNode(Node node) {
        nodesMap.put(node.index, node);
    }

    public void addPath(int index, Path path) {
        nodesMap.get(index).addPath(path);
    }

    public boolean isMukoGraph() {
        // 始終点となる辺が一つの頂点が2つあるか
        // 始終点以外の点の辺が2つか
        List<Node> sisyutenList = new ArrayList<>();
        for(Map.Entry entry : nodesMap.entrySet()) {
            Node node = (Node) entry.getValue();
            int nodeSize = node.paths.size();
            if (nodeSize > 2) {
                return false;
            }

            if (nodeSize ==  1) {
                sisyutenList.add(node);
            }
        }

        if (sisyutenList.size() != 2) {
            return false;
        }

        // 始点から終点に辿れるか
        if (isCanTrace(sisyutenList.get(0), sisyutenList.get(1))) {
            return true;
        }
        return false;
    }

    public boolean isCanTrace(Node start, Node end) {
        int traceCount = 2;
        Path path = start.paths.get(0);
        while (path.to != end.index) {
            Node nextNode = nodesMap.get(path.to);
            path = nextNode.getNextPath(path);
            if (path == null) {
                return false;
            }
            traceCount++;
            if (traceCount > n) {
                return false;
            }
        }

        return traceCount == n;
    }

}
class Node {
    public Node(int index) {
        this.index = index;
    }
    int index;
    List<Path> paths = new ArrayList<>();

    public void addPath(Path path) {
        paths.add(path);
    }

    public Path getNextPath(Path fromPath) {
        for (Path path : paths) {
            if(path.to != fromPath.from) {
                return path;
            }
        }
        return null;
    }
}

class Path {
    public Path(int from, int to) {
        this.from = from;
        this.to = to;
    }

    int from;
    int to;
}