class Solution {
    private int diff(int[] freq){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int ele : freq){
            if(ele!=0){
                min = Math.min(ele, min);
                max = Math.max(ele, max);
            }
        }
        return max - min;
    }
    public int beautySum(String s) {
        int sum = 0;
        for(int j=0; j<s.length()-2; j++){
            int[] freq = new int[26];
            freq[s.charAt(j) - 'a']++;
            freq[s.charAt(j+1) - 'a']++;
            for(int i=j+2; i<s.length(); i++){
                freq[s.charAt(i) - 'a']++;
                sum+=diff(freq);
            }
        }
        return sum;
    }
}