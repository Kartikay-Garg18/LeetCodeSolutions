class Solution {
    public List<String> stringSequence(String target) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder("a");
        ans.add("a");
        int i=0;
        int n = target.length();
        while(i<n){
            char ch = sb.charAt(sb.length()-1);
            if(ch == target.charAt(i)){
                i++;
                if(i==n) break;
                sb.append("a");
                ans.add(sb.toString());
                continue;
            }
            ch = ch=='z'?'a':(char)(ch+1);
            sb.setCharAt(sb.length()-1, ch);
            ans.add(sb.toString());
        }
        return ans;
    }
}