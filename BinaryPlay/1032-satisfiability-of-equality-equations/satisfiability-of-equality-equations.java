class Solution {
    int[] parent;
    int[] rank;
    public boolean equationsPossible(String[] equations) { 

        int n = equations.length;

        //it is Question of DSU --> as they belong to smae grp if they equal
        parent = new int[26];
        rank = new int[26];

        for(int i = 0 ; i < 26 ; i++){
            parent[i] = i;
        }

        //first do union of equal chars
        for(String st : equations){

            int u = st.charAt(0) - 'a';
            int v = st.charAt(3) - 'a';

            //case of a == b --> simply union
            if(st.charAt(1) == '='){  
                union(u , v);
            }    
        }

        //find != wale cases and check validity
        for(String st : equations){

            int u = st.charAt(0) - 'a';
            int v = st.charAt(3) - 'a';

            //case of a == b --> simply union
            if(st.charAt(1) == '!'){  
                int parent_u = find(u);
                int parent_v = find(v);
                //not satisfy inequality
                if(parent_u == parent_v){
                    return false;
                }
            }    
        }

        return true;

    }

    public void union(int u , int v){
        int parent_u = find(u);
        int parent_v = find(v);

        if(parent_u == parent_v) return;

        if(rank[parent_u] > rank[parent_v]){
            parent[parent_v] = parent_u;
        }
        else if(rank[parent_u] < rank[parent_v]){
            parent[parent_u] = parent_v;
        }
        else{
            parent[parent_u] = parent_v;
            rank[parent_v] += 1;
        }
    }

    public int find(int u){
        if(parent[u] == u){
            return u;
        }

        return parent[u] = find(parent[u]);
    }
}