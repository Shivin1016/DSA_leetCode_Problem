class Solution {
    public int minCostConnectPoints(int[][] points) { 
        int n = points.length;

        //adjency List --> converting points into node
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0 ; i < n ; i++){
            for(int j = i + 1 ; j < n ; j++){
                int dist = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                adj.get(i).add(new int[]{j , dist});
                adj.get(j).add(new int[]{i , dist});
            }
        }

        var pq = new PriorityQueue<int[]>((a , b) -> a[0] - b[0]); 
        pq.add(new int[]{0 , 0}); // store dist , node(0) 

        boolean[] inMST = new boolean[n]; //stores nodes those are taken 
        int minWt = 0;

        while(!pq.isEmpty()){ 
            int[] p = pq.poll();
            int wt = p[0];
            int node = p[1]; 

            if(inMST[node]) continue; //if inMST then skip

            //else take
            inMST[node] = true;
            minWt += wt;

            for(int[] v : adj.get(node)){   
                int neighbor = v[0];
                int dist = v[1];
                if(!inMST[neighbor]){ 
                    pq.add(new int[]{dist , neighbor});
                }
            }
        }
        return minWt;
    }
}