class Solution {
    public boolean canConstruct(String s, int k) {
        if(k>s.length()) return false;
        int[] freq = new int[26];
        for(char ch : s.toCharArray()){
            freq[ch-'a']++;
        }
        int odds = 0;
        for(int ele : freq){
            if(ele%2!=0){
                odds++;
            }
        }
        if(odds>k) return false;
        return true;
    }
}