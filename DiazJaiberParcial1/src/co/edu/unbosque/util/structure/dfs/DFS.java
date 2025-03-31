package co.edu.unbosque.util.structure.dfs;
import estructura.MyLinkedList;



public interface DFS<E>{

    void dfs(MyLinkedList<Integer>[] adj, int s);

    void addEdge(MyLinkedList<Integer>[] adj, int s, int t);
}


