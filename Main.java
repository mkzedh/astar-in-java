import java.util.Scanner; // Import the Scanner class

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Number of vertices: ");
        int numVertices = input.nextInt();
        Graph graph = new Graph(numVertices);

        System.out.println("Number of edges: ");
        int numEdges = input.nextInt();

        System.out.println("Enter vertices and edges in the format - from:int to:int weight:int directed:bool");
        System.out.println("For example, to insert an undirected edge of weight 2 from node 0 to node 3, input would be 0 3 2 false");
        System.out.println("For each edge, input on a new line. The program will assume each line is an edge.");
        
        for(int i = 0; i < numEdges; i++) {
            int a1 = input.nextInt();
            int a2 = input.nextInt();
            int a3 = input.nextInt();
            boolean a4 = input.nextBoolean();
            graph.addEdge(a1, a2, a3, a4);
        }

        System.out.println("Input the heuristic value of each node in the following format - node:int h(node):int");
        System.out.println("For each node, input on a new line");
        int[] heuristicValues = new int[numVertices];
        for(int i = 0; i < numVertices; i++) {
            heuristicValues[input.nextInt()] = input.nextInt();
        }

        System.out.println("What is the start node?");
        int startNode = input.nextInt();

        System.out.println("What is the goal node?");
        int goalNode = input.nextInt();

        input.close();

        System.out.printf("A* found the most optimal path from node %d to node %d to be:\n", startNode, goalNode);
        AStar.astar(startNode, goalNode, numVertices, graph.getGraph(), heuristicValues).stream().forEach(System.out::println);
        
    }
}
