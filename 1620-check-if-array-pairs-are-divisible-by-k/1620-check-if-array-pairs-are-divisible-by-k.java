class Solution {
    public boolean canArrange(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : arr){
            int r = num%k;
            if(r == 0){
                if(map.containsKey(r)) map.remove(r);
                else map.put(r,1);
            } else{
                int n = k-Math.abs(r);
                n = num>0?n:-n;
                r = -r;
                if(map.containsKey(-r)){
                    map.put(-r, map.get(-r)-1);
                    map.put(-n, map.get(-n)-1);
                    if(map.get(-r) == 0) map.remove(-r);
                    if(map.get(-n) == 0) map.remove(-n);
                }else{
                    map.put(r, map.getOrDefault(r, 0)+1);
                    map.put(n, map.getOrDefault(n, 0)+1);
                }
            }
        }
        return map.isEmpty();
    }
}