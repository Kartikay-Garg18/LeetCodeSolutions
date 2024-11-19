class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        boolean[] freq = new boolean[100001];
        int l = 0;
        int r = 0;
        int size = 0;
        int n = nums.length;
        long sum = 0;
        long max = 0;
        while(r<n){
            while(r<n && size<k){
                if(!freq[nums[r]]){
                    sum+=nums[r];
                    freq[nums[r]] = true;
                    r++;
                    size++;
                } else{
                    while(freq[nums[r]]){
                        sum-=nums[l];
                        freq[nums[l]] = false;
                        l++;
                        size--;
                    }
                }
            }
            if(size == k) max = Math.max(max, sum);
            size--;
            sum-=nums[l];
            freq[nums[l]] = false;
            l++;
        }
        return max;
    }
}