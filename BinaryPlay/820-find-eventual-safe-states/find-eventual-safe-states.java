class Solution {
    public boolean DFSCycle(int[][] graph , int u , boolean[] visited , boolean[] inRecursion){
        visited[u] = true;
        inRecursion[u] = true;

        for(int v : graph[u]){
            if(!visited[v] && DFSCycle(graph , v , visited , inRecursion)){
                return true;
            }else if(inRecursion[v] == true){
                return true;
            }
        }
        //if we can make inRecursion false mtlb we have safeNode so that we can go to terminal node
        inRecursion[u] = false;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;

        boolean[] visited = new boolean[n];
        boolean[] inRecursion = new boolean[n];

        List<Integer> ans = new ArrayList<>();

        for(int i = 0 ; i < n ; i++){
            if(!visited[i]){
                DFSCycle(graph , i , visited , inRecursion);
            }
        }

        for(int i = 0 ; i < n ; i++){
            if(inRecursion[i] == false){
                ans.add(i);
            }
        }
        return ans;
    }
}