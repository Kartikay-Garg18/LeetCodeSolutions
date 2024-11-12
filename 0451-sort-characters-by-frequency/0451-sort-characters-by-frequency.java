class Solution {
    public String frequencySort(String s) {
        int[][] freq = new int[256][2];
        for(char ch : s.toCharArray()){
            int idx = ch;
            freq[idx][0] = idx;
            freq[idx][1]++;
        }
        Arrays.sort(freq, (a,b) -> b[1]-a[1]);
        StringBuilder sb = new StringBuilder();
        for(int[] data : freq){
            int times = data[1];
            if(times == 0) break;
            char ch = (char)(data[0]);
            while(times-->0){
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}