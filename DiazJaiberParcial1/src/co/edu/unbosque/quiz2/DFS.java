package co.edu.unbosque.quiz2;



public interface DFS<E> {

	public void addEdge(int s, int t); // Agrega una arista entre dos vértices

	public void dfs(int s); // Realiza la búsqueda en profundidad desde un nodo dado
}
