class Solution {
    int[] parent ;
    int[] rank;
    
    public int find(int i){
        if(i == parent[i]) return i;

        return parent[i] = find(parent[i]);
    }

    public void union(int i , int j){
        int parent_i = find(i);
        int parent_j = find(j);

        if(parent_i == parent_j) return ;

        if(rank[parent_i] > rank[parent_j]){
            parent[parent_j] = parent_i;
        }
        else if(rank[parent_j] > rank[parent_i]){
            parent[parent_i] = parent_j;
        }else{
            parent[parent_i] = parent_j;
            rank[parent_j]++; 
        }
    }
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
 
        int m = queries.length;
        int len = edgeList.length;

        Arrays.sort(edgeList , (a , b) -> a[2] - b[2]);

        //before sorting store the idx of each query
        Map<int[] , Integer> mp = new HashMap<>();
        for(int i = 0 ; i < m ; i++){
            mp.put(queries[i] , i);
        }
        Arrays.sort(queries , (a , b) -> a[2] - b[2]);

        parent = new int[n];
        for(int i = 0 ; i < n ; i++) parent[i] = i;

        rank = new int[n];

        boolean[] ans = new boolean[m];
 
        int j = 0 ; // for edges
        for(int i = 0 ; i < m ; i++){
            int[] q = queries[i];
            int u = q[0];
            int v = q[1];
            int limit = q[2];
            int idx = mp.get(q);

             //check till we got distance < limit
            while(j < len && edgeList[j][2] < q[2]){
                int[] e = edgeList[j];
                //make union --> distance < limit
                union(e[0] , e[1]);
                j++;
            }

            //check that if they have same parent then q ans will be true
            int u1 = find(q[0]);
            int u2 = find(q[1]); 
            if(u1 == u2){
                ans[idx] = true;
            }else{
                ans[idx] = false;
            }

        }  

        return ans;


    }
}