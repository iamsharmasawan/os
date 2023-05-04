class BestFit {
    
    static void bestFit(int blockSize[], int m, int processSize[], int n) {
        // Stores block id of the block allocated to a process
        int allocation[] = new int[n];
        
        // Initialize allocation array with -1 indicating no block is assigned to any process
        for (int i = 0; i < allocation.length; i++)
            allocation[i] = -1;
        
        // Traverse each process and find the best block according to its size and assign it
        for (int i = 0; i < n; i++) {
            // Find the best-fit block for the current process
            int bestFitBlock = -1;
            for (int j = 0; j < m; j++) {
                if (blockSize[j] >= processSize[i]) {
                    if (bestFitBlock == -1 || blockSize[j] < blockSize[bestFitBlock]) {
                        bestFitBlock = j;
                    }
                }
            }
            // Allocate the best-fit block to the current process
            if (bestFitBlock != -1) {
                allocation[i] = bestFitBlock;
                blockSize[bestFitBlock] -= processSize[i];
            }
        }
        
        // Print the final allocation table
        System.out.println("\nProcess No.\tProcess Size\tBlock no.");
        for (int i = 0; i < n; i++) {
            System.out.print(" " + (i+1) + "\t\t" + processSize[i] + "\t\t");
            if (allocation[i] != -1)
                System.out.print(allocation[i] + 1);
            else
                System.out.print("Not Allocated");
            System.out.println();
        }
    }
    
    // Driver code
    public static void main(String[] args) {
        int blockSize[] = {100, 500, 200, 300, 600};
        int processSize[] = {212, 417, 112, 426};
        int m = blockSize.length;
        int n = processSize.length;
        
        bestFit(blockSize, m, processSize, n);
    }
}
