package co.edu.unbosque.util.structure.stack;

import estructura.MyDequeList;


public  class StackImpl<E>  implements Stack <E>{
	
	private MyDequeList<E> data;
	
	// Constructor para inicializar la lista
    public StackImpl() {
        this.data = new MyDequeList<>();
    }
	@Override
	public void push(E info) {
		data.insertLast(info);
		
	}


	@Override
	public E pop() {
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
