class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int pos = -1;
        int curr = 0;
        int total = 0;
        int n = gas.length;
        for(int i=0; i<n; i++){
            int diff = gas[i] - cost[i];
            curr+=diff;
            total+=diff;
            if(curr<0){
                curr = 0;
                pos = i;
            }
        }
        if(total>=0) return pos+1;
        return -1;
    }
}