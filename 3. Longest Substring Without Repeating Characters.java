class Solution {
    public static int lengthOfLongestSubstring(String s){
        int[] lastOccurrence = new int[128];
        int start = 0; 
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            start = Math.max(start, lastOccurrence[currentChar]);
            maxLength = Math.max(maxLength, i - start + 1);
            lastOccurrence[currentChar] = i + 1;
        }

        return maxLength;
    }
}
