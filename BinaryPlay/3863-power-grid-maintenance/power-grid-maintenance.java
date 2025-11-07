class Solution {
    int[] componentId;
    Map<Integer , TreeSet<Integer>> mp;
    int[] parent;
    int[] rank;
    public int find(int i){
        return i == parent[i] ? i : find(parent[i]);
    }

    public void union(int u , int v){
        int parent_u = find(u);
        int parent_v = find(v);

        if(parent_u == parent_v) return ;

        if(rank[parent_u] > rank[parent_v]){
            parent[parent_v] = parent_u;
        }else if(rank[parent_u] < rank[parent_v]){
            parent[parent_u] = parent_v;
        }else{
            parent[parent_u] = parent_v;
            rank[parent_v]++;
        }
    }
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        parent = new int[c + 1];
        rank = new int[c + 1];

        for(int i = 1 ; i <= c ; i++) parent[i] = i;

        for(int[] edge : connections){
            int u = edge[0];
            int v = edge[1];
            union(u , v);
        }

        boolean[] visited = new boolean[c + 1];
        componentId = new int[c + 1];
        mp = new HashMap<>();
        for(int node = 1 ; node <= c ; node++){
            int par = find(node);
            mp.computeIfAbsent(par , k -> new TreeSet<>()).add(node);
            componentId[node] = par;
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