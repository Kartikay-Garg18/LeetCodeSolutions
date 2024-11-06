class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ans = new int[n];
        for(int[] ele : bookings){
            for(int i=ele[0]-1; i<ele[1]; i++){
                ans[i]+=ele[2];
            }
        }
        return ans;
    }
}