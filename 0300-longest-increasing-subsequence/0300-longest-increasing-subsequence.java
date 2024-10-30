class Solution {
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> dp=new ArrayList<>();
        dp.add(nums[0]);
        ArrayList<Integer> ans= new ArrayList<>(dp);

        for(int i=1;i<nums.length;i++){
            if(nums[i]>dp.get(dp.size()-1)){
                dp.add(nums[i]);
            }
            else{
                int idx=binarySearch(dp,nums[i]);
                dp.set(idx,nums[i]);
            }
            if(ans.size()<dp.size()) ans= new ArrayList<>(dp);
        }
        
        return dp.size();
    }

    public int binarySearch(ArrayList<Integer> dp,int target){
        int st=0;
        int end=dp.size()-1;
        int ans=dp.size()-1;

        while(st<=end){
            int mid=st+(end-st)/2;
            if(dp.get(mid)>=target){
                ans=mid;
                end=mid-1;
            }
            else{
                st=mid+1;
            }
        }
        return ans;
    }
}