class Solution {
    public long countBadPairs(int[] nums) {
        long count = 0;
        int n = nums.length;
        HashMap<Long, Long> map = new HashMap<>();
        for(int i=0; i<n; i++){
            long curr = i - nums[i];
            if(map.containsKey(curr)){
                long val = map.get(curr);
                count+=val;
                map.put(curr, val+1);
            } else{
                map.put(curr, 1L);
            }
        }
        return ((long)(n))*(n-1)/2 - count;
    }
}