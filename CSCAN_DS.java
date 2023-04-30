import java.util.Scanner;

public class CSCAN_DS {
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

        // Sort requests in ascending order
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (requests[j] > requests[j+1]) {
                    int temp = requests[j];
                    requests[j] = requests[j+1];
                    requests[j+1] = temp;
                }
            }
        }

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
                totalHeadMovement += Math.abs(currentHeadPosition - 199);
                currentHeadPosition = 199;
                totalHeadMovement += Math.abs(requests[0]);
                currentHeadPosition = 0;
                i = 0;
            }
        }

        // Print results
        System.out.println("Total head movement: " + totalHeadMovement);
    }
}
