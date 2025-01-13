class Solution {
    public int minimumLength(String s) {
        int len = s.length();
        if(len<=2) return len;
        int[] freq = new int[26];
        for(char ch : s.toCharArray()){
            freq[ch-'a']++;
        }
        int count = 0;
        for(int i=0; i<26; i++){
            if(freq[i] == 0) continue;
            else{
                if(freq[i]%2 == 0) count+=2;
                else count++;
            }
        }
        return count;
    }
}