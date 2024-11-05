class Solution {
    public int numberOfPoints(List<List<Integer>> nums) {
        boolean[] vis = new boolean[101];
        for(List<Integer> ele : nums){
            for(int i = ele.get(0); i<=ele.get(1); i++){
                vis[i] = true;
            }
        }
        int cnt = 0;
        for(boolean flag : vis) if(flag) cnt++;
        return cnt;
    }
}