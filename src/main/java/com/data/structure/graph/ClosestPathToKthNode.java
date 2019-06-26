package com.data.structure.graph;

// dijkstra method
public class ClosestPathToKthNode {

    static int V =0; // Number of nodes

    public static void main(String[] args) {
        /* Let us create the example graph discussed above */
        int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
                                    {4, 0, 8, 0, 0, 0, 0, 11, 0},
                                    {0, 8, 0, 7, 0, 4, 0, 0, 2},
                                    {0, 0, 7, 0, 9, 14, 0, 0, 0},
                                    {0, 0, 0, 9, 0, 10, 0, 0, 0},
                                    {0, 0, 4, 14, 10, 0, 2, 0, 0},
                                    {0, 0, 0, 0, 0, 2, 0, 1, 6},
                                    {8, 11, 0, 0, 0, 0, 1, 0, 7},
                                    {0, 0, 2, 0, 0, 0, 6, 7, 0}};
        dijkstra(graph, 0, graph[0].length);
    }

    private static void dijkstra(int[][] graph, int src, int size) {

        V = size;

        int dist[] = new int[V];

        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        boolean haveVisitedNodeRelaxation[] = new boolean[V];

        dist[src] = 0;

        for(int count = 0; count < V-1; count++){

            int u = minDistance(dist, haveVisitedNodeRelaxation);

            haveVisitedNodeRelaxation[u] = true;

            // Update dist value of the adjacent vertices of the
            // picked vertex.
            for (int v = 0; v < V; v++){

                if (!haveVisitedNodeRelaxation[v] && graph[u][v] != 0 &&
                        dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v])
                    dist[v] = dist[u] + graph[u][v];
            }
        }

        printSolution(dist, V);
    }

    static int minDistance(int[] dist, boolean[] sptSet){
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < V; v++)
            if (sptSet[v] == false && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }

        return min_index;
    }



    static void printSolution(int dist[], int n) {
        System.out.println("Vertex   Distance from Source");
        for (int i = 0; i < V; i++)
            System.out.println(i + " tt " + dist[i]);
    }
}
