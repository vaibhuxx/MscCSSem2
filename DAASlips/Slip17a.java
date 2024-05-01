/*Write a program to implement solve ‘N’ Queens Problem using Backtracking */

import java.util.Arrays;

public class Slip17a {
    private int N;
    private int[] queens;

    Slip17a(int N) {
        this.N = N;
        queens = new int[N];
        Arrays.fill(queens, -1);
    }

    boolean isSafe(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (queens[i] == col || Math.abs(i - row) == Math.abs(queens[i] - col))
                return false;
        }
        return true;
    }

    boolean solveNQueensUtil(int row) {
        if (row == N)
            return true;

        for (int col = 0; col < N; col++) {
            if (isSafe(row, col)) {
                queens[row] = col;
                if (solveNQueensUtil(row + 1))
                    return true;
                queens[row] = -1;
            }
        }
        return false;
    }

    void printSolution() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (queens[i] == j)
                    System.out.print("Q ");
                else
                    System.out.print(". ");
            }
            System.out.println();
        }
    }

    boolean solveNQueens() {
        if (!solveNQueensUtil(0)) {
            System.out.println("Solution does not exist");
            return false;
        }

        System.out.println("Solution exists:");
        printSolution();
        return true;
    }

    public static void main(String args[]) {
        int N = 6; // Change N to the desired board size
        Slip17a nQueens = new Slip17a(N);
        nQueens.solveNQueens();
    }
}
