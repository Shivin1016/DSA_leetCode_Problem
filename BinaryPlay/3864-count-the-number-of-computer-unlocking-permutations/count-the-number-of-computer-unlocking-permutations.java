class Solution {
    long M = 1000_000_007;
    public int countPermutations(int[] complexity) {
        int n = complexity.length;
        long count = 1; // permutations

        //check that if root computer is equal to any other computer then return 0
        for(int i = 1 ; i < n ; i++){ 
            if(complexity[0] >= complexity[i]){
                return 0;  
            } 
            count = (count * i) % M;
        }   

        return (int)count;
    } 
}