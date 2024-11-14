class Solution {
    private boolean isPossible(int n, int[] nums, int target){
        int st = 0;
        int end = nums.length-1;
        int ans = 0;
        while(st<=end){
            int mid = st + (end-st)/2;
            if(nums[mid]>=target){
                ans = mid;
                end = mid-1;
            } else{
                st = mid+1;
            }
        }
        n-=ans;
        for(; ans<nums.length; ans++){
            if(n==0) return false;
            int div = nums[ans]/target;
            if(nums[ans]%target!=0) div++;
            n-=div;
        }
        return n>=0;
    }

    private int binary(int n, int[] nums){
        int st = 1;
        int end = nums[nums.length-1];
        int ans = 0;
        while(st<=end){
            int mid = st + (end-st)/2;
            if(isPossible(n, nums, mid)){
                ans = mid;
                end = mid-1;
            } else{
                st = mid+1;
            }
        }
        return ans;
    }

    public int minimizedMaximum(int n, int[] nums) {
        Arrays.sort(nums);
        return binary(n, nums);
    }
}