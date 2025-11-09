class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>());
        }
        
        //indegree
        int[] indgree = new int[n];
        for(int[] r : relations){
            int u = r[0];
            int v = r[1];

            adj.get(u - 1).add(v - 1);
            indgree[v - 1]++;
        }

        var que = new LinkedList<Integer>();
        int[] maxTime = new int[n];
        //push those node who have zero index
        for(int i = 0 ; i < n ; i++){
            if(indgree[i] == 0){
                que.offer(i);
                maxTime[i] = time[i];
            }
        } 
        while(!que.isEmpty()){ 
            int course = que.pop(); 
            for(int nextCourse : adj.get(course)){
                indgree[nextCourse]--;
                if(indgree[nextCourse] == 0){
                    que.offer(nextCourse);
                }
                //time to complete nextCourse if course is completed
                int bestTime = maxTime[course] + time[nextCourse];
                maxTime[nextCourse] = Math.max(maxTime[nextCourse] , bestTime);
            }  
        }
        int totalTime = 0;
        for(int month : maxTime) totalTime = Math.max(totalTime , month);
        return totalTime;
    }
}