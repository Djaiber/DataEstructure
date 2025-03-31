package RepasoParcial2;

import estructura.MyDequeList;
import estructura.MyLinkedList;
import java.util.Scanner;

public class Minecraft2D {
    static class Point {
        int x, y;
        Point parent;
        String direction;
        
        public Point(int x, int y, Point parent, String direction) {
            this.x = x;
            this.y = y;
            this.parent = parent;
            this.direction = direction;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        char[][] map = new char[N][N];
        Point start = null, end = null;

        // Leer el mapa y encontrar las posiciones de X y H
        for (int i = 0; i < N; i++) {
            String line = scanner.nextLine();
            map[i] = line.toCharArray();
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 'X') {
                    start = new Point(i, j, null, null);
                } else if (map[i][j] == 'H') {
                    end = new Point(i, j, null, null);
                }
            }
        }

        // Direcciones posibles: ARRIBA, ABAJO, IZQUIERDA, DERECHA
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        String[] dirNames = {"ARRIBA", "ABAJO", "IZQUIERDA", "DERECHA"};

        MyDequeList<Point> queue = new MyDequeList<>();
        boolean[][] visited = new boolean[N][N];
        queue.insertLast(start);
        visited[start.x][start.y] = true;
        Point endPoint = null;

        // BFS para encontrar el camino más corto
        while (queue.size() != 0) {
            Point current = queue.removeFirst();

            if (current.x == end.x && current.y == end.y) {
                endPoint = current;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dirs[i][0];
                int ny = current.y + dirs[i][1];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N && 
                    map[nx][ny] != '#' && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.insertLast(new Point(nx, ny, current, dirNames[i]));
                }
            }
        }

        // Reconstruir el camino desde el final hasta el inicio
        MyLinkedList<String> path = new MyLinkedList<>();
        Point current = endPoint;
        while (current != null && current.parent != null) {
            path.add(current.direction);
            current = current.parent;
        }

        // Imprimir el camino en orden inverso
        while (!path.isEmpty()) {
            System.out.println(path.extract());
        }

        scanner.close();
    }
}
