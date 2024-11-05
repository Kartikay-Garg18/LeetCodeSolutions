class Solution {
    public int numberOfPoints(List<List<Integer>> nums) {
        boolean[] vis = new boolean[101];
        
        for(List<Integer> ele : nums){
            Arrays.fill(vis, ele.get(0), ele.get(1)+1, true);
        }

        int cnt = 0;
        for(boolean flag : vis) if(flag) cnt++;
        return cnt;
    }
}