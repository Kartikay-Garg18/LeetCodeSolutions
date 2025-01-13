class Solution {
    public int minimumLength(String s) {
        int len = s.length();
        if(len<=2) return len;
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        int count = 0;
        for(char key : map.keySet()){
            if(map.get(key)%2==0){
                count+=2;
            } else{
                count+=1;
            }
        }
        return count;
    }
}