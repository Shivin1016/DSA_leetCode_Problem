class Solution {
    public long minCuttingCost(int n, int m, int k) {
        if(n <= k && m <= k){
            return 0; // no need to cut logs
        }
        long cost = 1;
        // cut n
        if(n > k){
            while(n > 0){ 
                if(n > k){
                    cost *= k;
                }else{
                    cost *= n;
                    break;
                } 
                n -= k;
            } 
        }
        

        //cut m 
        if(m > k){
            while(m > 0){
             
                if(m > k){
                    cost *= k;
                }else{
                    cost *= m;
                    break;
                }
                m-= k;
            } 
        }
        

        return cost;
        
    }
}