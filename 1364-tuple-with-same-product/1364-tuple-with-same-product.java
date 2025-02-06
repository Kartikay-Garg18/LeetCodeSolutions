class Solution {
    public int tupleSameProduct(int[] nums) {
        int n = nums.length;
        if(n<4) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int mul = nums[i] * nums[j];
                map.put(mul, map.getOrDefault(mul, 0) + 1);
            }
        }
        int cnt = 0;
        for(int val : map.values()){
            cnt+=(4*val*(val-1));
        }
        return cnt;
    }
}