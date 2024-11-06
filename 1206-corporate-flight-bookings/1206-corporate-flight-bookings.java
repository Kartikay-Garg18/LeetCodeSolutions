class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ans = new int[n];
        for(int[] ele : bookings){
            ans[ele[0]-1]+=ele[2];
            if(ele[1]<n) ans[ele[1]]-=ele[2];
        }
        for(int i=1; i<n; i++) ans[i]+=ans[i-1];
        return ans;
    }
}