class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        int smallest = Integer.MAX_VALUE;
        
        for(int ele : nums) if(ele<smallest) smallest = ele;

        Set<Integer> occ = new HashSet<>();

        for(int i=0; i<n; i++){
            if(nums[i] == smallest) occ.add(i);
        }

        for(int idx : occ){
            boolean flag = true;
            for(int i=idx+1; i<idx+n && flag; i++){
                if(nums[i%n]<nums[(i-1)%n]) flag = false;
            }
            if(flag) return true;
        }

        return false;
    }
}