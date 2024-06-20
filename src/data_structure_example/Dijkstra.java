package data_structure_example;
import java.util.*;

public class Dijkstra {

    static class Graph {
        private int V;
        private LinkedList<Node> adj[];

        class Node implements Comparator<Node> {
            public int node;
            public int cost;

            public Node() {}
            public Node(int node, int cost) {
                this.node = node;
                this.cost = cost;
            }

            @Override
            public int compare(Node node1, Node node2) {
                if (node1.cost < node2.cost)
                    return -1;
                if (node1.cost > node2.cost)
                    return 1;
                return 0;
            }
        }

        public Graph(int V) {
            this.V = V;
            adj = new LinkedList[V];
            for (int i = 0; i < V; ++i)
                adj[i] = new LinkedList<>();
        }

        public void addEdge(int u, int v, int cost) {
            adj[u].add(new Node(v, cost));
        }

        public void dijkstra(int src) {
            PriorityQueue<Node> pq = new PriorityQueue<>(V, new Node());
            int[] dist = new int[V];

            for (int i = 0; i < V; i++)
                dist[i] = Integer.MAX_VALUE;

            pq.add(new Node(src, 0));
            dist[src] = 0;

            while (!pq.isEmpty()) {
                int u = pq.poll().node;

                for (Node node : adj[u]) {
                    int v = node.node;
                    int weight = node.cost;

                    if (dist[v] > dist[u] + weight) {
                        dist[v] = dist[u] + weight;
                        pq.add(new Node(v, dist[v]));
                    }
                }
            }

            System.out.println("Node Distance from Source");
            for (int i = 0; i < V; i++)
                System.out.println(i + " \t\t " + dist[i]);
        }

        public static void main(String[] args) {
            int V = 5;
            Graph graph = new Graph(V);

            graph.addEdge(0, 1, 9);
            graph.addEdge(0, 2, 6);
            graph.addEdge(0, 3, 5);
            graph.addEdge(0, 4, 3);
            graph.addEdge(2, 1, 2);
            graph.addEdge(2, 3, 4);

            graph.dijkstra(0);
        }
    }
}
