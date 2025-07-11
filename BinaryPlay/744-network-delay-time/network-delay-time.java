class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        //draw adj list
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0 ; i <= n ; i++){
            adj.add(new ArrayList<>());
        } 

        for(int[] time : times){

            int u = time[0];
            int v = time[1];
            int w = time[2];

            //directed graph given
            adj.get(u).add(new int[]{v , w});
        }

        int[] res = new int[n + 1];
        Arrays.fill(res , Integer.MAX_VALUE);

        var pq = new PriorityQueue<int[]>((a, b)-> a[0] - b[0]);

        res[k] = 0;
        pq.add(new int[]{0 , k});

        while(!pq.isEmpty()){
            int time = pq.peek()[0];
            int node = pq.poll()[1];

            for(int[] v : adj.get(node)){
                int t = v[1];
                int neighNode = v[0];
                int miniTime = t + time;

                if(miniTime < res[neighNode]){
                    res[neighNode] = miniTime;
                    pq.offer(new int[]{miniTime , neighNode});
                }
            }
        }

        int miniTime = -1; 
        for(int i = 1 ; i <= n ; i++){
            miniTime = Math.max(miniTime , res[i]);
        }

        //if we found maxInteger value --> it means we can't reach to all nodes
        if(miniTime == Integer.MAX_VALUE){
            return -1;
        }

        return miniTime;
    }
}