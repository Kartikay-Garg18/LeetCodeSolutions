class Solution {
    public int minOperations(int[] nums) {
        int i=0;
        while(i<nums.length){
            if(nums[i]==0) break;
            i++;
        }
        int count = 0;
        if(i>nums.length-3 && i<nums.length) return -1;
        while(i<nums.length){
            int turns = 3;
            int nxtidx = i;
            boolean flag = true;
            while(turns-->0){
                if(nums[i]==0) nums[i] = 1;
                else nums[i] = 0;
                if(flag && nums[i]==0){
                    flag = false;
                    nxtidx = i;
                }
                i++;
            }
            i = nxtidx;
            if(flag) i+=3;
            count++;
            while(i<nums.length && nums[i]==1) i++;
            if(i>nums.length-3 && i<nums.length) return -1;
        }
        return count;
    }
}