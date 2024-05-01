/*Write a program to find minimum number of multiplications in Matrix Chain 
Multiplication */
class Slip13a {
    static int matrixChainOrder(int p[], int n) {
        int m[][] = new int[n][n];

        int i, j, k, L, q;

        for (i = 1; i < n; i++)
            m[i][i] = 0; // cost is zero when multiplying one matrix.

        // L is chain length.
        for (L = 2; L < n; L++) {
            for (i = 1; i < n - L + 1; i++) {
                j = i + L - 1;
                if (j == n)
                    continue;
                m[i][j] = Integer.MAX_VALUE;
                for (k = i; k <= j - 1; k++) {
                    // q = cost/scalar multiplications
                    q = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (q < m[i][j])
                        m[i][j] = q;
                }
            }
        }

        return m[1][n - 1];
    }

    public static void main(String args[]) {
        int arr[] = new int[] { 1, 2, 3, 4 };
        int size = arr.length;

        System.out.println("Minimum number of multiplications is " + matrixChainOrder(arr, size));
    }
}
