class Solution {
    int maxLen = Integer.MIN_VALUE;
    public int longestPath(int[] parent, String s) {

        int n = parent.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < n ; i++) adj.add(new ArrayList<>());
        for(int i = 1 ; i < n ; i++){ 
            int u = i;
            int v = parent[i];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        DFS(adj , 0 , s.toCharArray() , -1);
        return maxLen;
    }
    public int DFS(List<List<Integer>> adj , int node , char[] s , int parent){
        int longest = 0;
        int second_longest = 0;

        for(int v : adj.get(node)){ 

            if(v == parent) continue;

            int child_longest_length = DFS(adj , v , s , node);

            if(s[v] == s[node]){ 
                continue;
            }
            //update longest and 2ndlongest
            if(longest < child_longest_length){
                second_longest = longest;
                longest = child_longest_length;
            }else if(second_longest < child_longest_length){
                second_longest = child_longest_length;
            }
             
        }
        int niche_se_hi_maximum = longest + second_longest + 1;
        int dono_me_se_koi_ek = Math.max(longest , second_longest) + 1;
        int srif_node_hi = 1;
        maxLen = Math.max(maxLen , Math.max(niche_se_hi_maximum , Math.max(dono_me_se_koi_ek , srif_node_hi)));

        return Math.max(dono_me_se_koi_ek , srif_node_hi);
    }
}