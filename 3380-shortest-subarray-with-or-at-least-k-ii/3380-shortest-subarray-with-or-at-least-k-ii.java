class Solution {
    private void increase(int[] bits, int ele){
        int b = 31;
        while(ele>0){
            bits[b--]+=(ele&1);
            ele>>=1;
        }
    }

    private int decrease(int[] bits, int ele){
        int b = 31;
        while(ele>0){
            bits[b--]-=(ele&1);
            ele>>=1;
        }
        int or = 0;
        for(int i=0; i<32; i++){
            if(bits[i] == 0){
                or = or*2;
            } else{
                or = or*2 + 1;
            }
        }

        return or;
    }

    public int minimumSubarrayLength(int[] nums, int k) {
        if(k==0) return 1;
        int[] bits = new int[32];
        int or = 0;
        int i=0;
        int j=0;
        int min = Integer.MAX_VALUE;

        while(j<nums.length){
            or|=nums[j];
            increase(bits, nums[j]);
            while(or>=k && j>=i){
                min = Math.min(min, j-i+1);
                or = decrease(bits, nums[i]);
                i++;
            }
            j++;
        }

        while(or>=k && j>=i){
            min = Math.min(min, j-i+1);
            or = decrease(bits, nums[i]);
            i++;
        }
        return min == Integer.MAX_VALUE?-1:min;
    }
}