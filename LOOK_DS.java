import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class LOOK_DS {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of requests: ");
        int n = input.nextInt();

        ArrayList<Integer> requests = new ArrayList<Integer>();
        System.out.println("Enter the disk request sequence:");
        for (int i = 0; i < n; i++) {
            requests.add(input.nextInt());
        }

        System.out.print("Enter the initial head position: ");
        int initialHeadPosition = input.nextInt();

        System.out.print("Enter the direction of head movement (left or right): ");
        String direction = input.next();

        // Sort requests in ascending order
        Collections.sort(requests);

        // Calculate total head movement
        int totalHeadMovement = 0;
        int currentHeadPosition = initialHeadPosition;
        int headMovement = 1;
        while (requests.size() > 0) {
            int nextRequestIndex = -1;
            for (int i = 0; i < requests.size(); i++) {
                if (direction.equals("right")) {
                    if (requests.get(i) >= currentHeadPosition) {
                        nextRequestIndex = i;
                        break;
                    }
                } else {
                    if (requests.get(i) <= currentHeadPosition) {
                        nextRequestIndex = i;
                    }
                }
            }

            if (nextRequestIndex == -1) {
                if (direction.equals("right")) {
                    direction = "left";
                    headMovement = -1;
                    nextRequestIndex = requests.size() - 1;
                } else {
                    direction = "right";
                    headMovement = 1;
                    nextRequestIndex = 0;
                }
            }

            int nextRequest = requests.remove(nextRequestIndex);
            totalHeadMovement += Math.abs(nextRequest - currentHeadPosition);
            currentHeadPosition = nextRequest;

            if (direction.equals("right") && currentHeadPosition == 199) {
                direction = "left";
                headMovement = -1;
            } else if (direction.equals("left") && currentHeadPosition == 0) {
                direction = "right";
                headMovement = 1;
            }
        }

        // Print results
        System.out.println("Total head movement: " + totalHeadMovement);
    }
}
