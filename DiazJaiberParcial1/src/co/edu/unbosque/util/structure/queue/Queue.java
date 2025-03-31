package co.edu.unbosque.util.structure.queue;

public interface Queue<E> {
	public void enqueue (E info);
	public E dequeue ();
	public int size();
	

}
