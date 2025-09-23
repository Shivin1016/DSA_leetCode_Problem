class Solution {
    int[] parent;
    int[] rank;

    public int find(int i){
        if(i == parent[i]){
            return i;
        }
        return parent[i] = find(parent[i]);
    }

    public void union(int i , int j){
        int parent_i = find(i);
        int parent_j = find(j);

        if(parent_i == parent_j) return ;

        if(rank[parent_i] > rank[parent_j]){
            parent[parent_j] = parent_i;
        }
        else if(rank[parent_i] < rank[parent_j]){
            parent[parent_i] = parent_j;
        }
        else{
            parent[parent_i] = parent_j;
            rank[parent_j]++;
        }
    }

    public boolean isIdentical(String s1 , String s2){
        int cnt = 0;
        for(int i = 0 ; i < s1.length() ; i++){
            if(s1.charAt(i) != s2.charAt(i)){
                cnt++;
            }

            if(cnt > 2) return false;
        }
        return (cnt == 2 || cnt == 0);
    }

    public int numSimilarGroups(String[] strs) {
        int n = strs.length;

        parent = new int[n];
        for(int i = 0 ; i < n ; i++) parent[i] = i;

        rank = new int[n];
        // int grp = n;

        for(int i = 0 ; i < n ; i++){
            for(int j = i + 1; j < n ; j++){
                if(isIdentical(strs[i] , strs[j])){
                    int parent_i = find(i);
                    int parent_j = find(j);

                    if(parent_i != parent_j) {
                        union(i , j); 
                    }
                }
            }
        }
        int grp = 0;
        for(int i = 0 ; i < n ; i++){ 
            // agr jo element khud ka leader hai mtb uska alag hi grp hai
            if(find(i) == i) grp++;
        }
        return grp;
    }
}