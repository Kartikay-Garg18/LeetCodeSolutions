class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int n1 = str1.length();
        int n2 = str2.length();
        if(n2 > n1) return false;
        int idx1 = 0;
        int idx2 = 0;
        while(idx1<n1 && idx2<n2){
            if(str1.charAt(idx1) == str2.charAt(idx2)){
                idx1++;
                idx2++;
                continue;
            }
            if(str1.charAt(idx1)=='z' && str2.charAt(idx2)=='a'){
                idx1++;
                idx2++;
                continue;
            }
            if(str1.charAt(idx1)+1 == str2.charAt(idx2)){
                idx2++;
            }
            idx1++;
        }
        return idx2==n2;
    }
}