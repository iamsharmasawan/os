import java.util.Arrays;
import java.util.Scanner;

public class CLOOK_DS {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of requests: ");
        int n = input.nextInt();

        int[] requests = new int[n];
        System.out.println("Enter the disk request sequence:");
        for (int i = 0; i < n; i++) {
            requests[i] = input.nextInt();
        }

        System.out.print("Enter the initial head position: ");
        int initialHeadPosition = input.nextInt();

        Arrays.sort(requests);  // Sort requests in ascending order

        // Calculate total head movement
        int totalHeadMovement = 0;
        int currentHeadPosition = initialHeadPosition;
        int i = 0;
        while (i < n) {
            if (requests[i] >= currentHeadPosition) {
                totalHeadMovement += Math.abs(requests[i] - currentHeadPosition);
                currentHeadPosition = requests[i];
                i++;
            } else {
                totalHeadMovement += Math.abs(currentHeadPosition - requests[n-1]);
                currentHeadPosition = requests[n-1];
                n--;
            }
        }

        // Print results
        System.out.println("Total head movement: " + totalHeadMovement);
    }
}
