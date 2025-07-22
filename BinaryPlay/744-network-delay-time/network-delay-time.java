class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();

        for(int i = 0 ; i <= n ;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] time : times){

            int u = time[0];
            int v = time[1];
            int w = time[2];

            adj.get(u).add(new int[]{v , w});
        }

        var pq = new PriorityQueue<int[]>((a,b) -> a[0] - b[0]);

        int[] res = new int[n + 1];
        Arrays.fill(res , Integer.MAX_VALUE);
        res[k] = 0;
        pq.add(new int[]{0 , k}); // a[0] - dist , a[1] -> node

        while(!pq.isEmpty()){
            int[] p = pq.poll();
            int dist = p[0];
            int node = p[1];

            for(int[] v : adj.get(node)){
                int d = v[1];
                int neighNode = v[0];

                int mini = d + dist;
                if(mini < res[neighNode]){
                    res[neighNode] = mini;
                    pq.add(new int[]{mini , neighNode});
                }
            }
        }

        int maxVal = Integer.MIN_VALUE;
        for(int i = 1 ; i <= n ; i++){
            if(res[i] == Integer.MAX_VALUE){
                return -1; // we cant reach to this node
            }
            maxVal = Math.max(res[i] , maxVal);
        }
        return maxVal;
    }
}