class Solution {
    public String largestPalindromic(String num) {
        int[] freq = new int[10];
        for(char ch : num.toCharArray()){
            freq[ch-'0']++;
        }
        int first = -1;
        StringBuilder pre = new StringBuilder();
        StringBuilder suf = new StringBuilder();
        for(int i=9; i>=0; i--){
            if(freq[i] == 0) continue;
            int insert = freq[i]/2;
            int rem = freq[i]%2;
            if(rem!=0 && first==-1){
                first = i;
            }
            for(int j=0; j<insert; j++){
                pre.append(i);
                suf.insert(0, i);
            }
        }
        int i=0;
        while(i<pre.length() && pre.charAt(i) == '0'){
            i++;
        }
        if(first!=-1) pre.append(first);
        if(pre.substring(i).isEmpty()) return "0";
        return pre.substring(i)+suf.substring(0, suf.length()-i);
    }
}