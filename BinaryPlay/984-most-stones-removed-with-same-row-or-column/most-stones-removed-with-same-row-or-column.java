class Solution {
    public boolean isSameGrp(int i , int j , int[][] stones){
        if(stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]){
            return true;
        }
        return false;
    } 
    int[] parent ;
    int[] rank; 
    public int find(int i){
        if(i == parent[i]) return i;

        return parent[i] = find(parent[i]);
    }

    public void union(int i , int j){
        int i_parent = find(i);
        int j_parent = find(j);

        if(i_parent == j_parent) return ;

        if(rank[i_parent] > rank[j_parent]){
            parent[j_parent] = i_parent;
        }
        else if(rank[i_parent] < rank[j_parent]){
            parent[i_parent] = j_parent;
        }
        else{
            parent[i_parent] = j_parent;
            rank[j_parent]++;
        }
    }
    public int removeStones(int[][] stones) {

        int n = stones.length; // number of stones

        //using DSU 
        parent = new int[n];
        for(int i = 0 ; i < n ; i++){
            parent[i] = i;
        }
        rank = new int[n];

        for(int i = 0 ; i < n ; i++){

            for(int j = 0 ; j < n ; j++){

                if(i == j) continue;

                if(isSameGrp(i , j , stones)){
                    int i_parent = find(i);
                    int j_parent = find(j);
                    //not in same group then make group
                    if(i_parent != j_parent){
                        union(i , j);
                    }
                } 
            }
        }

        //find total component
        int components = 0; 
        for(int i = 0 ; i < n ; i++){
            //if parent is same as idx mtlb ye ek component ka boss hai 
            if(find(i) == i) components++;
        }
 
        return  n - components;
    }
}