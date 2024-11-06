class Solution {
    public int countPalindromicSubsequence(String s) {
        HashSet<String> set = new HashSet<>();

        for(char ch = 'a'; ch<='z'; ch++){
            int first = s.indexOf(ch);
            int last = s.lastIndexOf(ch);
            if(last-first>=2){
                first++;
                while(first<last){
                    set.add(""+ch+s.charAt(first)+ch);
                    first++;
                }
            }
        }

        return set.size();
    }
}