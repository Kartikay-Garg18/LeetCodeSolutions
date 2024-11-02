class Solution {
    public boolean canArrange(int[] arr, int k) {
        int[] rem = new int[k];
        for(int ele : arr){
            int r = ele%k;
            if(r<0) r = k+r;
            rem[r]++;
        }

        if(rem[0]%2!=0) return false;

        for(int i=1; i<=k/2; i++){
            if(rem[i]!=rem[k-i]) return false;
        }
        
        return true;
    }
}