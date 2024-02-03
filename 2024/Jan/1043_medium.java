// https://leetcode.com/problems/partition-array-for-maximum-sum
// Partition array for maximum sum

class Solution {

    int[] dp;
    int f(int[] arr, int i, int k) {
        if(i >= arr.length) {
            return 0;
        }
        int max = arr[i];
        int ret = 0;
        if(dp[i] != -1) {
            return dp[i];
        }
        for(int j=i; j<arr.length && (j-i+1) <= k; j++) {
            max = Math.max(max, arr[j]);
            ret = Math.max(ret, max*(j-i+1) + f(arr, j+1, k));
        }
        // System.out.printf("%d -> %d\n", i, ret);
        dp[i] = ret;
        return ret;
    }
    
    public int maxSumAfterPartitioning(int[] arr, int k) {
        this.dp = new int[arr.length];
        Arrays.fill(dp, -1);
        return f(arr, 0, k);
    }
}
