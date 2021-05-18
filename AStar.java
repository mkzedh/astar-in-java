
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.LinkedList;

public class AStar {

    static LinkedList<Integer> astar(int start, int goal, int v, int[][] graph, int[] hScore) {
        // g(n) - actual cost
        int gScore[] = new int[v]; 
        // set g(n) of start node to 0
        Arrays.fill(gScore, Integer.MAX_VALUE);
        gScore[start] = 0;

        // priority queue with AStar cost function to represent frontier f(n) = g(n) + h(n)
        PriorityQueue<Integer> frontier = new PriorityQueue<Integer>((a, b) -> gScore[a] + hScore[a] - gScore[b] - hScore[b]);
        // enqueue start node
        frontier.add(start);

        // array storing the previous node to each node on the current cheapest path from start to n
        int[] cameFrom = new int[v];
        Arrays.fill(cameFrom, -1);

        while (!frontier.isEmpty()) {
            // dequeue a node and set it as visited
            start = frontier.poll(); 

            // if goal is reached, terminate search and return path
            if (start == goal) {
                // frontier.stream().forEach(System.out::println);
                return reconstruct_path(cameFrom, start);
            }

            // Queue every unvisited neighbour and mark them as visited
            for (int i = 0; i < v; i++) {
                if (graph[start][i] != 0) {
                    // calculate g score of neighbour when taking the current path
                    int curr_gScore = gScore[start] + graph[start][i];

                    // update actual cost for each adjacent node 
                    if (curr_gScore < gScore[i]) {
                        // record this path as it is more optimal than previous paths
                        cameFrom[i] = start;

                        gScore[i] = curr_gScore;

                        // add i to frontier or update priority of i
                        frontier.remove(i); 
                        frontier.add(i);
                    }
                }
            }
        }
        
        // no path found
        return null;
    }

    static LinkedList<Integer> reconstruct_path(int[] cameFrom, int curr) {
        LinkedList<Integer> path = new LinkedList<Integer>();
        path.add(curr);
        while (cameFrom[curr] != -1) {
            curr = cameFrom[curr];
            path.addFirst(curr);
        }

        return path;
    }
}