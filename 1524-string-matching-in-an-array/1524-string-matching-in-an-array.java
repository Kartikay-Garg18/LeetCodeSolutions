class Solution {
    public List<String> stringMatching(String[] words) {
        Arrays.sort(words, Comparator.comparing(s -> s.length()));
        List<String> ans = new ArrayList<>();
        for(int i=0; i<words.length; i++){
            for(int j=words.length-1; j>i; j--){
                if(words[j].contains(words[i])){
                    ans.add(words[i]);
                    break;
                }
            }
        }
        return ans;
    }
}