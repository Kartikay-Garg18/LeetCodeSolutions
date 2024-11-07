class Solution {
    private void helper(String s, List<String> dict, int idx, List<String> list, List<String> ans){
        if(idx>=s.length()){
            ans.add(String.join(" ", list));
            return;
        }

        for(String word : dict){
            int len = word.length();
            if(s.startsWith(word, idx)){
                list.add(word);
                helper(s, dict, idx+len, list, ans);
                list.remove(list.size()-1);
            }
        }
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> ans = new ArrayList<>();
        helper(s, wordDict, 0, new ArrayList<>(), ans);
        return ans;
    }
}