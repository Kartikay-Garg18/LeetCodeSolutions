class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int sum = 0;
        int j = piles.length-2;
        int i=0;
        while(j>i){
            sum+=piles[j];
            j-=2;
            i++;
        }
        return sum;
    }
}