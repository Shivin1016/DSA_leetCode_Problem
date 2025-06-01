class Solution {
    public int distributeCandies(int n, int limit) {
        //using recursive approach
        
        return solve(0 , n , limit); 
    }

    public int solve(int countOfChild , int n , int limit){
        if(countOfChild == 3){
            if(n == 0){
                //all candies are distributed
                return 1; // get one way to distributed candies among 3 children
            }
            return 0;
        }

        if(countOfChild > 3) return 0;

        int ways = 0;
        //we can assign minimum(n , limit) candies to the children
        for(int assign = 0 ; assign <= Integer.min(n , limit) ; assign++){
            // we can distribute candies from 0 to limit
            ways += solve(countOfChild + 1 , n - assign , limit); 
        }

        return ways;

    }
}