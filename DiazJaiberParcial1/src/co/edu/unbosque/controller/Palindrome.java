package co.edu.unbosque.controller;

import java.util.Scanner;

import estructura.MyLinkedList;

public class Palindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        
        MyLinkedList<Character> lista = new MyLinkedList<>();
        cargarCaracteresRecursivo(lista, input, 0);
        
        boolean esPalindromo = verificarPalindromo(lista, 0, lista.size() - 1);
        
        System.out.println(esPalindromo ? "Yes" : "No");
        scanner.close();
    }
    
    
    private static void cargarCaracteresRecursivo(MyLinkedList<Character> lista, String input, int pos) {
        if (pos >= input.length()) {
            return;
        }
        lista.addLast(input.charAt(pos));
        cargarCaracteresRecursivo(lista, input, pos + 1);
    }
    
    private static boolean verificarPalindromo(MyLinkedList<Character> lista, int inicio, int fin) {
    	//rompe recursividad
        if (inicio >= fin) {
            return true;
        }
        Character charInicio = lista.get(inicio).getInfo();
        Character charFin = lista.get(fin).getInfo();
        
        if (!charInicio.equals(charFin)) {
            return false;
        }
        
        return verificarPalindromo(lista, inicio + 1, fin - 1);
    }
}
