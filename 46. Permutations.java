class Solution {
    public static void helper(ArrayList<Integer> temp, List<List<Integer>> list, ArrayList<Integer> ans){
        if (temp.isEmpty()){
            list.add(new ArrayList<>(ans));
            return;
        }
        for (int i=0; i < temp.size(); i++){
            int n = temp.get(i);
            ans.add(temp.get(i));
            temp.remove(i);
            helper(temp, list, ans);
            temp.add(i, n);
            ans.remove(ans.size()-1);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for(int num : nums){
            temp.add(num);
        }
        helper(temp, list, ans);
        return list;
    }
}
