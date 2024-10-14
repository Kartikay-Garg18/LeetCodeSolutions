class Solution {
    public int firstUniqChar(String s) {
        int ans = s.length();
        for(char ch='a'; ch<='z'; ch++){
            int idx = s.indexOf(ch);
            if(idx!=-1 && idx == s.lastIndexOf(ch)){
                ans = Math.min(ans, idx);
            }
        }
        return ans==s.length()?-1 : ans;
    }
}