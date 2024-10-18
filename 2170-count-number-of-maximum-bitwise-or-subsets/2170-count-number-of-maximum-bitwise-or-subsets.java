class Solution {

    HashSet<List<Integer>> list = new HashSet<>();

    public void findOr(int[] nums, int idx, int or, int[] max, List<Integer> ans){
        if(or>max[0]){
            max[0] = or;
            list.clear();
            list.add(new ArrayList<>(ans));
        } else if(or==max[0]){
            list.add(new ArrayList<>(ans));
        }
        
        if(idx>= nums.length) return;

        findOr(nums, idx+1, or, max, ans);
        ans.add(idx);
        findOr(nums, idx+1, or|nums[idx], max, ans);
        ans.remove(ans.size()-1);
    }

    public int countMaxOrSubsets(int[] nums) {
        int[] maxOr = {0};
        int n = nums.length;
        findOr(nums, 0, 0, maxOr, new ArrayList<>());
        return list.size();
    }
}