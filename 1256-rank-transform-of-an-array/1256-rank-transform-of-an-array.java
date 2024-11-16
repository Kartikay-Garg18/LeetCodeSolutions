class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] copy = Arrays.copyOfRange(arr, 0, arr.length);
        Arrays.sort(copy);
        int rank = 1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int ele : copy) if(!map.containsKey(ele)) map.put(ele, rank++);
        for(int i=0; i<arr.length; i++){
            arr[i] = map.get(arr[i]);
        }
        return arr;
    }
}