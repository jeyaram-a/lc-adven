// https://leetcode.com/problems/longest-increasing-subsequenc/description
// Longest Increasing Subsequence

class Solution {
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> al = new ArrayList<>();

        for(int num: nums) {
            int l = al.size();
            if(al.isEmpty() || al.get(l-1) < num) {
                al.add(num);
            } else {
                int loc = Collections.binarySearch(al, num);
                if(loc < 0) {
                    loc = -loc-1;
                }
                al.set(loc, num);
            }
        }
        return al.size();
    }
}
