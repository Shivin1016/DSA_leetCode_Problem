class Solution {
    List<String> columnStates;
    int M = 1000000007;
    int[][] t;
    public void generateColState(String currState , int l , char prevColor , int m){
        if(l == m){
            //make one string 
            columnStates.add(currState);
            return;
        }

        for(char ch : new char[]{'R' , 'G' , 'B'}){
            if(ch == prevColor){
                continue;
            }
            generateColState(currState + ch , l + 1 , ch , m);
        }
    }
    public int solve(int prevStateIdx , int remainCol , int m){
        if(remainCol == 0){
            //filled all the cols 
            return 1; // found one way
        }

        if(t[prevStateIdx][remainCol] != -1) return t[prevStateIdx][remainCol];

        String prevState = columnStates.get(prevStateIdx);

        int ways = 0;

        for(int i = 0 ; i < columnStates.size() ; i++){
            if(i == prevStateIdx) continue;

            // jo string hongo vo m size ki hongo
            String currState = columnStates.get(i);

            boolean valid = true;

            for(int j = 0 ; j < m ; j++){
                if(currState.charAt(j) == prevState.charAt(j)){
                    valid = false;
                    break;
                }
            }

            if(valid){
                ways = (ways + solve(i , remainCol - 1 , m)) % M;
            }
        }
        return t[prevStateIdx][remainCol] = ways;
    }
    public int colorTheGrid(int m, int n) {

        // step - 1 make columnState
        columnStates = new ArrayList<>();

        // now generate all the possible combo of colors to fill column wise 
        generateColState("" , 0 , '#', m);

        int totalStates = columnStates.size();
        
        // memoization
        t = new int[totalStates][n];
        for(int[] r : t){
            Arrays.fill(r , -1);
        }

        
        // step 2 
        int res = 0 ;
        // try all possibility
        for(int i = 0 ; i < totalStates ; i++){
            res = (res + solve(i , n - 1 , m)) % M;
        }
        return res;

    }
}