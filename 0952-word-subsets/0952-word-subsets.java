class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] uni = new int[26];
        for(String word : words2){
            int[] temp = new int[26];
            for(char ch : word.toCharArray()){
                temp[ch-'a']++;
                uni[ch-'a'] = Math.max(uni[ch-'a'], temp[ch-'a']);
            }
        }

        List<String> ans = new ArrayList<>();
        for(String word : words1){
            int[] curr = new int[26];
            for(char ch : word.toCharArray()){
                curr[ch-'a']++;
            }

            boolean flag = true;
            for(int i=0; i<26; i++){
                if(uni[i]>curr[i]){
                    flag = false;
                    break;
                }
            }
            if(flag) ans.add(word);
        }

        return ans;
    }
}