class Solution {
    char ch = 'a';
    public String formString(int n, int k){
        if(n==1) return "0";
        String prefix = formString(n-1, k);
        if(ch=='0' || ch=='1') return prefix;
        if(k<=prefix.length()){
            ch = prefix.charAt(k-1);
            return prefix;
        }
        StringBuilder sb = new StringBuilder(prefix);
        sb = sb.reverse();
        for(int i=0; i<sb.length(); i++){
            if(sb.charAt(i) == '0'){
                sb.setCharAt(i, '1');
            } else{
                sb.setCharAt(i, '0');
            }
        }
        String ans = prefix+'1'+sb.toString();
        if(k<=ans.length()){
            ch = ans.charAt(k-1);
            return ans;
        }
        return ans;
    }
    public char findKthBit(int n, int k) {
        if(k==1) return '0';
        formString(n, k);
        return ch;
    }
}