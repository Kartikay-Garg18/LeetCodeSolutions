class Solution {
    public int minStartValue(int[] nums) {
        int sum = 0;
        int max = 0;
        for(int ele : nums){
            sum+=ele;
            if(sum<max) max = sum;
        }
        if(max<0) return -max+1;
        return 1;
    }
}