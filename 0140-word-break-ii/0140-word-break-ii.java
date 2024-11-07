class Solution {
    HashMap<Character, TreeSet<String>> map;

    private int helper(String s, int idx, int[] dp){
        if(idx >= s.length()) return 1;

        if(dp[idx]!=-1) return dp[idx];

        char ch = s.charAt(idx);

        if(!map.containsKey(ch)) return dp[idx] = 0;

        for(String word : map.get(ch)){
            if(s.substring(idx).startsWith(word)){
                dp[idx] = Math.max(dp[idx], helper(s, idx+word.length(), dp));
            }
        }

        return dp[idx] = dp[idx] == 1? 1 : 0;
    }

    private void formAns(String s, int[] dp, int idx, String a, List<String> ans){
        if(idx == s.length()){
            ans.add(a.trim());
            return;
        }

        char ch = s.charAt(idx);
        for(String word : map.get(ch)){
            int len = word.length();
            if(idx+len>s.length()) continue;
            if(idx+len==s.length() || dp[idx+len] == 1){
                formAns(s, dp, idx+len, a+" "+word, ans);
            }
        }
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        map = new HashMap<>();
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        for(String word : wordDict){
            char ch = word.charAt(0);
            map.computeIfAbsent(ch, k -> new TreeSet<>());
            map.get(ch).add(word);
        }

        boolean flag = helper(s, 0, dp) == 0;

        List<String> ans = new ArrayList<>();
        
        if(flag) return ans;

        formAns(s, dp, 0, "", ans);

        return ans;
    }
}