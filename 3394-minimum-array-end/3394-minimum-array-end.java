class Solution {
    public long minEnd(int n, int x) {
        if(n==1) return x;
        n--;
        int[] bit = new int[64];
        int idx = 63;
        
        while(n>0){
            int curr = x&1;
            if(curr == 1){
                bit[idx--] = 1;
            } else{
                bit[idx--] = n&1;
                n = n>>1;
            }
            x>>=1;
        }

        while(x>0){
            bit[idx--] = x&1;
            x>>=1;
        }

        long ans = 0;
        for(int i=0; i<64; i++){
            ans = ans*2 + bit[i];
        }
        return ans;
    }
}