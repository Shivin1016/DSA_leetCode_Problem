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

    public void BFSCycle(int[][] graph , boolean[] safeNodes , int n){

        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < n ; i++) adj.add(new ArrayList<>());
        int[] indegree = new int[n];

        for(int u = 0 ; u < n ; u++){ 
            for(int v : graph[u]){
                //reverse the graph 
                adj.get(v).add(u);
                indegree[u]++;
            }
        }

        var que = new LinkedList<Integer>(); 

        for(int i = 0 ; i < n ; i++){
            if(indegree[i] == 0) que.add(i);
        }


        while(!que.isEmpty()){
            int node = que.pop();
            safeNodes[node] = true;
            for(int v : adj.get(node)){
                indegree[v]--;
                if(indegree[v] == 0){
                    que.add(v);
                }
            }
        }
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {

        int n = graph.length;


        List<Integer> ans = new ArrayList<>();

        // Using DFS
        // boolean[] visited = new boolean[n];
        // boolean[] inRecursion = new boolean[n];
        // for(int i = 0 ; i < n ; i++){
        //     if(!visited[i]){
        //         DFSCycle(graph , i , visited , inRecursion);
        //     }
        // }
        // for(int i = 0 ; i < n ; i++){
        //     if(inRecursion[i] == false){
        //         ans.add(i);
        //     }
        // }

        //using BFS
        boolean[] safeNodes = new boolean[n];
        BFSCycle(graph , safeNodes , n);
        for(int i = 0 ; i < n ; i++){
            if(safeNodes[i] == true) {
                ans.add(i);
            }
        }

        return ans;
    }
}