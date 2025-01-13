class Solution {
    public static int removeDuplicates(int[] nums){
        
        int i=0;
        int pos=1;
        for (int j=i+1; j<nums.length; j++){
            if (nums[i]!=nums[j]){
                nums[pos++] = nums[j];
                i=j;
            }
        }
        
        return pos;
    }
}