import java.util.*;
 public class FCFS_DS{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of requests:");
        int n = sc.nextInt();

        int[] requests = new int[n];
        System.out.println("Enter the disk request schedule:");
        for(int i=0; i<n; i++){
            requests[i] = sc.nextInt();
        }
        System.out.println("Enter the initial head position:");
        int initialHeadPosition = sc.nextInt();

        int totalHeadMovement = 0;
        int currentHeadPosition = initialHeadPosition;

        for(int i =0; i<n; i++){
            totalHeadMovement += Math.abs(requests[i] - currentHeadPosition);
            currentHeadPosition = requests[i];
        }

        System.out.println("Total head movement: " + totalHeadMovement);
    }
 }