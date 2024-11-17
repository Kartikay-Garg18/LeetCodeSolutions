class Solution {
    public int shortestSubarray(int[] nums, int k) {

        int n = nums.length;
        long[] total = new long[n+1];
        int i=0;
        int ans = n+1;

        while(i<n){
            total[i+1] = nums[i] + total[i];
            i++;
        }

        Deque<Integer> deque = new ArrayDeque<>();

        for(i=0; i<n+1; i++){

            while(!deque.isEmpty() && total[i]-total[deque.peekFirst()]>=k){
                ans = Math.min(ans, i-deque.pollFirst());
            }
            while(!deque.isEmpty() && total[i]<=total[deque.peekLast()]){
                deque.pollLast();
            }
            deque.add(i);
        }

        return ans>n?-1 : ans;
    }
}