class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int cnt = 0;
        int max = 0;
        for(int ele : nums){
            if(ele == 1) cnt++;
            else{
                max = Math.max(cnt, max);
                cnt = 0;
            }
        }
        return Math.max(cnt, max);
    }
}