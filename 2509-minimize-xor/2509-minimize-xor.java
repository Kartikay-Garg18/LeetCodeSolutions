class Solution {
    public int minimizeXor(int num1, int num2) {
        int[] arr = new int[64];
        int bit = 0;
        while(num2 > 0){
            bit+=(num2&1);
            num2>>=1;
        }

        int idx = 63;
        while(num1>0){
            arr[idx--] = num1&1;
            num1>>=1;
        }
        
        for(int i=idx+1; i<64; i++){
            if(arr[i] == 1){
                if(bit>0){
                    bit--;
                } else{
                    arr[i] = 0;
                }
            }
        }

        idx = 63;
        while(bit>0 && idx>=0){
            if(arr[idx] == 0){
                arr[idx] = 1;
                bit--;
            }
            idx--;
        }

        int ans = 0;
        for(int ele : arr){
            ans = (ans<<1) + ele;
        }

        return ans;

    }
}