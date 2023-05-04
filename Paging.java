import java.util.Scanner;

public class Paging {
    public static void main(String[] args) {
        int ms, ps, nop, np, rempages, i, j, x, y, pa, offset;
        int[][] fno = new int[10][20];
        int[] s = new int[10];
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the memory size -- ");
        ms = sc.nextInt();
        System.out.print("Enter the page size -- ");
        ps = sc.nextInt();
        nop = ms / ps;
        System.out.printf("The no. of pages available in memory are -- %d%n", nop);
        System.out.print("Enter number of processes -- ");
        np = sc.nextInt();
        rempages = nop;
        for (i = 1; i <= np; i++) {
            System.out.printf("Enter no. of pages required for p[%d]-- ", i);
            s[i] = sc.nextInt();
            if (s[i] > rempages) {
                System.out.println("Memory is Full");
                break;
            }
            rempages = rempages - s[i];
            System.out.printf("Enter pagetable for p[%d] --- ", i);
            for (j = 0; j < s[i]; j++)
                fno[i][j] = sc.nextInt();
        }
        System.out.println("Enter Logical Address to find Physical Address ");
        System.out.print("Enter process no. and pagenumber and offset -- ");
        x = sc.nextInt();
        y = sc.nextInt();
        offset = sc.nextInt();
        if (x > np || y >= s[i] || offset >= ps)
            System.out.println("Invalid Process or Page Number or offset");
        else {
            pa = fno[x][y] * ps + offset;
            System.out.printf("The Physical Address is -- %d%n", pa);
        }
        sc.close();
    }
}