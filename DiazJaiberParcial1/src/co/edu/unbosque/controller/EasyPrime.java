package co.edu.unbosque.controller;

import java.util.Scanner;

import estructura.MyLinkedList;
import estructura.Node;

public class EasyPrime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        

        int N = scanner.nextInt();
        MyLinkedList<Integer> numeros = new MyLinkedList<>();
        MyLinkedList<Integer> output = new MyLinkedList<>();
        cargarNumerosRecursivo(numeros, scanner, N, 0);
        

        int Q = scanner.nextInt();
        procesarQueries(scanner, numeros, Q, output);
        imprimirResultados(output);
        
        scanner.close();
    }
    
    private static void cargarNumerosRecursivo(MyLinkedList<Integer> lista, Scanner scanner, int N, int i) {
        if (i >= N) return;
        lista.addLast(scanner.nextInt());
        cargarNumerosRecursivo(lista, scanner, N, i + 1);
    }
    
    private static void procesarQueries(Scanner scanner, MyLinkedList<Integer> lista, int Q, MyLinkedList<Integer> output) {
        if (Q <= 0) return;
        
        int tipo = scanner.nextInt();
        if (tipo == 1) {
            int X = scanner.nextInt();
            int Y = scanner.nextInt();
         
            Y = Math.min(Y, lista.size());
            int cantidadPrimos = contarPrimosEnRango(lista, X, Y);
            output.addLast(cantidadPrimos);
        } else if (tipo == 2) {
            int X = scanner.nextInt();
            int nuevoValor = scanner.nextInt();
            actualizarValor(lista, X, nuevoValor);
        }
        
        procesarQueries(scanner, lista, Q - 1, output);
    }
    
    private static void imprimirResultados(MyLinkedList<Integer> output) {
        imprimirResultadosRecursivo(output.getFirst());
    }
    
    private static void imprimirResultadosRecursivo(Node<Integer> nodo) {
        if (nodo == null) return;
        System.out.println(nodo.getInfo());
        imprimirResultadosRecursivo(nodo.getNext());
    }
    
    private static int contarPrimosEnRango(MyLinkedList<Integer> lista, int X, int Y) {
        if (X > Y) return 0;
        return contarPrimosRecursivo(lista, X, Y, X);
    }
    
    private static int contarPrimosRecursivo(MyLinkedList<Integer> lista, int inicio, int fin, int actual) {
        if (actual > fin) return 0;
        
        Node<Integer> nodo = lista.get(actual - 1);
        if (nodo == null) return 0;
        
        int numero = nodo.getInfo();
        return (esPrimo(numero) ? 1 : 0) + 
               contarPrimosRecursivo(lista, inicio, fin, actual + 1);
    }
    
    private static void actualizarValor(MyLinkedList<Integer> lista, int X, int nuevoValor) {
        Node<Integer> nodo = lista.get(X - 1);
        if (nodo != null) {
            nodo.setInfo(nuevoValor);
        }
    }
    
    private static boolean esPrimo(int n) {
        if (n <= 1) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
