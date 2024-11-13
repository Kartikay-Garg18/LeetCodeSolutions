class Solution {
    private int low(int[] nums, int ele, int low, int high, int st, int end){
        int ans = nums.length;
        while(st<=end){
            int mid = st + (end-st)/2;
            long sum = ele + nums[mid];
            if(sum>=low){
                if(sum<=high) ans = mid;
                end = mid-1;
            } else{
                st = mid+1;
            }
        }
        return ans;
    }

    private int high(int[] nums, int ele, int low, int high, int st, int end){
        int ans = -1;
        while(st<=end){
            int mid = st + (end-st)/2;
            long sum = ele + nums[mid];
            if(sum<=high){
                if(sum>=low) ans = mid;
                st = mid+1;
            } else{
                end = mid-1;
            }
        }
        return ans;
    }

    public long countFairPairs(int[] nums, int lower, int upper) {
        int n = nums.length;
        Arrays.sort(nums);
        long count = 0;
        int highest = n-1;

        for(int i=0; i<n; i++){
            int ele = nums[i];
            int lowest = low(nums, ele, lower, upper, i+1, highest);
            if(lowest == n) continue;
            highest = high(nums, ele, lower, upper, lowest, highest);
            if(highest == -1) break;
            count+= (highest-lowest+1);
        }

        return count;
    }
}