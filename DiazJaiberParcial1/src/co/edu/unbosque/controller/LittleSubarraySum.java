package co.edu.unbosque.controller;

import estructura.MyLinkedList;

import java.util.Scanner;

public class LittleSubarraySum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        
        
        MyLinkedList<Integer> numeros = new MyLinkedList<>();
        leerNumerosRecursivo(numeros, scanner, N, 0);
        
        int suma = sumaRecursiva(numeros, A, B);
 
        System.out.println(suma); 
        scanner.close();
    }
    
  
    private static void leerNumerosRecursivo(MyLinkedList<Integer> lista, Scanner scanner, int N, int i) {
        // Rompe la recursividad
        if (i >= N) {
            return;
        }
        lista.addLast(scanner.nextInt());
        leerNumerosRecursivo(lista, scanner, N, i + 1);
    }
    

    private static int sumaRecursiva(MyLinkedList<Integer> lista, int inicio, int fin) {
        // En caso de solo un numero
        if (inicio == fin) {
            return lista.get(inicio).getInfo();
        }

        return lista.get(inicio).getInfo() + sumaRecursiva(lista, inicio + 1, fin);
    }
}
