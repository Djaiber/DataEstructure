package co.edu.unbosque.util.structure.dfs;

import estructura.MyLinkedList;
import estructura.Node;
import co.edu.unbosque.util.structure.stack.StackImpl;

public class DFSImpl<E> implements DFS<E> {
    
    /**
     * Helper method to check if a vertex is in the visited list
     * 
     * @param visited The list of visited vertices
     * @param vertex The vertex to check
     * @return true if the vertex is in the list, false otherwise
     */
    private boolean isVisited(MyLinkedList<Integer> visited, int vertex) {
        Node<Integer> current = visited.getFirst();
        while (current != null) {
            if (current.getInfo() == vertex) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }
    
    /**
     * Iterative DFS implementation using a stack
     * 
     * @param adj The adjacency list representation of the graph
     * @param s The starting vertex
     */
    private void dfsIterative(MyLinkedList<Integer>[] adj, int s) {
        // Create a stack for DFS traversal
        StackImpl<Integer> stack = new StackImpl<>();
        
        // Create a list to keep track of visited vertices
        MyLinkedList<Integer> visited = new MyLinkedList<>();
        
        // Push the current source node
        stack.push(s);
        
        while (stack.size() > 0) {
            // Pop a vertex from stack
            int currentVertex = stack.pop();
            
            // Check if the vertex is already visited
            if (!isVisited(visited, currentVertex)) {
                // Print the vertex
                System.out.print(currentVertex + " ");
                
                // Mark as visited
                visited.addLast(currentVertex);
                
                // Get all adjacent vertices of the popped vertex
                // If an adjacent vertex is not visited, push it to the stack
                Node<Integer> current = adj[currentVertex].getFirst();
                while (current != null) {
                    int adjacentVertex = current.getInfo();
                    
                    // If not visited, add to stack
                    if (!isVisited(visited, adjacentVertex)) {
                        stack.push(adjacentVertex);
                    }
                    current = current.getNext();
                }
            }
        }
    }

    @Override
    public void dfs(MyLinkedList<Integer>[] adj, int s) {
        // Call the iterative DFS function using a stack
        dfsIterative(adj, s);
    }
    
    @Override
    public void addEdge(MyLinkedList<Integer>[] adj, int s, int t) {
        // Add edge from vertex s to t
        adj[s].addLast(t);
        // Due to undirected Graph
        adj[t].addLast(s);
    }
}