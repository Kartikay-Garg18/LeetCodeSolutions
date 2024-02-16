class Solution {
        public static int firstOcc(int[] nums, int target){
        int st = 0;
        int end = nums.length - 1;
        int ans = -1;
        while (st<=end){
            int mid = st + (end - st)/2;
            if(nums[mid] == target){
                ans = mid;
                end = mid - 1;
            } else if (nums[mid] < target){
                st = mid + 1;
            } else {
                end = mid -1;
            }
        }
        return ans;
    }
    public static int lastOcc(int[] nums, int target){
        int st = 0;
        int end = nums.length - 1;
        int ans = -1;
        while (st<=end){
            int mid = st + (end - st)/2;
            if(nums[mid] == target){
                ans = mid;
                st = mid + 1;
            } else if (nums[mid] < target){
                st = mid + 1;
            } else {
                end = mid -1;
            }
        }
        return ans;
    }
    public static int[] searchRange(int[] nums, int target){
        int first = firstOcc(nums, target);
        int last = lastOcc(nums, target);

        int[] ans = {first, last};
        return ans;
    }
}
