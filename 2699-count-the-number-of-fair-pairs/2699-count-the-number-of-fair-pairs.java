class Solution {

    public int findPairs(int a,int s,int e,int lower, int upper,int[]nums){

         if (nums[s] + a > upper || nums[e] + a < lower) {
            return 0;
        }

        while (s <= e) {
            if (nums[s] + a > upper || nums[e] + a < lower) {
                break;
            } else if (nums[s] + a >= lower && nums[e] + a <= upper) {
                return (e - s + 1);
            }

            int mid = s + (e - s) / 2;

            if (nums[mid] + a > upper) {
                e =mid-1;
            }
            else {
                if (nums[s] + a < lower) {
                    s += 1;
                }
                if (nums[e] + a > upper) {
                    e -= 1;
                }
            }
        }
        return 0;
    }


    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);

        long pairs=0;

        for(int i=0;i<nums.length-1;i++){
            pairs+=findPairs(nums[i],i+1,nums.length-1,lower,upper,nums);
        }

        return pairs;
    }
}