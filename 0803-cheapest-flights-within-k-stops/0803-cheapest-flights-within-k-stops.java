class Solution {
    class Edge{
        int dest;
        int price;
        public Edge(int dest, int price){
            this.dest = dest;
            this.price = price;
        }
    }

    class Pair{
        int dest;
        int price;
        int stops;
        public Pair(int dest, int price, int stops){
            this.dest = dest;
            this.price = price;
            this.stops = stops;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<Edge>[] graph = new ArrayList[n];

        for(int i=0; i<n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] ele : flights){
            graph[ele[0]].add(new Edge(ele[1], ele[2]));
        }

        Queue<Pair> pq = new LinkedList<>();

        pq.add(new Pair(src, 0, 0));

        int[] dis = new int[n];

        Arrays.fill(dis, Integer.MAX_VALUE);

        dis[src] = 0;

        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            if(curr.stops>k) break;
            for(Edge neigh : graph[curr.dest]){
                if(neigh.dest == dst){
                    if(dis[curr.dest]+neigh.price < dis[neigh.dest] && curr.stops<=k){
                        dis[neigh.dest] = dis[curr.dest] + neigh.price;
                    }
                }
                else{
                    if(curr.price+neigh.price < dis[neigh.dest] && curr.stops+1<=k){
                        dis[neigh.dest] = curr.price + neigh.price;
                        pq.add(new Pair(neigh.dest, dis[neigh.dest], curr.stops+1));
                    }

                }
            }
        }

        return dis[dst] == Integer.MAX_VALUE ? -1 : dis[dst];
    }
}