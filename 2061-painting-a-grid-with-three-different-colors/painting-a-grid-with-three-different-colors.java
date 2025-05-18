class Solution {
    List<String> colomnStates = new ArrayList<>();
    int M = 1000000007;
    int[][] t;
    public int colorTheGrid(int m, int n) {
        //step 01-->generate ColumnStates
        genrateColStates("" , m , '#' , 0);

        //if we don't memoize then time limit exceeded out
        int totalStates = colomnStates.size();
        t = new int[n][totalStates];
        for(int i = 0 ; i < n ; i++){
            Arrays.fill(t[i] , -1);
        }

        //step02--> try all possiblites on columnStates
        int result = 0;
        for(int i = 0 ; i < colomnStates.size() ; i++){
            result = (result + colorToCol(n - 1 , i)) % M;
        }

        return result;
    }

    public void genrateColStates(String currentState , int m , char prevColor , int len){
        if(len == m){
            colomnStates.add(currentState); 
            return;
        }

        for(char ch : new char[] {'R' , 'G' ,'B'}){
            if(ch == prevColor){
                continue;
            }
            genrateColStates(currentState + ch , m , ch , len + 1);
        }
    }
    //solve possibilites 
    public int colorToCol(int remainingCols , int prevIdx){
        if(remainingCols == 0){
            return 1; // we found one way to solve
        }
        if(t[remainingCols][prevIdx] != -1) return t[remainingCols][prevIdx];

        String prevState = colomnStates.get(prevIdx);

        int ways = 0;

        for(int i = 0 ; i < colomnStates.size() ; i++){

            String currentState = colomnStates.get(i);

            if(currentState == prevState){
                continue;
            }
            boolean isValid = true;
            for(int j = 0 ; j < currentState.length() ; j++){
                if(currentState.charAt(j) == prevState.charAt(j)){
                    isValid = false;
                    break;
                }
            }
            if(isValid){
                ways = (ways + colorToCol(remainingCols - 1 , i)) % M;
            }
        }
        return t[remainingCols][prevIdx] = ways;

    }
}