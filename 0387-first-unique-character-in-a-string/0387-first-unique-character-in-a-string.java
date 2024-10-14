class Solution {
    public int firstUniqChar(String s) {
        int ans = Integer.MAX_VALUE;
        for(char ch='a'; ch<='z'; ch++){
            if(s.indexOf(ch)!=-1 && s.indexOf(ch) == s.lastIndexOf(ch)){
                ans = Math.min(ans, s.indexOf(ch));
            }
        }
        return ans==Integer.MAX_VALUE?-1 : ans;
    }
}