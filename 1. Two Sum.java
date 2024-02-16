class Solution {
    public int[] twoSum(int[] nums, int target) {
        int fir = -1, sec = -1;
        for (int i=0; i<nums.length; i++){
            int sum = nums[i];
            for (int j = i+1; j<nums.length;j++){
                if ((sum+nums[j])==target){
                    fir = i;
                    sec = j;
                }
            }
        }
        int[] res = {fir, sec};
        return res;
    }
}
