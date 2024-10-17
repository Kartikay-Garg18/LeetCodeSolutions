class Solution {
    class Pair{
        int freq;
        int swap;
        public Pair(int freq, int swap){
            this.freq = freq;
            this.swap = swap;
        }
    }

    public void makeNull(Pair[] arr, int idx){
        if(arr[idx].freq-1 == 0){
            arr[idx] = null;
        } else{
            arr[idx].freq = arr[idx].freq-1;
        }
    }

    public int maximumSwap(int num) {
        if(num<10) return num;

        Pair[] arr = new Pair[10];
        int length = (int)(Math.log10(num));
        int temp = num;
        int len = 0;
        while(temp>0){
            int rem = temp%10;
            if(arr[rem] == null){
                arr[rem] = new Pair(1, -1);
            } else{
                arr[rem].freq++;
            }
            temp/=10;
            len++;
        }
        temp = num;
        boolean swap = true;
        int ans = 0;
        while(temp>0){
            int n = temp/(int)(Math.pow(10, len-1));
            temp%=(int)(Math.pow(10, len-1));
            len--;
            for(int i=9; i>=0; i--){
                if(arr[i] != null){
                    if(i!=n && swap){
                        ans = ans*10 + i;
                        arr[i].swap = n;
                        makeNull(arr, n);
                        swap = false;
                        break;
                    } else{
                        if(arr[i].freq > 1){
                            ans = ans*10 + n;
                            makeNull(arr, n);
                            break;
                        } else{
                            if(i==n && arr[i].swap != -1){
                                ans = ans*10 + arr[i].swap;
                                makeNull(arr, n);
                                break;
                            } else{
                                ans = ans*10 + n;
                                makeNull(arr, n);
                                break;
                            }
                        }
                    }
                }
            }
        }
        return ans*(int)(Math.pow(10, len));
    }
}