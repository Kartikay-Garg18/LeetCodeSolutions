class Solution {
    private int first(String s, int k, int[] freq, int n){
        int i=0;
        int j=0;
        int ans = Integer.MAX_VALUE;
        int[] c = new int[3];
        while(j<2*n){
            while(j<2*n && (c[0]<k || c[1]<k || c[2]<k)){
                c[s.charAt(j%n) - 'a']++;
                j++;
            }

            while(i<2*n && c[s.charAt(i%n) - 'a']>k){
                c[s.charAt(i%n) - 'a']--;
                i++;
            }

            if(c[0] >= k && c[1] >= k && c[2] >= k){
                if(j<n-1){
                    ans = Math.min(ans, (j%n));
                } else if(j==n-1){
                    ans = Math.min(ans, n-(i%n));
                } else{
                    ans = Math.min(ans, n-(i%n) + (j%n));
                }
            }
            c[s.charAt(i%n) - 'a']--;
            i++;
        }
        return ans;
    }

    public int takeCharacters(String s, int k) {
        if(k==0) return 0;
        
        int n = s.length();

        if(3*k > n) return -1;

        int[] freq = new int[3];

        for(char ch : s.toCharArray()) freq[ch-'a']++;

        if(freq[0] <k || freq[1] < k || freq[2] < k) return -1;

        return first(s, k, freq, n);
    }
}