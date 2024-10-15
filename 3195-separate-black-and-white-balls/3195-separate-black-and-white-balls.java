class Solution {
    public long minimumSteps(String s) {
        char arr[] = s.toCharArray();
        Arrays.sort(arr);
        int n = arr.length;
        int i=n-1;
        int j=n-1;
        long swap = 0;
        while(i>=0){
            while(i>=0 && s.charAt(i)!='1'){
                i--;
            }
            if(i>=0){
                swap+=(j-i);
            }
            j--;
            i--;
        }
        return swap;
    }
}