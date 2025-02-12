class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] arr = s.split(" ");
        String[] map = new String[26];
        Map<String, Character> hm = new HashMap<>();
        int n = pattern.length();
        if(n != arr.length) return false;
        int idx = 0;
        for(char ch : pattern.toCharArray()){
            if(map[ch-'a'] == null){

                if(hm.containsKey(arr[idx])) return false;

                hm.put(arr[idx], ch);
                map[ch-'a'] = arr[idx++];
                
            } else{
                if(!map[ch-'a'].equals(arr[idx])){
                    return false;
                } else{
                    idx++;
                }
            }
        }
        return true;
    }
}