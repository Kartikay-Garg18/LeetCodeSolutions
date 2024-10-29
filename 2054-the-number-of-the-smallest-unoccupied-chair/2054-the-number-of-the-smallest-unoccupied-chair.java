class Solution {
    class Pair{
        int d;
        int c;
        public Pair(int d, int c){
            this.d = d;
            this.c = c;
        }
    }

    public int smallestChair(int[][] times, int targetFriend) {
        int n = times.length;
        PriorityQueue<Pair> dep = new PriorityQueue<>((a,b) -> a.d-b.d);
        PriorityQueue<Integer> empty = new PriorityQueue<>();
        int[][] data = new int[n][3];
        for(int i=0; i<n; i++){
            data[i][0] = i;
            data[i][1] = times[i][0];
            data[i][2] = times[i][1];
        }
        Arrays.sort(data, (a,b) -> a[1] - b[1]);
        int chair = 0;
        for(int[] friend : data){
            while(!dep.isEmpty() && friend[1]>=dep.peek().d){
                empty.add(dep.poll().c);
            }
            if(friend[0] == targetFriend){
                return empty.isEmpty()?chair:empty.poll();
            }
            if(empty.isEmpty()){
                dep.add(new Pair(friend[2], chair));
                chair++;
            } else{
                dep.add(new Pair(friend[2], empty.poll()));
            }
        }
        return n;
    }
}