class Solution {
    public int[][] sortTheStudents(int[][] score, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[k]-a[k]);
        for(int[] ele : score) pq.add(ele);
        for(int i=0; i<score.length; i++){
            score[i] = pq.poll();
        }
        return score;
    }
}