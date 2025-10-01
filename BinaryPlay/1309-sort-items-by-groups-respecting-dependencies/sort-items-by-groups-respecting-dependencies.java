class Solution {
    public List<Integer> topo(List<List<Integer>> adj , int[] indegree ){
        List<Integer> order = new ArrayList<>();
        var que = new LinkedList<Integer>(); 
        for(int i = 0 ; i < indegree.length ; i++){
            if(indegree[i] == 0){
                que.add(i);
            }
        }

        while(!que.isEmpty()){
            int node = que.pop();
            order.add(node);

            for(int v : adj.get(node)){
                indegree[v]--;
                if(indegree[v] == 0){
                    que.add(v); 
                }
            }
        }

        return order.size() == adj.size() ? order : new ArrayList<>();
    } 
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {

        // those who are not in any grp assign in further grp
        for(int i = 0 ; i < n ; i++){
            if(group[i] == -1){
                group[i] = m++;
            }
        }

        // adj for item
        List<List<Integer>> itemAdj = new ArrayList<>();
        int[] indegree1 = new int[n];
        for(int i = 0 ; i < n ; i++){
            itemAdj.add(new ArrayList<>());
        }

        //mak grp graph 
        List<List<Integer>> grpAdj =new ArrayList<>();
        int[] indegree2 = new int[m];
        for(int i = 0 ; i < m ; i++){
            grpAdj.add(new ArrayList<>());
        } 

        for(int i = 0 ; i < n ; i++){ 
            for(int prev : beforeItems.get(i)){
                itemAdj.get(prev).add(i);
                indegree1[i]++;

                if(group[i] != group[prev]){
                    int prevItemGrp = group[prev];
                    int currItemGrp = group[i];

                    grpAdj.get(prevItemGrp).add(currItemGrp);
                    indegree2[currItemGrp]++;
                }
            }
        }

        List<Integer> itemOrder = topo(itemAdj , indegree1 ); 
 

        List<Integer> grpOrder = topo(grpAdj , indegree2 );
 

        Map<Integer , List<Integer>> mp = new HashMap<>(); 

        for(int item : itemOrder){
            int grp = group[item]; 
            mp.computeIfAbsent(grp, k -> new ArrayList<>()).add(item);
        }
        List<Integer> ans = new ArrayList<>();
        for(int grpIndex : grpOrder){
            ans.addAll(mp.getOrDefault(grpIndex , new ArrayList<>()));
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();

    }
}