class Solution { 

    public void dfs(String fromCity , Map<String , PriorityQueue<String>> adj , List<String> path){
        PriorityQueue<String> pq = adj.get(fromCity);
        while(pq != null && !pq.isEmpty()){
            String toCity = pq.poll();
            dfs(toCity , adj , path);
        }
        path.addFirst(fromCity);
    }
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String , PriorityQueue<String>> adj = new HashMap<>(); 

        for(List<String> ticket : tickets){
            String fromCity = ticket.get(0);
            String toCity = ticket.get(1); 
            adj.computeIfAbsent(fromCity , k -> new PriorityQueue<>()).add(toCity);
        } 
        
        List<String> path = new ArrayList<>();
        dfs("JFK" , adj , path);
        return path;
    }
}