class Solution {
    public static int removeDuplicates(int[] nums){
        // int unique = 1;
        int i=0;
        int pos=1;
        for (int j=i+1; j<nums.length; j++){
            if (nums[i]!=nums[j]){
                // unique++;
                nums[pos++] = nums[j];
                i=j;
            }
        }
        return pos;
    }
}