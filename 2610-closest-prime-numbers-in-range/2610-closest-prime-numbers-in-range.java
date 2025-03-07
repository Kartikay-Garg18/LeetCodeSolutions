class Solution {
    public int[] closestPrimes(int left, int right) {
        boolean[] prime = new boolean[right+1];

        for(int i=2; i*i<=right; i++){

            if(prime[i]){
                continue;
            }

            for(int j=i*i; j<=right; j+=i){
                prime[j] = true;
            }
        }

        List<Integer> list = new ArrayList<>();
        for(int i=Math.max(2, left); i<=right; i++){
            if(!prime[i]){
                list.add(i);
            }
        }

        if(list.size() < 2){
            return new int[]{-1, -1};
        }

        int[] ans = {list.get(0), list.get(1)};

        for(int i=2; i<list.size(); i++){
            int diff = ans[1] - ans[0];
            int newDiff = list.get(i) - list.get(i-1);
            if(diff > newDiff){
                ans[0] = list.get(i-1);
                ans[1] = list.get(i);
            }
        }

        return ans;

    }
}