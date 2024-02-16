class Solution {
    public int reverse(int x) {
        long a = 0;
        while (x != 0){
            if ((((a*10) + x%10)<=Math.pow(-2, 31)) || (((a*10) + x%10)>=(Math.pow(2, 31))-1))
                return 0;
            a = (a*10) + x%10;
            x/=10;
        }
        return (int)a;
    }
}
