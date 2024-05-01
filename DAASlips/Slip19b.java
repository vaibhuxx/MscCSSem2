/* Write a program to show board configuration of 4 queens’ problem. */

public class Slip19b{
    // Function to solve 4 Queens problem
    public static void solveFourQueens() {
    char[][] board = new char[4][4];
    for (char[] row : board) {
    for (int j = 0; j < row.length; j++) {
    row[j] = '.';
    }
    }
    backtrack(board, 0);
    }
    // Backtracking function to find all solutions
    private static void backtrack(char[][] board, int col) {
    if (col == 4) {
    printBoard(board);
    System.out.println();
    return;
    }
    for (int row = 0; row < 4; row++) {
    if (isValid(board, row, col)) {
    board[row][col] = 'Q'; // Place the queen
    backtrack(board, col + 1); // Move to the next column
    board[row][col] = '.'; // Backtrack by removing the queen
    }
    }
    }
    // Function to check if placing a queen at board[row][col] is valid
    private static boolean isValid(char[][] board, int row, int col) {
    // Check the row
    for (int i = 0; i < col; i++) {
    if (board[row][i] == 'Q') {
    return false;
    }
    }
    // Check the upper diagonal
    for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
    if (board[i][j] == 'Q') {
    return false;
    }
    }
    // Check the lower diagonal
    for (int i = row, j = col; i < 4 && j >= 0; i++, j--) {
    if (board[i][j] == 'Q') {
    return false;
    }
    }
    return true;
    }
    // Function to print the board configuration
    private static void printBoard(char[][] board) {
    for (char[] row : board) {
    for (char cell : row) {
    System.out.print(cell + " ");
    }
    System.out.println();
    }
    }
    // Main method to test the program
    public static void main(String[] args) {
    System.out.println("Board configurations of 4 queens problem:");
    solveFourQueens();
    }
   }
