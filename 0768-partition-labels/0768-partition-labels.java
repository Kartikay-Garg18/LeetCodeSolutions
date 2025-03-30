class Solution {
    int[] lastIndex;
    List<Integer> ans;
    private void calculateLastIdx(String s){

        for(int i=0; i<s.length(); i++){
            lastIndex[s.charAt(i) - 'a'] = i;
        }

    }

    private int partition(String s, int idx){
        int start = idx;
        int end = lastIndex[s.charAt(idx)-'a'];
        while(start<=end){
            end = Math.max(end, lastIndex[s.charAt(start)-'a']);
            start++;
        }
        ans.add(end-idx+1);
        return end+1;
    }

    public List<Integer> partitionLabels(String s) {
        lastIndex = new int[26];
        ans = new ArrayList<>();

        calculateLastIdx(s);

        int idx = 0;
        while(idx < s.length()){
            idx = partition(s, idx);
        }

        return ans;
    }
}