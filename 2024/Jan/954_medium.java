// https://leetcode.com/problems/array-of-doubled-pairs/description/
// Array of doubled pairs

class Solution {
    public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> countMap = new HashMap<>();

        for(int x: arr) {
            int c = countMap.getOrDefault(x, 0);
            countMap.put(x, c+1);
        }
        Arrays.sort(arr);
        for(int x: arr) {
            int xC = countMap.getOrDefault(x, 0);
            int dC = countMap.getOrDefault(x*2, 0);
            if(dC == 0 || xC==0) {
                continue;
            }
            if(xC > 1) {
                countMap.put(x, xC-1);
            } else {
                countMap.remove(x);
            }
            if(dC > 1) {
                countMap.put(x*2, dC-1);
            } else {
                countMap.remove(x*2);
            }

        }

        return countMap.size() == 0;
    }
}
