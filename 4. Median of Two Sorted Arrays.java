class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        ArrayList<Integer> a = new ArrayList<>();
        for(int i: nums1){
            a.add(i);
        }
        for (int i: nums2){
            a.add(i);
        }
        Collections.sort(a);
        if (a.size()%2 != 0){
            return a.get(a.size()/2);
        } else {
            return (a.get(a.size()/2) + a.get((a.size()-1)/2))/2.00;
        }
    }
}
