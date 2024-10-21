class Solution {
    int ans = 0;
    public void makeUnique(String s, HashSet<String> set){
        if(s.isEmpty()){
            ans = Math.max(ans, set.size());
            return;
        }

        for(int i = 0; i<=s.length(); i++){
            String ans = s.substring(0, i);
            if(!set.contains(ans) && !ans.isEmpty()){
                set.add(ans);
                makeUnique(s.substring(i), set);
                set.remove(ans);
            }
        }
        
    }
    public int maxUniqueSplit(String s) {
        makeUnique(s, new HashSet<>());
        return ans;
    }
}