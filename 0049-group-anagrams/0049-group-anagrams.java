class Solution {

    public String sorted(String word){
        int[] freq = new int[26];
        StringBuilder sb = new StringBuilder("");
        for(char ch : word.toCharArray()){
            freq[ch-'a']++;
        }
        for(int ele : freq){
            sb.append(ele);
            sb.append("-");
        }
        return sb.substring(0, sb.length()-1);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for(String word : strs){
            String sort = sorted(word);
            if(map.containsKey(sort)){
                map.get(sort).add(word);
            }else{
                List<String> list = new ArrayList<>();
                list.add(word);
                map.put(sort, list);
            }
        }

        for(String sorted : map.keySet()){ 
            ans.add(map.get(sorted));
        }

        return ans;
    }
}