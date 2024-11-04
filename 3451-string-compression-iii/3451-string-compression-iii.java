class Solution {
    public String compressedString(String word) {
        StringBuilder sb = new StringBuilder();
        int i=0;
        int n = word.length();
        while(i<n){
            char ch = word.charAt(i);
            int cnt = 0;
            while(i<n && word.charAt(i) == ch){
                cnt++;
                i++;
            }
            int rem = cnt%9;
            cnt/=9;
            for(int j=0; j<cnt; j++){
                sb.append("9").append(ch);
            }
            if(rem!=0){
                sb.append(rem).append(ch);
            }
        }
        return sb.toString();
    }
}