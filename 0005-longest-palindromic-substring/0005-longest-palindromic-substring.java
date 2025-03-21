class Solution {
    public static boolean isPalindrome(String s, int i, int j){
        while (i<=j){
            if (s.charAt(i)!=s.charAt(j)){
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }
    public static String longestPalindrome(String s){
        String longestString = "";
        for (int i=0; i<s.length(); i++){
            for (int j= s.length()-1; j>=i; j--){
                if (isPalindrome(s, i, j)){
                    if(longestString.length() < j-i+1){
                        longestString = s.substring(i, j+1);
                    }
                    break;
                }
            }
        }
        return longestString;
    }
}