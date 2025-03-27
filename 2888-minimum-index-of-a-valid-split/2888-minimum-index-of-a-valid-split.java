class Solution {

    public int minimumIndex(List<Integer> nums) {
        int n = nums.size();
        int dominant = nums.get(0);
        int count = 0;

        for(int num : nums){
            if(count == 0){
                dominant = num;
                count++;
            } else if(num == dominant){
                count++;
            } else{
                count--;
            }
        }

        int rightFrequency = 0;
        for(int num : nums){
            if(num == dominant){
                rightFrequency++;
            }
        }

        int leftFrequency = 0;

        for(int i=0; i<n; i++){
            if(nums.get(i) == dominant){
                leftFrequency++;
                rightFrequency--;
            }

            if(leftFrequency*2>(i+1) && rightFrequency*2>(n-i-1)){
                return i;
            }
        }

        return -1;
    }
}