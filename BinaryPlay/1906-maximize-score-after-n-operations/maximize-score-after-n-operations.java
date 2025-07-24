class Solution {
    int n ;
    Map<String , Integer> mp;
    public int maxScore(int[] nums) {
        n = nums.length;

        //using recursion and memoization
        mp = new HashMap<>();
        boolean[] visited = new boolean[n]; //to choose those value which not take for particular iteration on fixing value
        return solve(nums , visited , 1); //1 --> is for operation count

    }

    public int solve(int[] nums , boolean[] visited , int opCount){
        //same state occurs again then don't solve it
        String s = Arrays.toString(visited);
        if(mp.containsKey(s)){
            return mp.get(s);
        }

        int maxScore = 0;

        for(int i = 0 ; i < n - 1 ; i++){ //fix i
            if(visited[i] == true) continue; //already takeen

            for(int j = i + 1 ; j < n ; j++){

                if(visited[j] == true) continue; //already visited

                //not visited then take it and make it visited
                visited[i] = true;
                visited[j] = true;

                //find score
                int currScore = opCount * gcd(nums[i] , nums[j]);

                //call recusrion for further
                int remainScore = solve(nums , visited , opCount + 1);
                
                //update maxScore
                maxScore = Math.max(maxScore, currScore + remainScore); 

                //backtrack for further case
                visited[i] = false;
                visited[j] = false;  
                 
            }
        }
        s = Arrays.toString(visited);
        mp.put(s , maxScore);
        return maxScore;
    }

    public int gcd(int a , int b){
        if(b == 0) return a;

        return gcd(b , Math.abs(a - b));
    }
}