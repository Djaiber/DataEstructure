package co.edu.unbosque.util.structure.bfs;

public interface BFS<E> {
   public  void bfs(int s);
   public void addEdge(int s, int t);
   public int size();
   public boolean[] visited();
   public void reset();
  
}