class Solution {
    private boolean isSorted(int[] arr, int idx){
        for(int i=idx+1; i<arr.length; i++){
            if(arr[i]<arr[i-1]) return false;
        }
        return true;
    }
    
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        if(n==1) return 0;
        int i=0;
        int j=n-1;
        int ans = Integer.MAX_VALUE;

        while(i<n){
            int nums = arr[i];
            if(i>0 && nums<arr[i-1]){
                if(isSorted(arr, i)) return Math.min(i, ans);
                int k=n-2;
                while(k>=0 && arr[k]<=arr[k+1]){
                    k--;
                }
                return Math.min(ans, k+1);
            }

            while(j>=i && arr[j]>=nums){
                if(j<n-1 && arr[j]>arr[j+1]){
                    j++;
                    break;
                }
                if(j==n-1 && nums>arr[j]){
                    j++;
                    break;
                }
                j--;
            }

            if(j<i){
                return Math.min(ans, i);
            }

            while(j<n && arr[j]<nums) j++;

            ans = Math.min(ans, j-i-1);
            i++;
            if(j==n) j--;

        }

        return ans;
    }
}