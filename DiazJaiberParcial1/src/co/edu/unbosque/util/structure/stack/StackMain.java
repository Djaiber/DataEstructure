package co.edu.unbosque.util.structure.stack;


import java.util.Random;

public class StackMain {
	
	public static void main(String[] args) {
		
			StackImpl<Integer> pila = new StackImpl<>();
			
			Random r = new Random();
			
			for (int i = 0; i<10; i++) {
				int numero;
				numero = r.nextInt(1000);
				pila.push(numero);
				
			}
			
			System.out.println(pila.toString());
			while (pila.size()>0) {
				System.out.println("He sacado el dato de arriba");
				System.out.println(pila.pop());
			}
			System.out.println(pila.toString());
		}
	}


