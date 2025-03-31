package co.edu.unbosque.quiz2;


import java.util.Scanner;

import estructura.MyDequeList;

public class QuickExtraction {
    
    private static int findMinJumpsRecursive(MyDequeList<int[]> queue, boolean[] visited, int targetFloor) {
        

        int[] current = queue.removeFirst();
        int floor = current[0];
        int jumps = current[1];
        int totalDescent = current[2];

        //Target floor
        if (floor == targetFloor) {
            return jumps;
        }

        //short jump
        int nextFloorShort = floor - 1;
        if (nextFloorShort >= 1 && !visited[nextFloorShort]) {
            queue.insertLast(new int[]{nextFloorShort, jumps + 1, totalDescent + 1});
            visited[nextFloorShort] = true;
        }

        // long jump
        int nextFloorLong = floor - totalDescent;
        if (nextFloorLong >= 1 && !visited[nextFloorLong]) {
            queue.insertLast(new int[]{nextFloorLong, jumps + 1, totalDescent + totalDescent});
            visited[nextFloorLong] = true;
        }

        return findMinJumpsRecursive(queue, visited, targetFloor);
    }
    
    public static int findMinJumps(int totalFloors, int targetFloor) {
        
        int currentFloor = totalFloors;
        //BFS
        MyDequeList<int[]> queue = new MyDequeList<>();
        queue.insertLast(new int[]{currentFloor, 0, 0}); // floor, jumps, total descent
        boolean[] visited = new boolean[totalFloors + 1];
        visited[currentFloor] = true;

        return findMinJumpsRecursive(queue, visited, targetFloor);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);   
        int totalFloors =scanner.nextInt();
        int targetFloor = scanner.nextInt();
        scanner.close();
        
        int result = findMinJumps(totalFloors, targetFloor);
        System.out.println(result);
    }
}
