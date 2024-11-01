class Solution {
    public String makeFancyString(String s) {
        int i=0;
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        while(i<n){
            char ch = s.charAt(i);
            int cnt = 0;
            while(i<n && s.charAt(i) == ch){
                cnt++;
                i++;
            }
            sb.append(ch);
            if(cnt>=2){
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}