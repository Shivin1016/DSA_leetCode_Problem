class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] f : flights) {
            adj.get(f[0]).add(new int[] { f[1], f[2] });
        }

        var pq = new PriorityQueue<int[]>((a, b) -> a[2] - b[2]);
        // boolean[] visited = new boolean[n]; 
        // visited[src] = true;
        pq.offer(new int[] { src, 0, 0 }); // stores node , price , stops

        int minPrice = Integer.MAX_VALUE;
        int[] totalPrice = new int[n];
        Arrays.fill(totalPrice , Integer.MAX_VALUE);
        //the dist(price) from src to src is 0
        totalPrice[src] = 0;


        while (!pq.isEmpty()) {
            int[] info = pq.poll();

            int from = info[0];
            int price = info[1];
            int stops = info[2]; 

            if (stops > k )
                continue; 

            for (int[] collect : adj.get(from)) {
                int to = collect[0];
                int newPrice = price + collect[1]; 
                if(totalPrice[to] > newPrice){
                    totalPrice[to] = newPrice;
                    pq.offer(new int[] { to , newPrice , stops + 1 });
                }
            }
        }

        return totalPrice[dst] == Integer.MAX_VALUE ? -1 : totalPrice[dst];

    }
}