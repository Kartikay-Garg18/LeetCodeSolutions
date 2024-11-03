class Solution {
    class Edge{
        int des;
        int time;
        public Edge(int des, int time){
            this.des = des;
            this.time = time;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer, List<Edge>> graph = new HashMap<>();
        k--;
        for(int[] ele : times){
            int src = ele[0]-1;
            int des = ele[1]-1;
            int wt = ele[2];
            graph.computeIfAbsent(src, a -> new ArrayList<>());
            graph.get(src).add(new Edge(des, wt));
        }

        if(!graph.containsKey(k)) return -1;

        int[] dis = new int[n];
        Arrays.fill(dis, (int)1e9);
        dis[k] = 0;
        Queue<Edge> queue = new LinkedList<>();
        queue.add(new Edge(k, 0));
        while(!queue.isEmpty()){
            Edge curr = queue.poll();
            int src = curr.des;
            int time = curr.time;
            if(!graph.containsKey(src)) continue;
            for(Edge neigh : graph.get(src)){
                int ngbr = neigh.des;
                int req = neigh.time;
                if(dis[ngbr] > time+req){
                    dis[ngbr] = time+req;
                    queue.add(new Edge(ngbr, dis[ngbr]));
                }
            }
        }
        int max = 0;
        for(int ele : dis) max = Math.max(ele, max);
        return max == 1e9 ? -1 : max;
    }
}