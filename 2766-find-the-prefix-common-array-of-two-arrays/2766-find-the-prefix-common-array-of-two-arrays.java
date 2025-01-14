class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] freq = new int[n+1];
        int[] ans = new int[n];
        freq[A[0]]++;
        freq[B[0]]++;
        if(freq[B[0]] == 2) ans[0]++;

        for(int i=1; i<n; i++){
            freq[A[i]]++;
            if(freq[A[i]] == 2) ans[i]++;
            freq[B[i]]++;
            if(freq[B[i]] == 2) ans[i]++;
            ans[i]+=ans[i-1];
        }

        return ans;
    }
}