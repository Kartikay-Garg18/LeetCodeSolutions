class Solution {
    public String sorted(String str){
        char[] ch = str.toCharArray();
        Arrays.sort(ch);
        return new String(ch);
    }

    public List<Integer> findAnagrams(String s, String p) {
        p = sorted(p);
        int lenp = p.length();
        int lens = s.length();
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<=lens-lenp; i++){
            String word = s.substring(i, lenp+i);
            String sort = sorted(word);
            if(p.equals(sort)) list.add(i);
        }
        return list;
    }
}