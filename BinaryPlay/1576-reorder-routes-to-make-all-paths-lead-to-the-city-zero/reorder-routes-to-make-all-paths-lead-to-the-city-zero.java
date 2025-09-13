class Solution {
    int flipCount = 0;
    public void dfs(List<List<int[]>> adj , int u , int parent){

        for(int[] nodeInfo : adj.get(u)){

            int v = nodeInfo[0];
            int edge = nodeInfo[1];

            if(v == parent) continue;
            //asli edge == 1 --> if we go far from 0 with asli edge 
            if(edge == 1){
                flipCount++; 
            }
            dfs(adj , v , u );
        }

    }
    public int minReorder(int n, int[][] connections) {
        List<List<int[]>> adj = new ArrayList<>();

        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>()); 
        }

        for(int[] connection : connections){
            int u = connection[0];
            int v = connection[1];

            //stores node and asli and nakli edge
            adj.get(u).add(new int[]{v , 1}); // asli edge as per question 
            adj.get(v).add(new int[]{u , 0}) ; //nkli edge 
        } 
        flipCount = 0;
        dfs(adj , 0 , -1);

        return flipCount;
    }
}