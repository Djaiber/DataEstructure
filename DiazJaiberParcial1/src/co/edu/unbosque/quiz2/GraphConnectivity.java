package co.edu.unbosque.quiz2;
import java.util.Scanner;


public class GraphConnectivity {
	
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine(); 

        procesarCasos(scanner, testCases);
        scanner.close();
    }

    private static void procesarCasos(Scanner scanner, int testCases) {
        if (testCases == 0) return;

        char maxNode = scanner.nextLine().trim().charAt(0);
        int vertices = maxNode - 'A' + 1;
        DFSImpl<Integer> lista = new DFSImpl<>(vertices); // Instancia llamada 'lista'

        leerConexiones(scanner, lista);
        
        System.out.println(lista.count());
        if (testCases > 1) System.out.println();

        procesarCasos(scanner, testCases - 1);
    }

    private static void leerConexiones(Scanner scanner, DFSImpl<Integer> lista) {
        if (!scanner.hasNextLine()) return;

        String line = scanner.nextLine().trim();
        if (line.isEmpty()) return;

        if (line.length() == 2) {
            int u = line.charAt(0) - 'A';
            int v = line.charAt(1) - 'A';
            lista.addEdge(u, v); // Usar 'lista' para agregar bordes
        }

        leerConexiones(scanner, lista);
    }
}
