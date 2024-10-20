class Solution {
    public boolean minK(int[] freq, int k){
        for(int ele : freq){
            if(ele>=k) return true;
        }
        return false;
    }
    public int numberOfSubstrings(String s, int k) {
        int n = s.length();
        int cnt = 0;
        for(int i=0; i<n; i++){
            int[] frequency = new int[26];
            for(int j=i; j<n; j++){
                char ch = s.charAt(j);
                frequency[ch-'a']++;
                if(minK(frequency, k)) cnt++;
            }
        }

        return cnt;
    }
}