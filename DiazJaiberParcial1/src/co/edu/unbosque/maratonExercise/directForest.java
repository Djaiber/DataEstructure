package co.edu.unbosque.maratonExercise;
import java.util.*;

public class directForest {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // Number of test cases

        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt(); // Number of nodes
            int E = sc.nextInt(); // Number of edges

            // Build the graph (adjacency list)
            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i <= N; i++) {
                graph.add(new ArrayList<>());
            }

            // Read edges and build the graph
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                graph.get(u).add(v); // Add directed edge u -> v
            }

            // Find the minimum number of sets
            int minSets = findMinSets(graph, N);
            System.out.println("Case " + t + ": " + minSets);
        }
        sc.close();
    }

    // Function to find the minimum number of sets
    private static int findMinSets(List<List<Integer>> graph, int N) {
        boolean[] visited = new boolean[N + 1]; // To track visited nodes
        int totalSets = 0;

        // Iterate through all nodes
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                // If the node is not visited, it's a root of a new tree
                // Find the height of the tree rooted at this node
                int height = findTreeHeight(graph, i, visited);
                totalSets += height; // Add the height to the total number of sets
            }
        }

        return totalSets;
    }

    // Function to find the height of a tree using DFS
    private static int findTreeHeight(List<List<Integer>> graph, int node, boolean[] visited) {
        visited[node] = true; // Mark the current node as visited
        int maxHeight = 0;

        // Traverse all children of the current node
        for (int child : graph.get(node)) {
            if (!visited[child]) {
                int childHeight = findTreeHeight(graph, child, visited);
                maxHeight = Math.max(maxHeight, childHeight);
            }
        }

        // The height of the current node is 1 + the maximum height of its children
        return maxHeight + 1;
    }
}  
