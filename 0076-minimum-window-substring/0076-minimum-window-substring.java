class Solution {

    private boolean isPossible(HashMap<Character, Integer> map, HashMap<Character, Integer> freq){
        if(map.size() != freq.size()) return false;

        for(Character key : map.keySet()){
            if(map.get(key) > freq.get(key)){
                return false;
            }
        }

        return true;
    }

    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();

        for(char ch : t.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        List<Integer> indexes = new ArrayList<>();
        int n = s.length();

        for(int i=0; i<n; i++){
            if(map.containsKey(s.charAt(i))){
                indexes.add(i);
            }
        }

        if(indexes.size() < t.length()){
            return "";
        }

        int[] ans = {0, n+2};

        int left = 0;
        int right = 0;
        HashMap<Character, Integer> freq = new HashMap<>();

        boolean matched = false;
        while(right < indexes.size()){
            while(right < indexes.size() && !matched){
                freq.put(s.charAt(indexes.get(right)), freq.getOrDefault(s.charAt(indexes.get(right)), 0)+1);
                matched = isPossible(map, freq);
                right++;
            }

            while(left<=right && matched){
                if((indexes.get(right-1)-indexes.get(left)+1) < (ans[1]-ans[0]+1)){
                    ans[0] = indexes.get(left);
                    ans[1] = indexes.get(right-1);
                }

                freq.put(s.charAt(indexes.get(left)), freq.get(s.charAt(indexes.get(left)))-1);

                if(freq.get(s.charAt(indexes.get(left))) == 0){
                    freq.remove(s.charAt(indexes.get(left)));
                }

                matched = isPossible(map, freq);
                left++;
            }
        }

        return ans[1] == n+2 ? "" : s.substring(ans[0], ans[1]+1);
    }
}