package co.edu.unbosque.maratonExercise;

import java.util.Scanner;
import estructura.MyDequeList;

public class PolacaInversa {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tam = sc.nextInt();
		sc.nextLine(); // Consumir el salto de línea después del número
		
		// Leer la expresión completa
		String expresion = sc.nextLine();
		String[] elementos = expresion.split(" ");
		
		// Evaluar la expresión usando una pila implementada con MyDequeList
		MyDequeList<Long> pila = new MyDequeList<>();
		
		for (int i = 0; i < elementos.length; i++) {
			String elemento = elementos[i];
			
			// Si es un operador, realizar la operación
			if (esOperador(elemento)) {
				// Sacar los dos operandos de la pila
				long b = pila.removeFirst();
				long a = pila.removeFirst();
				
				// Realizar la operación correspondiente
				long resultado = realizarOperacion(a, b, elemento);
				
				// Insertar el resultado en la pila
				pila.insertFirst(resultado);
			} else {
				// Si es un número, convertirlo y añadirlo a la pila
				pila.insertFirst(Long.parseLong(elemento));
			}
		}
		
		// El resultado final estará en la cima de la pila
		System.out.println(pila.removeFirst());
	}
	
	// Método para verificar si un elemento es un operador
	private static boolean esOperador(String elemento) {
		return elemento.equals("+") || elemento.equals("-") || 
			   elemento.equals("*") || elemento.equals("/");
	}
	
	// Método para realizar la operación correspondiente
	private static long realizarOperacion(long a, long b, String operador) {
		switch (operador) {
			case "+": return a + b;
			case "-": return a - b;
			case "*": return a * b;
			case "/": return a / b;
			default: throw new IllegalArgumentException("Operador no válido: " + operador);
		}
	}
}
