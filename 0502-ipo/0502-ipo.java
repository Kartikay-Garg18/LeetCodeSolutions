class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> b[1] - a[1]);
        for(int i=0; i<profits.length; i++){
            pq.add(new int[]{capital[i], profits[i]});
        }
        for(int i=0; i<k; i++){
            List<int[]> list = new ArrayList<>();
            while(!pq.isEmpty() && pq.peek()[0]>w){
                list.add(pq.poll());
            }
            if(pq.isEmpty()) return w;
            w+=pq.poll()[1];
            for(int[] arr : list) pq.add(arr);
        }
        return w;
    }
}