import java.util.Arrays;
import java.util.Scanner;

public class SSTF_DS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of requests: ");
        int n = sc.nextInt();

        int[] requests = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);
        System.out.println("Enter the disk request sequence:");
        for (int i = 0; i < n; i++) {
            requests[i] = sc.nextInt();
        }

        System.out.print("Enter the initial head position: ");
        int initialHeadPosition = sc.nextInt();

        // Calculate total head movement
        int totalHeadMovement = 0;
        int currentHeadPosition = initialHeadPosition;
        for (int i = 0; i < n; i++) {
            int shortestDistance = Integer.MAX_VALUE;
            int shortestIndex = -1;
            for (int j = 0; j < n; j++) {
                if (!visited[j]) {
                    int distance = Math.abs(requests[j] - currentHeadPosition);
                    if (distance < shortestDistance) {
                        shortestDistance = distance;
                        shortestIndex = j;
                    }
                }
            }
            visited[shortestIndex] = true;
            totalHeadMovement += shortestDistance;
            currentHeadPosition = requests[shortestIndex];
        }

        // Print results
        System.out.println("Total head movement: " + totalHeadMovement);
    }
}