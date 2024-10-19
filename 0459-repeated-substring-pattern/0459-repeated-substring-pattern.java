class Solution {
    public boolean repeatedSubstringPattern(String s) {
        boolean ans = false;
        for(int i=1; i<=s.length()/2 && !ans; i++){
            String pick = s.substring(0, i);
            boolean confirm = true;
            for(int j=i; j<s.length() && confirm; j+=i){
                if(j+i > s.length()){
                    confirm = false;
                    break;
                }
                String check = s.substring(j, j+i);
                if(!check.startsWith(pick)){
                    confirm = false;
                }
            }
            if(confirm) ans = true;
        }
        return ans;
    }
}