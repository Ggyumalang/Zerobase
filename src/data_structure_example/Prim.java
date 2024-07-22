package data_structure_example;

import java.util.*;

public class Prim {
    static class Edge {
        int src, dest, weight;

        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    static class Graph {
        private final int V;
        private final List<List<Edge>> adj;

        Graph(int V) {
            this.V = V;
            adj = new ArrayList<>(V);
            for (int i = 0; i < V; i++)
                adj.add(new ArrayList<>());
        }

        void addEdge(int src, int dest, int weight) {
            Edge edge = new Edge(src, dest, weight);
            adj.get(src).add(edge);
            adj.get(dest).add(new Edge(dest, src, weight)); // 무방향 그래프
        }

        void primMST() {
            boolean[] mstSet = new boolean[V];
            Edge[] e = new Edge[V];
            int[] key = new int[V];
            Arrays.fill(key, Integer.MAX_VALUE);
            // 가중치에 따른 오름차순
            PriorityQueue<Edge> pq = new PriorityQueue<>(V, Comparator.comparingInt(o -> o.weight));

            key[0] = 0;
            pq.add(new Edge(0, -1, 0));
            while (!pq.isEmpty()) {
                Edge edge = pq.poll();
                int u = edge.src;

                if (mstSet[u]) continue;
                mstSet[u] = true;

                for (Edge nextEdge : adj.get(u)) {
                    int v = nextEdge.dest;
                    if (!mstSet[v] && nextEdge.weight < key[v]) {
                        key[v] = nextEdge.weight;
                        pq.add(new Edge(v, u, key[v]));
                        e[v] = nextEdge;
                    }
                }
            }

            printMST(e);
        }

        void printMST(Edge[] e) {
            System.out.println("Edge \tWeight");
            for (int i = 1; i < e.length; ++i)
                if (e[i] != null)
                    System.out.println(e[i].src + " - " + e[i].dest + "\t" + e[i].weight);
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(4);
        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 2, 6);
        graph.addEdge(0, 3, 5);
        graph.addEdge(1, 3, 15);
        graph.addEdge(2, 3, 4);

        graph.primMST();
    }
}