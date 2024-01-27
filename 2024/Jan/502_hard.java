// https://leetcode.com/problems/ipo/description/
// IPO
// Very similiar to 1235. Maximum Profit in job Scheduling
//
class Solution {

    record Entry(int p, int c) {}

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int l = profits.length;
        Entry[] arr = new Entry[l];
        for(int i=0; i<l; i++) {
            arr[i] = new Entry(profits[i], capital[i]);
        }
        Arrays.sort(arr, (x, y) -> Integer.compare(x.c, y.c));
        var pq = new PriorityQueue<Entry>((x, y) -> Integer.compare(y.p, x.p));
        int i = 0;
        int ans = 0;
        while(k > 0) {

            while(i<l && arr[i].c <= w) {
                pq.offer(arr[i]);
                i++;
            }

            if(pq.isEmpty()) {
                return w;
            }

            w += pq.poll().p;

            --k;
        }

        return w;
    }
}
