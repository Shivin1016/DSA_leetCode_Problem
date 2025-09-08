class Solution {
    int[] parent;
    public int find(int u){
        if(u == parent[u]) return u;

        return parent[u] = find(parent[u]);
    }

    public void union(int u , int v){
        int parent_u = find(u);

        int parent_v = find(v);

        if(parent_u == parent_v) return;

        if(parent_u < parent_v){
            parent[parent_v] = parent_u; // jo chota hai vo papa ji banega
        }else if(parent_u > parent_v){
            parent[parent_u] = parent_v;
        }
    }
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int m = s1.length(); 
        int n = baseStr.length();

        parent = new int[26];
        for(int i = 0 ; i < 26 ; i++) parent[i] = i;

        for(int i = 0 ; i < m ; i++){
            if(s1.charAt(i) != s2.charAt(i)){
                union(s1.charAt(i) - 'a' , s2.charAt(i) - 'a');
            }
        }

        char[] ans = new char[n];
        for(int i = 0 ; i < n ; i++){
            int papaJi = find(baseStr.charAt(i) - 'a');
            System.out.println(papaJi);
            ans[i] = (char)(papaJi + 'a');
        }

        return new String(ans);
    }
}