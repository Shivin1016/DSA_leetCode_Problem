class Solution { 

    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<List<double[]>> adj = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>());
        }

        int m = succProb.length;
        for(int i = 0 ; i < edges.length ; i++){
            int u = edges[i][0];
            int v = edges[i][1];

            adj.get(u).add(new double[]{v , i < m ? succProb[i] : 0.0});
            adj.get(v).add(new double[]{u , i < m ? succProb[i] : 0.0});
        }

        double[] res = new double[n];
        var pq = new PriorityQueue<double[]>((a , b) -> Double.compare(b[0] , a[0]));
        pq.offer(new double[]{1.0 , start_node}); //start se start tak jane ki  probability will be maximum == 1
        
        while(!pq.isEmpty()){
            double[] p = pq.poll();
            double dist = p[0];
            int u = (int)p[1];

            if(u == end_node) return res[end_node];

            for(double[] v : adj.get(u)){
                int node = (int)v[0];
                double d = v[1];
                double newDist = d * dist;
                if(res[node] < newDist){
                    res[node] = newDist;
                    pq.add(new double[]{newDist , node});
                }
            } 
        }

        return 0.0;
    }
}