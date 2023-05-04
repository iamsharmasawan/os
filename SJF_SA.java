import java.util.Arrays;
import java.util.Scanner;

public class SJF_SA {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of processes: ");
        int n = input.nextInt();

        int[] burstTime = new int[n];
        int[] waitingTime = new int[n];
        int[] turnaroundTime = new int[n];
        boolean[] completed = new boolean[n];

        System.out.println("Enter the burst time for each process:");
        for (int i = 0; i < n; i++) {
            System.out.print("P" + (i+1) + ": ");
            burstTime[i] = input.nextInt();
            completed[i] = false;
        }

        // Calculate waiting time and turnaround time
        int currentTime = 0;
        int completedCount = 0;
        while (completedCount < n) {
            int shortestJob = -1;
            int shortestTime = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                if (!completed[i] && burstTime[i] < shortestTime) {
                    shortestJob = i;
                    shortestTime = burstTime[i];
                }
            }
            if (shortestJob == -1) break;
            waitingTime[shortestJob] = currentTime;
            turnaroundTime[shortestJob] = currentTime + burstTime[shortestJob];
            currentTime += burstTime[shortestJob];
            completed[shortestJob] = true;
            completedCount++;
        }

        // Calculate average waiting time and average turnaround time
        double avgWaitingTime = 0, avgTurnaroundTime = 0;
        for (int i = 0; i < n; i++) {
            avgWaitingTime += waitingTime[i];
            avgTurnaroundTime += turnaroundTime[i];
        }
        avgWaitingTime /= n;
        avgTurnaroundTime /= n;

        // Print results
        System.out.println("Process\tBurst time\tWaiting time\tTurnaround time");
        for (int i = 0; i < n; i++) {
            System.out.println("P" + (i+1) + "\t" + burstTime[i] + "\t\t" + waitingTime[i] + "\t\t" + turnaroundTime[i]);
        }
        System.out.println("Average waiting time: " + avgWaitingTime);
        System.out.println("Average turnaround time: " + avgTurnaroundTime);
    }
}
