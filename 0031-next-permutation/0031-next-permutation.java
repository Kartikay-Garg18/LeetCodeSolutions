class Solution {
    private void helper(int n, int[] nums, int idx){
        int curr = nums[idx];
        for(int i=n-1; i>idx; i--){
            if(nums[i] > curr){
                nums[idx] = nums[i];
                nums[i] = curr;
                break;
            }
        }
        int st = idx+1;
        int end = n-1;
        while(st<=end){
            int temp = nums[st];
            nums[st] = nums[end];
            nums[end] = temp;
            st++;
            end--;
        }
    }

    public void nextPermutation(int[] nums) {
        int n = nums.length;
        for(int i=n-2; i>=0; i--){
            if(nums[i]<nums[i+1]){
                helper(n, nums, i);
                return;
            }
        }
        Arrays.sort(nums);
    }
}