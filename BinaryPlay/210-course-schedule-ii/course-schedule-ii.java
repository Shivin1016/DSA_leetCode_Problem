class Solution {
    boolean hasCycle = false;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] inDegree = new int[numCourses];

        for(int i = 0 ; i < numCourses ; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0 ; i < prerequisites.length ; i++){
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];

            //v --> u
            adj.get(v).add(u);

            //for inDegree arrow jis pr ja raha hai
            inDegree[u]++;
        }


        //Using BFS
        // List<Integer> temp = new ArrayList<>();
        // Queue<Integer> que = new LinkedList<>();

        // for(int i = 0 ; i < numCourses ; i++){
        //     if(inDegree[i] == 0) que.offer(i);
        // }

        // while(!que.isEmpty()){
        //     int u = que.poll();
        //     temp.add(u);

        //     for(int v : adj.get(u)){
        //         inDegree[v]--;
        //         if(inDegree[v] == 0){
        //             que.offer(v);
        //         }
        //     }
        // }

        // if(temp.size() != numCourses){
        //     return new int[0];
        // }
        // int[] ans = new int[temp.size()];
        // int i = 0;
        // for(int u : temp){
        //     ans[i++] = u;
        // }
        // return ans;

        //using DFS --> firstly check cycle then write topological sort if not cycle
        boolean[] visited = new boolean[numCourses];
        boolean[] inRecursion = new boolean[numCourses];
        Stack<Integer> st = new Stack<>();

        for(int i = 0 ; i < numCourses ; i++){
            if(!visited[i]){
                DFS(adj , i , visited , st, inRecursion);
            }
        }

        if(hasCycle == true) return new int[0];
        
        int[] ans = new int[st.size()];
        int i = 0 ;    
        while(!st.isEmpty()){
            ans[i++] = st.peek();
            st.pop();
        }

        return ans;

    }

    public void DFS(List<List<Integer>> adj , int u , boolean[] visited , Stack<Integer> st , boolean[] inRecursion){
       
        visited[u] = true;
        inRecursion[u] = true;

        for(int v : adj.get(u)){

            if(inRecursion[v] == true){
                hasCycle = true;
                return;
            }

            if(!visited[v]){
                DFS(adj , v , visited , st , inRecursion);
            }

        }

        st.push(u);
        inRecursion[u] = false; 
    } 

}