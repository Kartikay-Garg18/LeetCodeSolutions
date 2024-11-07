class Solution {
    public int largestCombination(int[] candidates) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int ele : candidates){
            int bit = 1;
            while(ele>0){
                int set = ele&1;
                if(set==1){
                    map.put(bit, map.getOrDefault(bit, 0)+1);
                }
                ele>>=1;
                bit++;
            }
        }
        int max = 1;
        for(int ele : map.values()){
            if(ele>max) max = ele;
        }
        return max;
    }
}