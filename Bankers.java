import java.util.ArrayList;

public class Bankers {
	static int P = 4;
	static int R = 3;
	static int total = 0;

    static boolean is_available(int process, int allocated[][], int max[][], int need[][], int available[], ArrayList<Integer> safe) {
        for (int j = 0; j < R; j++) {
            if(need[process][j] > available[j]){
                return false;
            }
        }
        return true;
    }
    
    static void safe_sequence(boolean marked[], int allocated[][], int max[][], int need[][], int available[], ArrayList<Integer> safe){
        for(int i = 0; i < P; i++) {
            
            if(!marked[i] && is_available(i, allocated, max, need, available, safe)){
                marked[i] = true;

                for (int j = 0; j < R; j++) {
                    available[j] += allocated[i][j];
                }

                safe.add(i);

                safe_sequence(marked, allocated, max, need, available, safe);

                safe.remove(safe.size() - 1);

                marked[i] = false;

                for (int j = 0; j < R; j++) {
                    available[j] -= allocated[i][j];
                }
            }
        }
        if(safe.size() == P) {
            for (int i = 0; i < P; i++) {
                System.out.print("P" + (safe.get(i) + 1));
                if(i != P -1) {
                    System.out.print(" --> ");
                }
            }
            System.out.println();

        }
    }
    public static void main(String[] args) {
        int allocated[][] = {{0, 1, 0},
		{2, 0, 0},
		{3, 0, 2},
		{2, 1, 1}};

		int max[][] = {{7, 5, 3},
		{3, 2, 2},
		{9, 0, 2},
		{2, 2, 2}};

        int resources[] = {10, 5, 7};

        int available[] = new int[R];
        for(int i = 0; i < R; i++){
            int sum = 0; 
            for(int j = 0; j < P; j++) {
                sum += allocated[j][i];
            }

            available[i] = resources[i] - sum; 
        }

        int need[][] = new int[P][R];
        for(int i = 0; i < P; i++) {
            for(int j = 0; j < R; j++) {
                need[i][j] = max[i][j] - allocated[i][j];
            }
        }

        boolean marked[] = new boolean[P];
        ArrayList<Integer> safe = new ArrayList<Integer>();

        safe_sequence(marked, allocated, max, need, available, safe);

    }
}
