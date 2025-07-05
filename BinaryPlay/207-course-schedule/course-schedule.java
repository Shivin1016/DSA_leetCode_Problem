class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        //make adjency List 
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0 ; i < numCourses ; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] pre : prerequisites){
            int u = pre[0];
            int v = pre[1];

            adj.get(v).add(u);
        }

        //to complete all coures , we have to ensure that we don't have to stuck in the cycle
        //if we stuck then we can't do all courses because 1 solve before 0 or other says 0 solve before 1

        // hence this is the problem of -> cycle detection in directed graph

        //using DFS  
        boolean[] visited = new boolean[numCourses];
        boolean[] inRecursion = new boolean[numCourses];

        for(int i = 0 ; i < numCourses ; i++){
            if(visited[i] == false && DFS(adj , i , visited , inRecursion)){
                return false ; // cycle detected
            }
        }

        return true;
    }

    public boolean DFS(List<List<Integer>> adj , int u , boolean[] visited , boolean[] inRecursion){
        visited[u] = true;
        inRecursion[u] = true;

        for(int v : adj.get(u)){
            if(visited[v] == false && DFS(adj , v , visited , inRecursion)){
                return true; //cycle detected
            }else if(inRecursion[v] == true){
                return true; //cycle detected
            }
        }

        inRecursion[u] = false;
        return false;
    }
}