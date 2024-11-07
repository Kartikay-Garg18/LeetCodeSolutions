class Solution {
    public int largestCombination(int[] candidates) {

        int[] map = new int[32];
        for(int ele : candidates){
            int bit = 0;
            while(ele>0){
                int set = ele&1;
                if(set==1){
                    map[bit]++;
                }
                ele>>=1;
                bit++;
            }
        }

        int max = 1;
        for(int ele : map){
            if(ele>max) max = ele;
        }
        return max;
    }
}