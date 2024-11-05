class Solution {
    public int countTriplets(int[] arr) {
        int n = arr.length;
        int cnt = 0;
        int[] prefix = new int[n+1];
        System.arraycopy(arr, 0, prefix, 1, n);

        for(int i = 1; i<=n; i++) prefix[i] ^= prefix[i-1];

        for(int i=0; i<=n; i++){
            for(int j = i+1; j<=n; j++){
                if(prefix[i] == prefix[j]){
                    cnt+=(j-i-1);
                }
            }
        }
        
        return cnt;
    }
}