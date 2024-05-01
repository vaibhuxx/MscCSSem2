/*  Write a Program to find only length of Longest Common Subsequence */
public class Slip6b {
        static int lcsLength(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m + 1][n + 1];
        // Building the DP table
        for (int i = 0; i <= m; i++) {
        for (int j = 0; j <= n; j++) {
        if (i == 0 || j == 0)
        dp[i][j] = 0;
        else if (str1.charAt(i - 1) == str2.charAt(j - 1))
        dp[i][j] = dp[i - 1][j - 1] + 1;
        else
        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
        }
        return dp[m][n];
        }
        public static void main(String[] args) {
        String str1 = "Hello my name is Vaibhavi";
        String str2 = "Vaibhavi is studying in FY Msc cousre name CS";
        int length = lcsLength(str1, str2);
        System.out.println("Length of Longest Common Subsequence: " + length);
        }
        }
