class Solution {
    class Pair implements Comparable<Pair>{
        int dest;
        double wt;
        public Pair(int dest, double wt){
            this.dest = dest;
            this.wt = wt;
        }

        @Override
        public int compareTo(Pair p2) {
            return Double.compare(p2.wt, this.wt);
        }

    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        ArrayList<Pair> graph[] = new ArrayList[n];

        for(int i=0; i<n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            double wt = succProb[i];
            graph[u].add(new Pair(v, wt));
            graph[v].add(new Pair(u, wt));
        }

        double[] dist = new double[n];
        dist[start_node] = 1d;

        boolean[] vis = new boolean[n];

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        pq.add(new Pair(start_node, 1d));

        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            double wt = curr.wt;
            for(Pair p : graph[curr.dest]){
                if(wt*p.wt > dist[p.dest]){
                    dist[p.dest] = wt*p.wt;
                    pq.add(new Pair(p.dest, dist[p.dest]));
                }
            }
        }

        return dist[end_node];
    }
}