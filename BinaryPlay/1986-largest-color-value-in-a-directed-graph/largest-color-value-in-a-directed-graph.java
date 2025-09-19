class Solution { 

    public int largestPathValue(String colors, int[][] edges) {

        int n = colors.length();
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
        }  

        int[] indegree = new int[n];
        for(int u = 0 ; u < n ; u++){
            for(int v : adj.get(u)){
                indegree[v]++;
            }
        }

        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        int[][] t = new int[n][26];
        //t[i][charIdx] --> all paths ending at i node , max frq of color char

        for(int i = 0 ; i < n ; i++){
            if(indegree[i] == 0){
                queue.add(i);
                int charIdx = colors.charAt(i) - 'a';
                t[i][charIdx]++;
            }
        }
        int ans = -1;
        while(!queue.isEmpty()){
            int u = queue.poll();
            int charIdx = colors.charAt(u) - 'a';
            ans = Math.max(ans , t[u][charIdx]);
            count++; 

            for(int v : adj.get(u)){
                charIdx = colors.charAt(v) - 'a';
                for(int i = 0 ; i < 26 ; i++){
                    t[v][i] = Math.max(t[v][i] , t[u][i] + (charIdx == i ? 1 : 0));
                }
                indegree[v]--;
                if(indegree[v] == 0){
                    queue.add(v);
                }
            }
        }

        if(count < n) return -1;

        return ans;




  
    }
}