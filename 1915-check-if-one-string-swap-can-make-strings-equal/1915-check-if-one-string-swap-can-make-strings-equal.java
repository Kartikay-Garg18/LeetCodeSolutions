class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if(s1.equals(s2)) return true;
        char ch = '-';
        char s = '-';
        boolean flag = false;
        int n = s1.length();
        for(int i=0; i<n; i++){
            char first = s1.charAt(i);
            char second = s2.charAt(i);
            if(first != second){
                if(ch == '-'){
                    ch=first;
                    s=second;
                } else{
                    if(ch == second && !flag && s==first){
                        flag = true;
                    } else{
                        return false;
                    }
                }
            }
        }
        return flag;
    }
}