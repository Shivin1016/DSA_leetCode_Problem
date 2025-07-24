class Solution {
    int[] outTime;
    int[] inTime;
    int[] xorSubtree;
    int timer;
    private void xorDfs(int[] nums , int u , int parent , List<List<Integer>> adj){
        xorSubtree[u] ^= nums[u];
        inTime[u] = timer; 
        timer++;
        for(int v : adj.get(u)){ 
            if(v != parent){
                xorDfs(nums , v , u , adj);
                xorSubtree[u] ^= xorSubtree[v]; 
            }
        }
        outTime[u] = timer;
        timer++;
    }
    private boolean isAncestor(int u , int v){
        return (inTime[v] >= inTime[u] && outTime[v] <= outTime[u]);
    }
    private int getScore(int xor1 , int xor2 , int xor3){
        int maxXor = Math.max(xor1 , Math.max(xor2 , xor3));
        int minXor = Math.min(xor1 , Math.min(xor2 , xor3));
        int xor = maxXor - minXor;
        return xor;
    }
    public int minimumScore(int[] nums, int[][] edges) {
        //this question consists of three story points
        /*
        1-> to delete two edges --> take two pair of nodes --> means exploring all possiblities
        2-> find XOR for all subtrees
        3-> check that u is ancestor of v or v is dsendant of u
        */

        int n = nums.length;
        //make adjency list
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge :edges){
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        //find XOR for all subtrees
        xorSubtree = new int[n];
        //to calculate ancestor
        inTime = new int[n];
        outTime = new int[n];
        timer = 0;
        xorDfs(nums , 0 , -1 , adj); // -1 for parent ,starting node is 0

        int maxScore = Integer.MAX_VALUE;
        for(int u = 1 ; u < n ; u++){
            for(int v = u + 1 ; v < n ; v++){
                int xor1;
                int xor2;
                int xor3;
                //check that u is ancestor of v or v is an ancestor of u
                if(isAncestor(u , v)){ 
                    xor1 = xorSubtree[v];
                    xor2 = xorSubtree[u] ^ xorSubtree[v]; // we have to remove xor of v from u subtree becuse it is not part of that
                    xor3 = xorSubtree[0] ^ xor1 ^ xor2; //thrid subtree xor    
                }else if(isAncestor(v , u)){
                    xor1 = xorSubtree[u];
                    xor2 = xorSubtree[v] ^ xorSubtree[u];
                    xor3 = xorSubtree[0] ^ xor1 ^ xor2;
                }else{
                    //not ancestor
                    xor1 = xorSubtree[u];
                    xor2 = xorSubtree[v];
                    xor3 = xorSubtree[0] ^ xor1 ^ xor2;
                }
                maxScore = Math.min(maxScore , getScore(xor1 , xor2 , xor3));
            }
        }

        return maxScore;
    }
}