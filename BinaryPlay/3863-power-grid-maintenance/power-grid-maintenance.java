class Solution {
    int[] componentId;
    Map<Integer , TreeSet<Integer>> mp;
    public void DFS(int node , List<List<Integer>> adj , boolean[] visited , int comp_id){
        visited[node] = true;
        mp.computeIfAbsent(comp_id , k -> new TreeSet<>()).add(node);
        componentId[node] = comp_id;
        for(int ngbr : adj.get(node)){
            if(!visited[ngbr]){
                DFS(ngbr , adj , visited , comp_id);
            }
        }
    }
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i <= c ; i++){
            adj.add(new ArrayList<>());
        } 

        for(int[] connection : connections){
            int u = connection[0];
            int v = connection[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[c + 1];
        componentId = new int[c + 1];
        mp = new HashMap<>();
        for(int node = 1 ; node <= c ; node++){
            if(!visited[node]){
                int component_id = node;
                DFS(node , adj , visited , component_id);
            }
        }
        List<Integer> result = new ArrayList<>();
        for(int[] q : queries){
            int operation = q[0];
            int station = q[1];
            int id = componentId[station]; 

            if(operation == 1){
                TreeSet<Integer> st = mp.get(id);
                if(st != null && st.contains(station)){
                    result.add(station);
                }else if(st != null && !st.isEmpty()){
                    result.add(st.first());
                }else{
                    result.add(-1);
                }
            }else{
                TreeSet<Integer> st = mp.get(id);
                if(st != null){
                    st.remove(station);
                }
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}