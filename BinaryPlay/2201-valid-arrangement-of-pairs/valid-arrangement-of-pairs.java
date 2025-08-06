class Solution {
    public int[][] validArrangement(int[][] pairs) {

        //make adjency list
        Map<Integer , List<Integer>> adj = new HashMap<>();

        //make indegree and outdegree array
        Map<Integer , Integer> in_degree = new HashMap<>(); //key ->node , value -> in_degree
        Map<Integer , Integer> out_degree = new HashMap<>(); //key ->node , value -> out_degree

        for(int[] pair : pairs){

            int x = pair[0];
            int y = pair[1];

            if(!adj.containsKey(x)){
                adj.put(x , new ArrayList<>());
            }
            adj.get(x).add(y);
            //x --> y
            in_degree.put(y , in_degree.getOrDefault(y , 0) + 1); 
            out_degree.put(x , out_degree.getOrDefault(x , 0) + 1);
        }

        //find starting point
        int startingNode = pairs[0][0];

        for(Map.Entry<Integer , List<Integer>> entry : adj.entrySet()){ 
            int node = entry.getKey();
            if(out_degree.getOrDefault(node , 0) - in_degree.getOrDefault(node , 0) == 1){
                startingNode = node; 
                break;
            }  
        }

        //now make DFS traversal using stack 
        List<Integer> eularPath = new ArrayList<>();  
        dfs(adj , startingNode , eularPath);

        //now reverse it
        Collections.reverse(eularPath);
        int n = pairs.length;
        int[][] ans = new int[n][2];
        for(int i =0 ; i < eularPath.size() - 1 ; i++){
            ans[i][0] = eularPath.get(i);
            ans[i][1] = eularPath.get(i + 1);
        }

        return ans; 
    }

    public void dfs(Map<Integer , List<Integer>> adj , int startNode , List<Integer> eularPath){
        while(adj.containsKey(startNode) && !adj.get(startNode).isEmpty()){
            int neighbor = adj.get(startNode).remove(0);
            dfs(adj , neighbor , eularPath);
        }
        eularPath.add(startNode);
    }
}