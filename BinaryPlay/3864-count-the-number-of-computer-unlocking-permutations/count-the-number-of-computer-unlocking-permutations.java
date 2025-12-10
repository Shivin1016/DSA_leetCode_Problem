class Solution {
    
    long M = 1000_000_007;
    public int countPermutations(int[] complexity) {
        int n = complexity.length;

        //check that if root computer is equal to any other computer then return 0
        for(int i = 1 ; i < n ; i++){ 
            if(complexity[0] == complexity[i]){
                return 0;
            }
            if(complexity[0] > complexity[i]) return 0;
        }  
        
        long count = factorial(n - 1) % M;
        return (int)count;
    }

    public long factorial(int n){
        if(n == 0 || n == 1) return 1;

        return (factorial(n - 1) * n) % M;
    }
}