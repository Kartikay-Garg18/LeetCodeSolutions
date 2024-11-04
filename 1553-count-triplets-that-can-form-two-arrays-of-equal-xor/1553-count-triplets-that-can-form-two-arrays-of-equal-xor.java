class Solution {
    public int countTriplets(int[] arr) {
        int n = arr.length;
        int cnt = 0;
        for(int i=0; i<n; i++){
            int prefix = 0;
            for(int j=i; j<n; j++){
                prefix^=arr[j];
                int nxt = 0;
                for(int k=j+1; k<n; k++){
                    nxt^=arr[k];
                    if(nxt == prefix) cnt++;
                }
            }
        }
        return cnt;
    }
}