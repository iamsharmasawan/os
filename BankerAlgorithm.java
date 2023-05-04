import java.util.Scanner;

public class BankerAlgorithm {
    int need[][], allocate[][], max[][], available[][], np, nr;

    void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no. of processes and resources: ");
        np = sc.nextInt();
        nr = sc.nextInt();
        need = new int[np][nr];
        max = new int[np][nr];
        allocate = new int[np][nr];
        available = new int[1][nr];

        System.out.println("Enter allocation matrix: ");
        for (int i = 0; i < np; i++) {
            for (int j = 0; j < nr; j++) {
                allocate[i][j] = sc.nextInt();
            }
        }

        System.out.println("Enter max matrix: ");
        for (int i = 0; i < np; i++) {
            for (int j = 0; j < nr; j++) {
                max[i][j] = sc.nextInt();
            }
        }

        System.out.println("Enter available matrix: ");
        for (int j = 0; j < nr; j++) {
            available[0][j] = sc.nextInt();
        }

        sc.close();
    }

    void calculateNeed() {
        for (int i = 0; i < np; i++) {
            for (int j = 0; j < nr; j++) {
                need[i][j] = max[i][j] - allocate[i][j];
            }
        }
    }

    boolean isSafe() {
        int[] work = new int[nr];
        boolean[] finish = new boolean[np];
        for (int i = 0; i < nr; i++) {
            work[i] = available[0][i];
        }
        int count = 0;
        while (count < np) {
            boolean found = false;
            for (int i = 0; i < np; i++) {
                if (!finish[i]) {
                    int j;
                    for (j = 0; j < nr; j++) {
                        if (need[i][j] > work[j])
                            break;
                    }
                    if (j == nr) {
                        for (int k = 0; k < nr; k++)
                            work[k] += allocate[i][k];
                        found = true;
                        finish[i] = true;
                        count++;
                    }
                }
            }
            if (!found) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        BankerAlgorithm bankersAlgorithm = new BankerAlgorithm();
        bankersAlgorithm.input();
        bankersAlgorithm.calculateNeed();
        if (bankersAlgorithm.isSafe()) {
            System.out.println("The system is safe.");
        } else {
            System.out.println("The system is not safe.");
        }
    }
}
