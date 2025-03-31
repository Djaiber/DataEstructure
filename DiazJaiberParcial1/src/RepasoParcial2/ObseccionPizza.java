package RepasoParcial2;
import estructura.MyDequeList;
import estructura.MyLinkedList;
import estructura.Node;
import java.util.Scanner;
import java.util.Arrays;

public class ObseccionPizza {
    
    static class Edge {
        int to;
        int weight;
        
        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int p = scanner.nextInt();
        
        // Construir el grafo
        MyLinkedList<MyLinkedList<Edge>> graph = new MyLinkedList<>();
        for (int i = 0; i <= n; i++) {
            graph.addLast(new MyLinkedList<>());
        }
        
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int x = scanner.nextInt();
            graph.get(u).getInfo().addLast(new Edge(v, x));
            graph.get(v).getInfo().addLast(new Edge(u, x)); // Calles son bidireccionales
        }
        
        // Leer la ruta del repartidor
        int r = scanner.nextInt();
        MyLinkedList<Integer> deliveryPath = new MyLinkedList<>();
        for (int i = 0; i < r; i++) {
            deliveryPath.addLast(scanner.nextInt());
        }
        
        // Verificar si la ruta es válida
        if (!isValidPath(graph, deliveryPath)) {
            System.out.println(">:(");
            return;
        }
        
        
        // Calcular distancia de la ruta del repartidor
        int deliveryDistance = calculatePathDistance(graph, deliveryPath);
        
        // Calcular distancia mínima con Dijkstra
        int shortestDistance = dijkstra(graph, p, 1, n);
        
        // Comparar distancias
        if (deliveryDistance == shortestDistance) {
            System.out.println("Ok");
        } else {
            System.out.println(">:(");
        }
        scanner.close();
    }
    
    static boolean isValidPath(MyLinkedList<MyLinkedList<Edge>> graph, MyLinkedList<Integer> path) {
        Node<Integer> currentNode = path.getFirst();
        while (currentNode != null && currentNode.getNext() != null) {
            int from = currentNode.getInfo();
            int to = currentNode.getNext().getInfo();
            boolean found = false;
            Node<Edge> edgeNode = graph.get(from).getInfo().getFirst();
            while (edgeNode != null) {
                if (edgeNode.getInfo().to == to) {
                    found = true;
                    break;
                }
                edgeNode = edgeNode.getNext();
            }
            if (!found) return false;
            currentNode = currentNode.getNext();
        }
        return true;
    }
    
    static int calculatePathDistance(MyLinkedList<MyLinkedList<Edge>> graph, MyLinkedList<Integer> path) {
        int distance = 0;
        Node<Integer> currentNode = path.getFirst();
        while (currentNode != null && currentNode.getNext() != null) {
            int from = currentNode.getInfo();
            int to = currentNode.getNext().getInfo();
            Node<Edge> edgeNode = graph.get(from).getInfo().getFirst();
            while (edgeNode != null) {
                if (edgeNode.getInfo().to == to) {
                    distance += edgeNode.getInfo().weight;
                    break;
                }
                edgeNode = edgeNode.getNext();
            }
            currentNode = currentNode.getNext();
        }
        return distance;
    }
    
    static int dijkstra(MyLinkedList<MyLinkedList<Edge>> graph, int start, int end, int n) {
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        
        MyDequeList<Edge> pq = new MyDequeList<>();
        pq.insertLast(new Edge(start, 0));
        
        while (!pq.isEmpty()) {
            Edge current = pq.removeFirst();
            if (current.weight > dist[current.to]) continue;
            
            Node<Edge> edgeNode = graph.get(current.to).getInfo().getFirst();
            while (edgeNode != null) {
                Edge edge = edgeNode.getInfo();
                int newDist = dist[current.to] + edge.weight;
                if (newDist < dist[edge.to]) {
                    dist[edge.to] = newDist;
                    pq.insertLast(new Edge(edge.to, newDist));
                }
                edgeNode = edgeNode.getNext();
            }
        }
        
        return dist[end];
    }
}