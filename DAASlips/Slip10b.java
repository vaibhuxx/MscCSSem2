/* Write a program to solve 4 Queens Problem using Backtracking */
import java.util.*;
public class Slip10b {
 // Function to solve 4 Queens problem
 public static List<List<String>> solveFourQueens() {
 List<List<String>> result = new ArrayList<>();
 char[][] board = new char[4][4];
 for (char[] row : board) {
 Arrays.fill(row, '.');
 }
 backtrack(result, board, 0);
 return result;
 }
 // Backtracking function to find all solutions
 private static void backtrack(List<List<String>> result, char[][] board, int col) {
 if (col == 4) {
 result.add(construct(board));
 return;
 }
 for (int row = 0; row < 4; row++) {
 if (isValid(board, row, col)) {
 board[row][col] = 'Q'; // Place the queen
 backtrack(result, board, col + 1); // Move to the next column
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
 // Function to construct a solution from the board
 private static List<String> construct(char[][] board) {
 List<String> solution = new ArrayList<>();
 for (char[] row : board) {
 solution.add(new String(row));
 }
 return solution;
 }
 // Main method to test the program
 public static void main(String[] args) {
 List<List<String>> solutions = solveFourQueens();
 System.out.println("Number of solutions for 4 queens: " + solutions.size());
 for (int i = 0; i < solutions.size(); i++) {
 System.out.println("Solution " + (i + 1) + ":");
 for (String row : solutions.get(i)) {
 System.out.println(row);
 }
 System.out.println();
 }
 }
}
