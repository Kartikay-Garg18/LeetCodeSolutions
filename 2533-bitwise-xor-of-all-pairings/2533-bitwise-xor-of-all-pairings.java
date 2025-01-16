class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n1%2 == 0 && n2%2 == 0) return 0;

        int xor1 = 0;
        for(int ele : nums1) xor1^=ele;
        
        int xor2 = 0;
        for(int ele : nums2) xor2^=ele;

        if(n1%2 !=0 && n2%2!=0) return xor1^xor2;

        if(n1%2 == 0) return xor1;

        return xor2;
    }
}