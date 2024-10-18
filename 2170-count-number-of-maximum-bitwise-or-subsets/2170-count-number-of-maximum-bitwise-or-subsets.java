class Solution {

    public int findOr(int[] nums, int idx, int or, int max){
       
        if(idx>= nums.length) return max==or?1:0;

        return findOr(nums, idx+1, or, max) + findOr(nums, idx+1, or|nums[idx], max);

    }

    public int countMaxOrSubsets(int[] nums) {
        int n = nums.length;
        int max = 0;

        for(int ele : nums) max|=ele;

        return findOr(nums, 0, 0, max);
        
    }
}