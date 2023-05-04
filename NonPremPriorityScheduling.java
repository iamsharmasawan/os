import java.util.Scanner;

public class NonPremPriorityScheduling {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of processes: ");
        int n = input.nextInt();

        int[] burstTimes = new int[n];
        int[] priorities = new int[n];
        int[] waitingTimes = new int[n];
        int[] turnaroundTimes = new int[n];

        System.out.println("Enter the burst times and priorities for each process:");
        for (int i = 0; i < n; i++) {
            System.out.print("Process " + (i+1) + ": ");
            burstTimes[i] = input.nextInt();
            priorities[i] = input.nextInt();
        }

        // Calculate waiting time, turnaround time, and average waiting time and turnaround time
        int totalWaitingTime = 0;
        int totalTurnaroundTime = 0;
        for (int i = 0; i < n; i++) {
            int minPriority = Integer.MAX_VALUE;
            int minPriorityIndex = -1;

            // Find the process with the highest priority
            for (int j = 0; j < n; j++) {
                if (priorities[j] < minPriority && burstTimes[j] > 0) {
                    minPriority = priorities[j];
                    minPriorityIndex = j;
                }
            }

            // Update waiting time and turnaround time for the selected process
            waitingTimes[minPriorityIndex] = (minPriorityIndex == 0) ? 0 : turnaroundTimes[minPriorityIndex-1];
            turnaroundTimes[minPriorityIndex] = waitingTimes[minPriorityIndex] + burstTimes[minPriorityIndex];

            // Update burst time of the selected process
            burstTimes[minPriorityIndex] = 0;

            // Update total waiting time and total turnaround time
            totalWaitingTime += waitingTimes[minPriorityIndex];
            totalTurnaroundTime += turnaroundTimes[minPriorityIndex];
        }

        // Calculate average waiting time and average turnaround time
        double avgWaitingTime = (double) totalWaitingTime / n;
        double avgTurnaroundTime = (double) totalTurnaroundTime / n;

        // Print results
        System.out.println("Process\tBurst Time\tPriority\tWaiting Time\tTurnaround Time");
        for (int i = 0; i < n; i++) {
            System.out.println((i+1) + "\t\t" + burstTimes[i] + "\t\t" + priorities[i] + "\t\t" + waitingTimes[i] + "\t\t" + turnaroundTimes[i]);
        }
        System.out.println("\nAverage Waiting Time: " + avgWaitingTime);
        System.out.println("Average Turnaround Time: " + avgTurnaroundTime);
    }
}
