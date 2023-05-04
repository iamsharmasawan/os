import java.util.*;

public class RoundRobin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of processes: ");
        int n = sc.nextInt();

        int[] burstTimes = new int[n];
        int[] waitingTimes = new int[n];
        int[] turnaroundTimes = new int[n];

        System.out.print("Enter the time quantum: ");
        int timeQuantum = sc.nextInt();

        System.out.println("Enter the burst times for each process:");
        for (int i = 0; i < n; i++) {
            System.out.print("Process " + (i + 1) + ": ");
            burstTimes[i] = sc.nextInt();
        }

        // Create a queue to store the processes
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < n; i++) {
            queue.add(i);
        }

        int currentTime = 0;
        while (!queue.isEmpty()) {
            int process = queue.remove();
            if (burstTimes[process] > timeQuantum) {
                // Process still has work to do after time quantum
                currentTime += timeQuantum;
                burstTimes[process] -= timeQuantum;
                queue.add(process);
            } else {
                // Process has finished
                currentTime += burstTimes[process];
                waitingTimes[process] = currentTime - burstTimes[process];
                turnaroundTimes[process] = currentTime;
            }
        }

        // Calculate average waiting time and average turnaround time
        double avgWaitingTime = 0;
        double avgTurnaroundTime = 0;
        for (int i = 0; i < n; i++) {
            avgWaitingTime += waitingTimes[i];
            avgTurnaroundTime += turnaroundTimes[i];
        }
        avgWaitingTime /= n;
        avgTurnaroundTime /= n;

        // Print the output
        System.out.printf("%-10s%-10s%-10s%-10s\n", "Process", "Burst Time", "Waiting Time", "Turnaround Time");
        for (int i = 0; i < n; i++) {
            System.out.printf("%-10d%-10d%-10d%-10d\n", i + 1, burstTimes[i], waitingTimes[i], turnaroundTimes[i]);
        }
        System.out.println("Average waiting time: " + avgWaitingTime);
        System.out.println("Average turnaround time: " + avgTurnaroundTime);
    }
}
