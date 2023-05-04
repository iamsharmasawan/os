class WorstFit {
    public static void worstFit(int[] blockSize, int m, int[] processSize, int n) {
        // stores block id of the block allocated to a process
        int[] allocation = new int[n];

        // initialize allocation array with -1 indicating no block is assigned to any process
        for (int i = 0; i < allocation.length; i++)
            allocation[i] = -1;

        // pick each process and find the largest block available for it
        for (int i = 0; i < n; i++) {
            // find the largest block available for this process
            int largestBlockIdx = -1;
            for (int j = 0; j < m; j++) {
                if (blockSize[j] >= processSize[i]) {
                    if (largestBlockIdx == -1 || blockSize[j] > blockSize[largestBlockIdx]) {
                        largestBlockIdx = j;
                    }
                }
            }

            if (largestBlockIdx != -1) {
                // allocate the largest block to this process
                allocation[i] = largestBlockIdx;

                // reduce available memory in this block
                blockSize[largestBlockIdx] -= processSize[i];
            }
        }

        // print the final allocation table
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

    public static void main(String[] args) {
        int[] blockSize = {100, 500, 200, 300, 600};
        int[] processSize = {212, 417, 112, 426};
        int m = blockSize.length;
        int n = processSize.length;

        worstFit(blockSize, m, processSize, n);
    }
}
