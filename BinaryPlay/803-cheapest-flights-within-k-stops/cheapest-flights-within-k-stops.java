class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] f : flights) {
            adj.get(f[0]).add(new int[] { f[1], f[2] });
        }

        var pq = new LinkedList<int[]>();  
        pq.offer(new int[] { src , 0 }); // stores node , price ,

        int[] minPrice = new int[n];
        Arrays.fill(minPrice , Integer.MAX_VALUE);  
        minPrice[src] = 0;
        int steps = 0;

        while (!pq.isEmpty() && steps <= k) { 

            int size = pq.size();

            while(size-- > 0){
                int[] info = pq.pop();
                int from = info[0];
                int price = info[1]; 

                for(int[] v : adj.get(from)){
                    int to = v[0];
                    int newPrice = price + v[1];
                    if(newPrice < minPrice[to]){
                        minPrice[to] = newPrice;
                        pq.offer(new int[]{to , newPrice});
                    }
                }
            }  
            steps++;

             
        }

        return minPrice[dst] == Integer.MAX_VALUE ? -1 : minPrice[dst];

    }
}