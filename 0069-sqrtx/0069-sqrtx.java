class Solution {
    public int mySqrt(int x) {
        if(x==0){
            return 0;
        }
        if(x==1){
            return 1;
        }

        long st = 0;
        long end = x/2;
        
        while(st<=end){
            long mid = st + (end-st)/2;
            long sq = mid*mid;
            if(sq==x){
                return (int)mid;
            } else if(sq>x){
                end = mid-1;
            } else{
                st = mid + 1;
            }
        }
        return (int)st-1;
    }
}