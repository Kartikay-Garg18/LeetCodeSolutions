class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int ele : nums) map.put(ele, map.getOrDefault(ele, 0) + 1);
        int thres = nums.length/3;
        List<Integer> ans = new ArrayList<>();
        for(int key : map.keySet()){
            if(map.get(key)>thres) ans.add(key);
        }
        return ans;
    }
}