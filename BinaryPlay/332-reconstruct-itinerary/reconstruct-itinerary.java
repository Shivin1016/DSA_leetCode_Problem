class Solution {
    List<String> ans = new ArrayList<>();

    public void DFS(Map<String , PriorityQueue<String>> adj , String u){
        PriorityQueue<String> pq = adj.get(u);
         
        while(pq != null && !pq.isEmpty()){
            //remove particular v  
            String v = pq.poll();
            DFS(adj , v);
        } 
        
        ans.add(u);
    }
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String , PriorityQueue<String>> adj = new HashMap<>();

        int n = tickets.size();
        for(int i = 0 ; i < n ; i++){
            List<String> ticket = tickets.get(i); 
            String from = ticket.get(0);
            String to = ticket.get(1);
            adj.computeIfAbsent(from , k -> new PriorityQueue<>()).add(to) ;

        }
 
        DFS(adj , "JFK");
        Collections.reverse(ans);
        return ans;
    }
}