class Solution {
    int ans = 0;
    public void makeUnique(String s, HashSet<String> set){
        if(s.isEmpty()){
            ans = Math.max(ans, set.size());
        }

        for(int i = 0; i<=s.length(); i++){
            String ans = s.substring(0, i);
            if(!set.contains(ans) && !ans.isEmpty()){
                set.add(ans);
                makeUnique(s.substring(i, s.length()), set);
                set.remove(ans);
            }
        }
        ans = Math.max(ans, set.size());
    }
    public int maxUniqueSplit(String s) {
        HashSet<String> set = new HashSet<>();
        makeUnique(s, set);
        return ans;
    }
}