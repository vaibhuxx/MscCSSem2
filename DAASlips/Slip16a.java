/*Write a program to implement to find out solution for 0/1 knapsack problem using 
dynamic programming. */

public class Slip16a {
    static int knapsack(int W, int wt[], int val[], int n) {
        int i, w;
        int[][] K = new int[n + 1][W + 1];

        // Build table K[][] in bottom-up manner
        for (i = 0; i <= n; i++) {
            for (w = 0; w <= W; w++) {
                if (i == 0 || w == 0)
                    K[i][w] = 0;
                else if (wt[i - 1] <= w)
                    K[i][w] = Math.max(val[i - 1] + K[i - 1][w - wt[i - 1]], K[i - 1][w]);
                else
                    K[i][w] = K[i - 1][w];
            }
        }

        return K[n][W];
    }

    public static void main(String args[]) {
        int val[] = { 60, 100, 120 };
        int wt[] = { 10, 20, 30 };
        int W = 50;
        int n = val.length;
        System.out.println("Maximum value that can be obtained = " + knapsack(W, wt, val, n));
    }
}
