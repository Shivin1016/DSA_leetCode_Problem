class Solution {
    int componentCnt = 0;
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            adjList.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        DFS(adjList , 0 , -1 , values , k);
        return componentCnt ;
    }

    public long DFS( List<List<Integer>> adjList , int currNode , int parent , int[] values ,int k){
        long sum = 0;

        for(int child : adjList.get(currNode)){
            if(parent != child){
                // go up to leaf Node
                sum += DFS(adjList , child , currNode , values , k);
            }
        }
        //reached to the leaf node then check for sum
        sum += values[currNode];
        if(sum % k == 0){ // sum is divisible by k then add with componentCount and make sum 0 to return it root node , and return sum as it is
            componentCnt++;
            sum = 0;
        }
        return sum;
    }
}