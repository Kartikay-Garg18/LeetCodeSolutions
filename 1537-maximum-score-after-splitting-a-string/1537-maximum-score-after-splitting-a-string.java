class Solution {
    public int maxScore(String s) {
        int ones = 0;

        for(char ch : s.toCharArray()){
            if(ch=='1') ones++;
        }

        int score = 0;
        int zeroes = 0;
        int total = 0;
        for(int i=0; i<s.length()-1; i++){
            char ch = s.charAt(i);
            if(ch=='1') ones--;
            else zeroes++;
            total = zeroes+ones;
            if(score<total) score = total;
        }
        return score>total?score:total;
    }
}