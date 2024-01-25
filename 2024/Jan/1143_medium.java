// https://leetcode.com/problems/longest-common-subsequence/description/
// Longest Common Subsequence

class Solution {
    int[][] dp;
    String text1, text2;
    int f(int i, int j) {

        if(i == text1.length() || j == text2.length()) {
            return 0;
        }
        
        if(dp[i][j] != -1) {
            return dp[i][j];
        }
        int ret = 0;
        if(text1.charAt(i) == text2.charAt(j)) {
            ret = 1 + f(i+1, j+1);
        } else {
            ret = Math.max(f(i+1, j+1), Math.max(f(i+1, j), f(i, j+1)));
        }
        dp[i][j] = ret;
        return ret;
    }

    public int longestCommonSubsequence(String text1, String text2) {
        this.dp = new int[text1.length()][text2.length()];
        for(int[] x: dp) {
            Arrays.fill(x, -1);
        }
        this.text1 = text1;
        this.text2 = text2;
        return f(0, 0);
    }
}
