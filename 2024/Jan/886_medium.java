// https://leetcode.com/problems/possible-bipartition/description/
// Possible bipartition


class Solution {

    Map<Integer, List<Integer>> map = new HashMap<>();
    int[] color;

    boolean dfs(int i, int c) {
        if(color[i] != -1) {
            return color[i] == c;
        }
        color[i] = c;
        int nc = (1-c);
        for(int n: map.get(i)) {
            if(!dfs(n, nc)) {
                return false;
            }
        }
        return true;
    }

    public boolean possibleBipartition(int n, int[][] dislikes) {
        this.color = new int[n+1];
        Arrays.fill(this.color, -1);

        for(int i=1; i<=n; i++) {
            map.put(i, new ArrayList<>());
        }

        for(int[] d: dislikes) {
            int a = d[0], b = d[1];
            map.get(a).add(b);
            map.get(b).add(a);
        }

        for(int i=1; i<=n; i++) {
            if(color[i] == -1 && !dfs(i, 1)) {
                return false;
            }
        }
        return true;

    }
}
