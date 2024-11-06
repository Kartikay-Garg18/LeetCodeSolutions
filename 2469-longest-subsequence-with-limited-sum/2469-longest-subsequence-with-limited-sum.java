class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        int sum = 0;
        for(int ele : nums) sum+=ele;
        Arrays.sort(nums);
        int n = nums.length;
        int m = queries.length;
        int[] ans = new int[m];
        for(int i=0; i<m; i++){
            int q = queries[i];
            int idx = n-1;
            int s = 0;
            while(idx>=0 && sum-s>q){
                s+=nums[idx--];
            }
            ans[i] = idx+1;
        }
        return ans;
    }
}