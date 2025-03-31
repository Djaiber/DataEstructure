package co.edu.unbosque.util.structure.queue;

import estructura.MyDequeList;

public class DequeImpl <E> implements Queue<E>{
	
	private MyDequeList<E> data;
	
	public DequeImpl() {
		data = new MyDequeList<>();
	}

	@Override
	public void enqueue(E info) {
		data.insertFirst(info);
		
	}

	@Override
	public E dequeue() {
		return data.removeFirst();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return data.size();
	}

	@Override
	public String toString() {
		return data.toString();
	}

	


}
