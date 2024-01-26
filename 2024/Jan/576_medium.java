// https://leetcode.com/problems/out-of-boundary-paths/description
// Out of boundary paths

class Solution {

    int[][] dirs = {
        {1,0},
        {0,1},
        {-1, 0},
        {0, -1}
    };
    int mod = (int)Math.pow(10, 9)+7;
    int l,b;
    long[][][] dp;

    long f(int i, int j, int r) {
        if(r < 0) {
            return 0;
        }
        if(i >= l || j >= b || i < 0 || j < 0) {
            return 1;
        } 
        if(dp[i][j][r] != -1) {
            return dp[i][j][r];
        }
        long ans = 0;
        for(int[] dir: dirs) {
            ans += f(i+dir[0], j+dir[1], r-1);
        }
        ans %= mod;
        dp[i][j][r] = ans;
        return ans;
    }


    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {

        this.l = m;
        this.b = n;
        this.dp = new long[m+1][n+1][maxMove+1];
        for(long[][] x: dp) {
            for(long[] y: x) {
                Arrays.fill(y, -1);
            }
        }
        return (int)f(startRow, startColumn, maxMove);
        
    }
}
