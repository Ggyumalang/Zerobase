package data_structure_example;

import java.util.LinkedList;

public class GraphExample {

    public static void main(String[] args) {
        Graph graph = new Graph(5);

        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        graph.printGraph();
        //Vertex 0: -> 1 -> 4
        //Vertex 1: -> 2 -> 3 -> 4
        //Vertex 2: -> 3
        //Vertex 3: -> 4
        //Vertex 4:
    }

    static class Graph {
        private int V;
        private LinkedList<Integer> adj[];

        Graph(int v) {
            V = v;
            adj = new LinkedList[v];
            for (int i = 0; i < v; ++i)
                adj[i] = new LinkedList();
        }

        void addEdge(int v, int w) {
            adj[v].add(w);
        }

        void printGraph() {
            for (int i = 0; i < V; i++) {
                System.out.print("Vertex " + i + ":");
                for (Integer node : adj[i]) {
                    System.out.print(" -> " + node);
                }
                System.out.println();
            }
        }
    }
}
