class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] pre = new int[n+1];
        for(int i=1; i<=n; i++){
            char fir = words[i-1].charAt(0);
            char sec = words[i-1].charAt(words[i-1].length()-1);
            if((fir == 'a' || fir == 'e' || fir == 'o' || fir == 'i' || fir == 'u')&(sec == 'a' || sec == 'e' || sec=='i' || sec == 'o' || sec == 'u')){
                pre[i] = pre[i-1] + 1;
            } else{
                pre[i] = pre[i-1];
            }
        }
        int q = queries.length;
        int[] ans = new int[q];
        for(int i=0; i<q; i++){
            int[] query = queries[i];
            ans[i] = pre[query[1]+1] - pre[query[0]];
        }
        return ans;
    }
}