class Solution {
    public boolean isPalindrome(int x) {
        if (x<0){
            return false;
        }
        int temp = x;
        int a =0;
        while (x>0){
            a = (a*10) + x%10;
            x/=10;
        }
        if (temp == a){
            return true;
        }
        return false;
    }
}
