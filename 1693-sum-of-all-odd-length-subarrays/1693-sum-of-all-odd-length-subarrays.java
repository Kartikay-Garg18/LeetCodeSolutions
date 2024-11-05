class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length;
        int[] prefix = new int[n];
        prefix[0] = arr[0];
        for(int i=1; i<n; i++){
            prefix[i] = prefix[i-1] + arr[i];
        }
        int sum = 0;
        for(int i=0; i<n; i+=2){
            for(int j=i;j<n; j++){
                sum+=(prefix[j] - (j-i-1<0?0:prefix[j-i-1]));
            }
        }
        return sum;
    }
}