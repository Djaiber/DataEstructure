package co.edu.unbosque.util.structure.bfs;

import estructura.MyDequeList;
import estructura.DNode;

public class BFSImpl<E> implements BFS<E> {
    private MyDequeList<Integer>[] adj;
    private boolean[] visited;
    private MyDequeList<Integer> queue;
    
    public BFSImpl(int vertices) {
        adj = new MyDequeList[vertices];
        for (int i = 0; i < vertices; i++) {
            adj[i] = new MyDequeList<>();
        }
        visited = new boolean[vertices];
        queue = new MyDequeList<>();
    }
    
    @Override
    public void bfs(int s) {
        reset();
        visited[s] = true;
        queue.insertLast(s);
        bfsRec();
    }
    
    private void bfsRec() {
        if (queue.getSize() == 0) {
            return;
        }
        
        int curr = queue.removeFirst();
        System.out.print(curr + " ");
        recorrerAdyacentes(adj[curr].getHead());
        bfsRec();
    }
    
    private void recorrerAdyacentes(DNode<Integer> nodo) {
        if (nodo == null) {
            return;
        }
        int i = nodo.getInfo();
        if (!visited[i]) {
            visited[i] = true;
            queue.insertLast(i);
        }
        recorrerAdyacentes(nodo.getNext());
    }
    
    @Override
    public void addEdge(int s, int t) {
        adj[s].insertLast(t);
        adj[t].insertLast(s);
    }
    
    @Override
    public int size() {
        return adj.length;
    }
    
    @Override
    public void reset() {
        visited = new boolean[adj.length];
        queue = new MyDequeList<>();
    }
    
    @Override
    public boolean[] visited() {
        return visited;
    }
}