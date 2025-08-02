class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        int n = basket1.length;
        int minEle = Integer.MAX_VALUE;
        //store extra present that to be distributed or swaps
        Map<Integer , Integer> mp = new HashMap<>(); 
        for(int b : basket1){
            mp.put(b , mp.getOrDefault(b , 0) + 1);
            minEle = Math.min(minEle , b);
        }
        //subtract basket 2 elements so that we get extra
        for(int b : basket2){ 
            mp.put(b , mp.getOrDefault(b , 0) - 1);
            minEle = Math.min(minEle , b);
        } 

        //make array to store all extras 
        List<Integer> extras = new ArrayList<>(); 
        for(int key : mp.keySet()){ 
            int frq = Math.abs(mp.get(key));  
            //frq / 2 times element store krna hai 
            if(frq % 2 != 0) return -1 ; // not possible to make equal basket
            frq = frq / 2;
            while(frq > 0){
                extras.add(key);
                frq--;
            }
        } 

        Collections.sort(extras); 
        long minCost = 0;
        //as we have to do swap so take half elements
        for(int i = 0 ; i < extras.size() / 2 ; i++){
            minCost += Math.min(extras.get(i) , minEle * 2);
        }

        return minCost;
    }
}