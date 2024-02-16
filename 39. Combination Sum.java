class Solution {
    public static void combinationSumHelper(int[] arr, int target, List<Integer> list, List<List<Integer>> listArr, int idx){
        if (target == 0){
            listArr.add( new ArrayList<>(list));
            return;
        }
        for (int i = idx; i < arr.length; i++) {
            list.add(arr[i]);
            if(target>=arr[i]){
                combinationSumHelper(arr, target - arr[i] , list, listArr, i);
            }
            list.remove(list.size()-1);
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> listArr = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        combinationSumHelper(candidates, target, list, listArr, 0);
        return listArr;
    }
}
