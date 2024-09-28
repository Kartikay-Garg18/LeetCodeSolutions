class Solution {
    public long maximumTotalSum(int[] maximumHeight) {
        Arrays.sort(maximumHeight);
        HashSet<Integer> unique = new HashSet<>();
        int len = maximumHeight.length;
        int max = maximumHeight[len-1];
        unique.add(max);
        int thres = max;
        long sum = max;
        boolean flag;
        for(int i=len-2; i>=0; i--){
            int ele = maximumHeight[i];
            // if(thres<=ele) thres = ele;
            // flag = false;
            // while(ele>0){
            //     if(!unique.contains(ele)){
            //         flag = true;
            //         unique.add(ele);
            //         thres = ele-1;
            //         sum+=ele;
            //         break;
            //     } else{
            //         ele--;
            //     }
            // }
            // if(!flag) return -1;
            if(unique.contains(ele)){
                thres--;
                sum+=thres;
                unique.add(thres);
            } else{
                sum+=ele;
                thres = ele;
                unique.add(thres);
            }
            if(thres<=0) return -1;
        }
        return sum;
    }
}