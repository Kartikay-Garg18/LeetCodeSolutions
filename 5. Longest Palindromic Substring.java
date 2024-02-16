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
            for (int j= i; j<s.length(); j++){
                if (isPalindrome(s, i, j)){
                    if(longestString.length() < s.substring(i, j+1).length()){
                        longestString = s.substring(i, j+1);
                    }
                }
            }
        }
        return longestString;
    }
}
