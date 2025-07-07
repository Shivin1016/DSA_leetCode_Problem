class Solution {
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

        List<Integer> temp = new ArrayList<>();
        Queue<Integer> que = new LinkedList<>();

        for(int i = 0 ; i < numCourses ; i++){
            if(inDegree[i] == 0) que.offer(i);
        }

        while(!que.isEmpty()){
            int u = que.poll();
            temp.add(u);

            for(int v : adj.get(u)){
                inDegree[v]--;
                if(inDegree[v] == 0){
                    que.offer(v);
                }
            }
        }

        if(temp.size() != numCourses){
            //cycle found not all courses finish
            return new int[0];
        }
        int[] ans = new int[temp.size()];
        int i = 0 ;
        for(int u : temp){
            ans[i++] = u; 
        }

        return ans;
    }

}