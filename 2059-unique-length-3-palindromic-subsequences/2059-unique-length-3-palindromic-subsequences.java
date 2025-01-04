class Solution {
    public int countPalindromicSubsequence(String s) {
        
        int cnt = 0;
        for(char ch = 'a'; ch<='z'; ch++){
            int first = s.indexOf(ch);
            int last = s.lastIndexOf(ch);
            if(last-first>=2){
                HashSet<Character> set = new HashSet<>();
                first++;
                while(first<last){
                    set.add(s.charAt(first));
                    first++;
                }
                cnt+=set.size();
            }
        }

        return cnt;
    }
}