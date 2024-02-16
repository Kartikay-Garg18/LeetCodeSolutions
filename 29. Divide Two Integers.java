class Solution {
    public int divide(int dividend, int divisor) {
        long divd = dividend;
        long divi = divisor;
        long num = divd/divi;
        if (num>= Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        } else if(num<= Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        } else{
            return dividend/divisor;
        }
    }
}
