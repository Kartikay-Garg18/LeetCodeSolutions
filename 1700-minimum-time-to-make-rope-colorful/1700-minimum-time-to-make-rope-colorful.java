class Solution {
    public int minCost(String colors, int[] time) {
        int i=0;
        int n = colors.length();
        int total = 0;
        while(i<n){
            char ch = colors.charAt(i);
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            while(i<n && ch==colors.charAt(i)){
                pq.add(time[i]);
                i++;
            }
            while(pq.size()>1){
                total+=pq.poll();
            }
        }
        return total;
    }
}