class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int i=0;
        int j=0;
        HashSet<Integer> set = new HashSet<>();
        int max = 0;
        int score = 0;
        while(j<nums.length){
            while(j<nums.length && !set.contains(nums[j])){
                score+=nums[j];
                set.add(nums[j]);
                j++;
            }
            max = Math.max(score, max);
            while(j<nums.length && set.contains(nums[j])){
                score-=nums[i];
                set.remove(nums[i]);
                i++;
            }
        }
        return max;
    }
}