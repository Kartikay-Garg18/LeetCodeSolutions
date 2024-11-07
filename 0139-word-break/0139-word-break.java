class Solution {
    HashMap<Character, TreeSet<String>> map;

    private int helper(String s, HashMap<Character, TreeSet<String>> map, int idx, int[] dp){
        if(idx >= s.length()) return 1;

        if(dp[idx]!=-1) return dp[idx];

        char ch = s.charAt(idx);

        if(!map.containsKey(ch)) return dp[idx] = 0;

        for(String word : map.get(ch)){
            if(s.substring(idx).startsWith(word)){
                dp[idx] = Math.max(dp[idx], helper(s, map, idx+word.length(), dp));
                if(dp[idx] == 1) return dp[idx];
            }
        }

        return dp[idx] = 0;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        map = new HashMap<>();
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        for(String word : wordDict){
            char ch = word.charAt(0);
            map.computeIfAbsent(ch, k -> new TreeSet<>());
            map.get(ch).add(word);
        }

        return helper(s, map, 0, dp) == 1;
        // return false;
    }
}