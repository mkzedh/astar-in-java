
import java.util.Arrays;

public class Graph {
    private int v; // number of vertices
    private int[][] graph; // graph represented using adjacency matrix

    // constructor
    Graph(int numVertices) {
        v = numVertices;
        graph = new int[v][v];
        for (int row = 0; row < v; row++) {
            Arrays.fill(graph[row], 0);
        }
    }
    
    // get encapsulation
    int[][] getGraph() {
        return graph;
    }

    int getVertices() {
        return v;
    }

    // add an edge to graph
    void addEdge(int from, int to, int weight, boolean directed) {
        graph[from][to] = weight;
        if (!directed) {
            graph[to][from] = weight;
        }
    }
}
