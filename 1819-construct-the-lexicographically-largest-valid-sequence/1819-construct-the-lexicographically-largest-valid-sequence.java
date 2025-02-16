class Solution {
    HashSet<Integer> set;
    private boolean helper(int[] ans, int[] help, int n, int idx){

        while(idx<ans.length && help[idx] != 0){
            idx++;
        }

        if(idx == ans.length){
            System.out.println(Arrays.toString(help));
            for(int i=0; i<ans.length; i++){
                ans[i] = help[i];
            }
            return true;
        }

        boolean flag = false;

        for(int i=n; i>=2 && !flag; i--){
            if(set.contains(i)) continue;

            if(idx+i < ans.length && help[idx+i] == 0){
                set.add(i);
                help[idx] = i;
                help[idx+i] = i;
                flag = helper(ans, help, n, idx+1);
                help[idx] = 0;
                help[idx+i] = 0;
                set.remove(i);
            }
        }

        if(!flag){
            if(!set.contains(1)){
                set.add(1);
                help[idx] = 1;
                flag = helper(ans, help, n, idx+1);
                help[idx] = 0;
                set.remove(1);
            }
        }

        return flag;
    }
    public int[] constructDistancedSequence(int n) {
        set = new HashSet<>();
        int[] ans = new int[2*n - 1];
        helper(ans, new int[2*n - 1], n, 0);
        return ans;
    }
}