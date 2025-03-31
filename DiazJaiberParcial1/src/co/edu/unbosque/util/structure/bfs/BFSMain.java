package co.edu.unbosque.util.structure.bfs;

public class BFSMain {
    public static void main(String[] args) {
        int vertices = 5;
        BFSImpl<Integer> bfs = new BFSImpl<>(vertices);
        
        int[][] edges = {
        	    { 0, 2 }, { 0, 3 }, { 0, 1 }, { 2, 4 }
        	};

        for (int[] edge : edges) {
            bfs.addEdge(edge[0], edge[1]);
        }
        
        int source = 4;
        System.out.println("BFS desde el nodo: " + source);
        bfs.bfs(source);
    }
}