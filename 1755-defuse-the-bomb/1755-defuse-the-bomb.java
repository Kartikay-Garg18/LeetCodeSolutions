class Solution {
    private int[] pos(int[] code, int k, int[] pre, int n){
        int l = 0;
        int r = 1;
        int sum = 0;
        while(r<=k){
            sum+=code[r];
            r++;
        }
        while(l<n){
            pre[l] = sum;
            sum+=code[r%n];
            l++;
            sum-=code[l%n];
            r++;
        }
        return pre;
    }

    private int[] neg(int[] code, int k, int[] pre, int n){
        int l = 0;
        int r = n-1;
        k = -k;
        int sum = 0;
        while(k-->0){
            sum+=code[r--];
        }
        r++;
        while(l<n){
            pre[l] = sum;
            sum-=code[r%n];
            sum+=code[l];
            l++;
            r++;
        }
        return pre;
    }

    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        if(k==0) return new int[n];
        int[] pre = new int[n];
        k%=n;
        if(k>0) return pos(code, k, pre, n);
        return neg(code, k, pre, n);
    }
}