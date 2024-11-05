class Solution {
    public int countTriplets(int[] arr) {
        int n = arr.length;
        int cnt = 0;
        int[] prefix = new int[n+1];
        System.arraycopy(arr, 0, prefix, 1, n);

        for(int i = 1; i<=n; i++) prefix[i] ^= prefix[i-1];

        // for(int i=0; i<=n; i++){
        //     for(int j = i+1; j<=n; j++){
        //         if(prefix[i] == prefix[j]){
        //             cnt+=(j-i-1);
        //         }
        //     }
        // }

        HashMap<Integer, Integer> countMap = new HashMap<>();
        HashMap<Integer, Integer> totalSum = new HashMap<>();
        countMap.put(0, 0);
        totalSum.put(0, 0);
        for(int i=0; i<=n; i++){
            int xor = prefix[i];
            if(countMap.containsKey(xor)){
                cnt += (countMap.get(xor) * (i-1) - totalSum.get(xor));
            }
            countMap.put(xor, countMap.getOrDefault(xor, 0)+1);
            totalSum.put(xor, totalSum.getOrDefault(xor, 0)+i);
        }

        return cnt;
    }
}