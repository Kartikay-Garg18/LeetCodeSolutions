class Solution {
    private void dfs(List<List<Integer>> rooms, int src, boolean[] vis){
        if(vis[src]) return;
        vis[src] = true;
        for(int neigh : rooms.get(src)){
            dfs(rooms, neigh, vis);
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] vis = new boolean[n];
        vis[0] = true;
        
        for(int neigh : rooms.get(0)){
            if(!vis[neigh]) dfs(rooms, neigh, vis);
        }

        for(boolean ele : vis) if(!ele) return ele;
        return true;
    }
}