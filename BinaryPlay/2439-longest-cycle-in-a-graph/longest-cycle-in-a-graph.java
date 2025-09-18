class Solution {
    int longCycle = -1;
    public void isCycle(int[] edges , int parent , int u , boolean[] visited , boolean[] inRecursion , int[] seenNodes){
        visited[u] = true;
        inRecursion[u] = true;   

        int v = edges[u];

        if(v != -1){
            if(!visited[v]){
                seenNodes[v] = seenNodes[u] + 1; 
                isCycle(edges , u , v , visited , inRecursion , seenNodes);
            }else if(visited[v] == true && inRecursion[v] == true){
                longCycle = Math.max(longCycle , seenNodes[u] - seenNodes[v] + 1); 
            }
        }
        inRecursion[u] = false;

        return ;
    } 
    public int longestCycle(int[] edges) {
        int n = edges.length;

        boolean[] visited = new boolean[n];
        boolean[] inRecursion = new boolean[n];
        int[] seenNodes = new int[n];
        Arrays.fill(seenNodes , -1); //starting me sare ek seen hoge khud ka

        for(int i = 0 ; i < n ; i++){ 
            if(!visited[i]){
                isCycle(edges , -1 , i , visited , inRecursion , seenNodes);
            }
        }

        return longCycle;
    }
}