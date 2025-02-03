class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        boolean flag = true;
        int size = 1;
        int max = 1;
        int n = nums.length;
        for(int i=1; i<n; i++){
            if(nums[i]>nums[i-1]){
                if(flag){
                    size++;
                } else{
                    size=2;
                    flag = true;
                }
            } else if(nums[i] < nums[i-1]){
                if(!flag){
                    size++;
                } else{
                    size = 2;
                    flag = false;
                }
            } else{
                size = 1;
                flag = true;
            }
            max = Math.max(size, max);
        }
        return max;
    }
}