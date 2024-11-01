class Solution {
    public int[] rearrangeArray(int[] nums) {
        int l = nums.length;
        int[] pos = new int[l/2];
        int[] neg = new int[l/2];
        int p = 0;
        int n = 0;
        for(int ele : nums){
            if(ele>0) pos[p++] = ele;
            else neg[n++] = ele;
        }
        p=n=0;
        for(int i=0; i<l; i++){
            if(i%2==0){
                nums[i] = pos[p++];
            } else{
                nums[i] = neg[n++];
            }
        }
        return nums;
    }
}