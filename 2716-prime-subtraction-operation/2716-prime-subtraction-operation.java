class Solution {
    boolean[] prime;
    Boolean[][] dp;
    private void primeSeive(int n){
        for(int i=2; i*i<=n; i++){
            if(prime[i]){
                for(int p = i*i; p<=n; p+=i){
                    prime[p] = false;
                }
            }
        }
    }

    private boolean isSorted(int[] nums, int idx, int p){

        if(idx == nums.length) return true;

        if(dp[idx][p] != null) return dp[idx][p];

        int num = nums[idx];

        if(p<num){
            if(isSorted(nums, idx+1, num)) return dp[idx][p] = true;
        }

        for(int i=num-1; i>=2; i--){
            if(prime[i] && num-i>p){
                if(isSorted(nums, idx+1, num-i)) return dp[idx][p] = true;
            }
        }

        return dp[idx][p] = false;
    }

    public boolean primeSubOperation(int[] nums) {
        int n = nums.length;
        if(n==1) return true;
        int max = -1;
        for(int ele : nums)
            if(max<ele) max = ele;

        dp = new Boolean[n][max+1];
        prime = new boolean[max+1];
        Arrays.fill(prime, true);
        primeSeive(max);
        
        return isSorted(nums, 0, 0);
        // int parent = 0;
        // for(int i)
    }
}