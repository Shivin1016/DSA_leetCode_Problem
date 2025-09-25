class Solution {
    class DSU{
        int[] parent;
        int[] rank;

        public DSU(int n){
            parent = new int[n];
            rank = new int[n];
            for(int i = 0 ; i < n ; i++) parent[i] = i;
        }

        public int find(int x){
            return parent[x] = (parent[x] == x) ? x : find(parent[x]);
        }

        public void union(int x , int y){
            int parent_x = find(x);
            int parent_y = find(y);

            if(parent_x == parent_y) return;

            if(rank[parent_x] > rank[parent_y]){
                parent[parent_y] = parent_x;
            }
            else if(rank[parent_x] < rank[parent_y]){
                parent[parent_x] = parent_y;
            }
            else{
                parent[parent_x] = parent_y;
                rank[parent_y]++;
            }
        }
    }
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        int totalEdge = edges.length;
        Arrays.sort(edges , (a , b) -> b[0] - a[0]);

        DSU dsu_alice = new DSU(n + 1);
        DSU dsu_bob = new DSU(n + 1);

        int edgeCnt = 0;
        int compo1 = n ; //for alice
        int compo2 = n ; //for bob

        for(int[] edge : edges){
            int t = edge[0];
            int u = edge[1];
            int v = edge[2];

            if(t == 3){
                if(dsu_alice.find(u) == dsu_alice.find(v)) continue;
                //type 3 both can traverse
                dsu_alice.union(u , v);
                dsu_bob.union(u , v);
                compo2--;
                compo1--;
            }else if(t == 2){
                if(dsu_bob.find(u) == dsu_bob.find(v)) continue;
                //type 2 only bob can go
                dsu_bob.union(u , v);
                compo2--;
            }else{
                if(dsu_alice.find(u) == dsu_alice.find(v)) continue;
                //type 1 only alice can go
                dsu_alice.union(u , v);
                compo1--;
            }
            edgeCnt++;
        }

        if(compo1 == 1 && compo2 == 1){
            return totalEdge - edgeCnt;
        }
        return -1;
    }
}