package co.edu.unbosque.quiz2;

import estructura.MyLinkedList;
import estructura.Node;

public class DFSImpl<E> implements DFS<E> {
    private boolean[] visited;
    private MyLinkedList<Integer>[] adj;
    private int vertices;

    public DFSImpl(int vertices) {
        this.vertices = vertices;
        this.visited = new boolean[vertices];
        this.adj = new MyLinkedList[vertices];
        inicializarAdyacencia(0, vertices);
    }

    private void inicializarAdyacencia(int i, int vertices) {
        if (i == vertices) {
            return;
        }
        adj[i] = new MyLinkedList<>();
        inicializarAdyacencia(i + 1, vertices);
    }

    @Override
    public void addEdge(int s, int t) {
        agregarArista(adj[s], t);
        agregarArista(adj[t], s);
    }

    private void agregarArista(MyLinkedList<Integer> list, int t) {
        if (list.getFirst() == null) {
            list.addLast(t);
            return;
        }
        agregarAristaRec(list.getFirst(), t);
    }

    private void agregarAristaRec(Node<Integer> nodo, int t) {
        if (nodo.getNext() == null) {
            nodo.setNext(new Node<>(t));
            return;
        }
        agregarAristaRec(nodo.getNext(), t);
    }

    @Override
    public void dfs(int s) {
        visited = new boolean[vertices];
        dfsRec(s);
    }

    private void dfsRec(int s) {
        if (visited[s]) {
            return;
        }
        visited[s] = true;
        recorrerAdyacentes(adj[s].getFirst());
    }

    private void recorrerAdyacentes(Node<Integer> nodo) {
        if (nodo == null) {
            return;
        }
        int i = nodo.getInfo();
        if (!visited[i]) {
            dfsRec(i);
        }
        recorrerAdyacentes(nodo.getNext());
    }

    public int count() {
        visited = new boolean[vertices];
        return countRec(0, 0);
    }

    private int countRec(int index, int count) {
        if (index == vertices) {
            return count;
        }
        if (!visited[index]) {
            dfsRec(index);
            return countRec(index + 1, count + 1);
        }
        return countRec(index + 1, count);
    }
}
