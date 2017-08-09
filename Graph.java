import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ioana-chirca on 03-Jul-17.
 */

/*
 * Graph with integer vertices and unidirectional edges.
 */
public class Graph {
    public ArrayList<ArrayList<Integer> > graph;
    private final int alphabetSize;

    public Graph(int alphabetSize) {
        graph = new ArrayList<>();
        this.alphabetSize = alphabetSize;
        while(graph.size() < alphabetSize) graph.add(null);
    }

    public void addNode(int u) {
        if (u >= 0 && u < alphabetSize) {
            if (graph.get(u) == null) {
                graph.set(u, new ArrayList<>());
            }
        }
    }

    public void addEdge(int u, int v) {
        if (u >= 0 && u < alphabetSize && v >= 0 && v < alphabetSize) {
            if (graph.get(u) == null) {
                graph.set(u, new ArrayList<>());
            }
            if (!graph.get(u).contains(v)) {
                graph.get(u).add(v);
            }

            if (graph.get(v) == null) {
                graph.set(v, new ArrayList<>());
            }
        }
    }

    public ArrayList<Integer> topologicalSort() {
        int[] inDegree = new int[alphabetSize];
        for (int i = 0; i < alphabetSize; i++) {
            if (graph.get(i) != null) {
                for (int j = 0; j < graph.get(i).size(); j++) {
                    inDegree[graph.get(i).get(j)]++;
                }
            }
        }

        int toVisit = 0;
        Queue<Integer> Q = new LinkedList<>();
        for (int i = 0; i < alphabetSize; i++) {
            if (graph.get(i) != null) {
                toVisit++;
                if (inDegree[i] == 0) Q.add(i);
            }
        }

        ArrayList<Integer> alphabet = new ArrayList<>();
        while (!Q.isEmpty()) {
            int element = Q.poll();
            alphabet.add(element);
            toVisit--;
            for (int j = 0; j < graph.get(element).size(); j++) {
                int neighbor = graph.get(element).get(j);
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) Q.add(neighbor);
            }
        }

        if (toVisit != 0) {
            // topological sort is not possible
            return null;
        }

        return alphabet;
    }

    public void print() {
        for (int i = 0; i < graph.size(); i++) {
            if (graph.get(i) != null) {
                System.out.print((char)i + ": ");
                for (int j = 0; j < graph.get(i).size(); j++) {
                    System.out.print((char)(int)graph.get(i).get(j) + " ");
                }
                System.out.println();
            }

        }
    }
}
