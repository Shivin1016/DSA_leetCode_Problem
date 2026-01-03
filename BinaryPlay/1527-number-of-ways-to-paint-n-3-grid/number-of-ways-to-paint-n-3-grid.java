class Solution {
    List<String> rowStates = new ArrayList<>();
    int M = 1000000007;
    int[][] t;
    public void generateRowStats(String currentState , int len , char prevChar){
        if(len == 3){
            rowStates.add(currentState);
            return;
        }

        for(char ch : new char[] {'R' , 'Y' , 'G'}){
            if(ch == prevChar) continue;
            generateRowStats(currentState + ch , len + 1 , ch);
        }
    }

    public int colorToRows(int remainRows , int prevIdx){
        if(remainRows == 0) return 1;

        if(t[remainRows][prevIdx] != -1) return t[remainRows][prevIdx];

        int ways = 0;
        String prevState = rowStates.get(prevIdx);
        for(int i = 0 ; i < rowStates.size() ; i++){
            String currentState = rowStates.get(i);
            if(prevState == currentState) continue;
 
            boolean isValid = true;
            for(int j = 0; j < currentState.length() ; j++){
                if(currentState.charAt(j) == prevState.charAt(j)){
                    isValid = false;
                    break;
                }
            }
            if(isValid){
                ways = (ways + colorToRows(remainRows - 1 , i)) % M;
            }
        }
        return t[remainRows][prevIdx] = ways;
    }

    public int numOfWays(int n) {
        //genrate all the rowStats and further find all ststws
        generateRowStats("" , 0 , '#');

        int totalRowWay = rowStates.size();
        t = new int[n][totalRowWay];
        for(int i = 0 ; i < t.length ; i++){
            Arrays.fill(t[i] , -1);
        }

        int result = 0;

        for(int i = 0 ; i < totalRowWay ; i++){
            result = (result + colorToRows(n - 1 , i)) % M;
        }

        return result;

    }
}