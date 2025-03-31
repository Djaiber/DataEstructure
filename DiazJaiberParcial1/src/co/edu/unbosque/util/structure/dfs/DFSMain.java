package co.edu.unbosque.util.structure.dfs;
import estructura.MyLinkedList;


public class DFSMain {
    
    public static void main(String[] args) {
        int V = 5; // Number of vertices in the graph

        // Create an adjacency list for the graph
        MyLinkedList<Integer>[] adj = new MyLinkedList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new MyLinkedList<>();
        }

        // Define the edges of the graph
        int[][] edges = {
            { 1, 2 }, { 1, 0 }, { 2, 0 }, { 2, 3 }, { 2, 4 }
        };

        // Create a DFS implementation
        DFS<Integer> dfsImpl = new DFSImpl<Integer>();
        
        // Populate the adjacency list with edges
        for (int[] e : edges) {
            dfsImpl.addEdge(adj, e[0], e[1]);
        }

        int source = 1; 
        System.out.println("DFS from Root: " + source);
        dfsImpl.dfs(adj, source);
    }
} 