class Solution {
    private int helper(int[] nums, int[] sets, int idx){
        int st = idx;
        int bits = sets[idx];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        while(idx<nums.length && sets[idx] == bits){
            pq.add(nums[idx++]);
        }
        while(st<idx){
            nums[st++] = pq.poll();
        }
        return idx;
    }

    public boolean canSortArray(int[] nums) {
        int n = nums.length;
        int[] sets = new int[n];
        for(int i=0; i<n; i++){
            sets[i] = Integer.bitCount(nums[i]);
        }

        int i=0;
        while(i<n){
            i = helper(nums, sets, i);
        }

        for(i=0; i<n-1; i++){
            if(nums[i]>nums[i+1]) return false;
        }

        return true;
    }
}