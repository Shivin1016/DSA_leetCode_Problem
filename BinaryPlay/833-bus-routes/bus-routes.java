class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source == target) return 0;
        int n = routes.length;
        //store {stops , busIdx}
        Map<Integer , List<Integer>> mp = new HashMap<>();
        for(int i = 0 ; i < n ; i++){
            int[] route = routes[i];
            for(int r : route){
                mp.computeIfAbsent(r , k -> new ArrayList<>()).add(i);
            }
        }

        int count = 0;
        var que = new LinkedList<Integer>(); 
        Set<Integer> visited = new HashSet<>();
        for(int route : mp.getOrDefault(source , new ArrayList<>())){
            que.add(route); // add those bus from where we can start
            visited.add(route);
        }

        while(!que.isEmpty()){
            int size = que.size();
            while(size-- > 0){
                int routeIdx = que.poll();
                for(int stop : routes[routeIdx]){
                    if(stop == target) return count + 1; 

                    for(int nextRoute : mp.getOrDefault(stop , new ArrayList<>())){
                        if(!visited.contains(nextRoute)){
                            que.add(nextRoute);
                            visited.add(nextRoute); 
                        }
                    }
                }
            }
            count++;
        }
        return -1;
    }
}