class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        List<Character> list = new ArrayList<>();

        for(Character ch : map.keySet()){
            if(map.get(ch) == 1){
                list.add(ch);
            }
        }

        for(int i=0; i<s.length(); i++){
            if(list.contains(s.charAt(i))) return i;
        }
        return -1;
    }
}