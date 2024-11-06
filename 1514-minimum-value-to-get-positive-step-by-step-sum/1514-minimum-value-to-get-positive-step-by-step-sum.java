class Solution {
    public int minStartValue(int[] nums) {
        int sum = 0;
        int max = 0;
        for(int ele : nums){
            sum+=ele;
            max = Math.min(max, sum);
        }
        return Math.abs(max)+1;
    }
}