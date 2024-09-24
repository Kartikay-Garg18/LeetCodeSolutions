class Solution {
    public int maxFrequency(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int smallest = Integer.MAX_VALUE;
        
        for(int ele : nums){
            if(ele<smallest) smallest = ele;
            map.put(ele, map.getOrDefault(ele, 0)+1);
        }

        int max = 0;

        for(int key : map.keySet()){
            int freq = map.get(key);
            int diff = 1;
            int no = k;
            while(diff<=k && no>=diff && key-smallest>=diff){
                int up = key-diff;
                if(map.containsKey(up)){
                    int frqInc = k/diff;
                    int exsFre = map.get(up);
                    if(exsFre <= frqInc){
                        int shouldOper = exsFre*diff;
                        if(shouldOper<=no){
                            freq+=exsFre;
                            no-=(exsFre*diff);
                        } else{
                            freq+=(no/diff);
                            no-=(no/diff*diff);
                        }
                    } else{
                        freq+=(no/diff);
                        no-=(no/diff*diff);
                    }
                }
                diff++;
            }
            max = Math.max(max, freq);
        }
        return max;
    }
}