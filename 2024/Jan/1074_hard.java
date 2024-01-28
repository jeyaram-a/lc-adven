// https://leetcode.com/problems/number-of-submatrices-that-sum-to-target
// Number of submatrices that sum to target

class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int l = matrix.length, b = matrix[0].length;
        int[][] psum = new int[l+1][b+1];

        for(int i=1; i<=l; i++) {
            for(int j=1; j<=b; j++) {
                psum[i][j] = matrix[i-1][j-1] + psum[i][j-1] + psum[i-1][j] - psum[i-1][j-1];
            }
        }

        for(int[] x: psum) {
            System.out.println(Arrays.toString(x));
        }

        long ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=1; i<=l; i++) {
            for(int j=i; j<=l; j++) {
                map.put(0, 1);
                for(int k=1; k<=b; k++) {
                    int area = psum[j][k] - psum[i-1][k];
                    Integer val = map.get(area - target);
                    if(val != null) {
                        ans += val;
                    }
                    map.put(area, map.getOrDefault(area, 0)+1);
                }
                map.clear();
            }
        }
        return (int)ans;
    }
}
