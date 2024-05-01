/*Write a program to implement an optimal binary search tree and also calculate the
best case and worst-case complexity. */

class Slip13b {
    static int optimalSearchTree(int keys[], int freq[], int n) {
        // Create an auxiliary 2D table to store results of subproblems
        int cost[][] = new int[n + 1][n + 1];

        // For a single key, the cost is equal to the frequency of the key
        for (int i = 0; i < n; i++)
            cost[i][i] = freq[i];

        // Now we need to consider chains of length 2, 3, ... .
        // L is chain length.
        for (int L = 2; L <= n; L++) {
            // i is row number in cost[][]
            for (int i = 0; i <= n - L + 1; i++) {
                // Get column number j from row number i and chain length L
                int j = i + L - 1;
                cost[i][j] = Integer.MAX_VALUE;

                // Try making all keys in the interval keys[i..j] as root
                for (int r = i; r <= j; r++) {
                    // Calculate the cost when keys[r] becomes the root of the tree
                    int c = ((r > i) ? cost[i][r - 1] : 0) + ((r < j) ? cost[r + 1][j] : 0) + sum(freq, i, j);
                    if (c < cost[i][j])
                        cost[i][j] = c;
                }
            }
        }
        return cost[0][n - 1];
    }

    // A utility function to get sum of array elements freq[i] to freq[j]
    static int sum(int freq[], int i, int j) {
        int s = 0;
        for (int k = i; k <= j; k++) {
            if (k >= freq.length)
                continue;
            s += freq[k];
        }
        return s;
    }

    public static void main(String[] args) {
        int keys[] = { 10, 12, 20 };
        int freq[] = { 34, 8, 50 };
        int n = keys.length;
        System.out.println("Cost of optimal BST is " + optimalSearchTree(keys, freq, n));
    }
}
