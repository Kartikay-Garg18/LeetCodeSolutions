class Solution {
    public int[] minOperations(String boxes) {
        int[] ans = new int[boxes.length()];
        for(int i=0; i<ans.length; i++){
            int sum = 0;
            for(int j=0; j<ans.length; j++){
                if(boxes.charAt(j)=='1'){
                    sum+=Math.abs(i-j);
                }
            }
            ans[i] = sum;
        }
        return ans;
    }
}