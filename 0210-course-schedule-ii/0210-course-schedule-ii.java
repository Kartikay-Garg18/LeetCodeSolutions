class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int pos = 0;
        int[] indegree = new int[numCourses];
        ArrayList<Integer> graph[] = new ArrayList[numCourses];

        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] pre : prerequisites){
            indegree[pre[0]]++;
            graph[pre[1]].add(pre[0]);
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i=0; i<indegree.length; i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }

        int[] ans = new int[numCourses];

        while(!queue.isEmpty()){
            int curr = queue.poll();
            ans[pos++] = curr;
            for(int neigh : graph[curr]){
                indegree[neigh]--;
                if(indegree[neigh] == 0) queue.add(neigh);
            }
        }

        if(pos<numCourses) return new int[0];

        return ans;
    }
}