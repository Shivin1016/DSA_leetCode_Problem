class Solution {
    int[][] memo;
    public int longestStrChain(String[] words) {
        //same as LIS type Question
        int n = words.length;
        if(n == 1) return 1;

        //sort on the basis of length
        Arrays.sort(words , (a , b)->Integer.compare(a.length() , b.length()));
        memo = new int[n + 1][n + 1];
        for(int i = 0 ; i <= n ; i++){
            Arrays.fill(memo[i] , -1);
        }

        return solve(words , 0 , -1 , n);

    }

    public int solve(String[] words , int idx , int prev , int n){

        if(idx >= n) return 0;

        if(prev != -1 && memo[idx][prev] != -1) return memo[idx][prev];

        int take = 0;
        if(prev == -1 || isPredecessor(words , idx , prev)){
            //take
            take = 1 + solve(words , idx + 1 , idx , n);
        }

        //skip
        int skip = solve(words , idx + 1 , prev , n);

        if(prev != -1){
            memo[idx][prev] = Math.max(take , skip);
        }
        return Math.max(take , skip);
    }

    public boolean isPredecessor(String[] words , int idx , int prev){

        //for being a predecessor -> ther are two things one there must be a difference of 1 in length and in the new string there must be only 1 extraCharacter
        int m = words[idx].length();
        int n = words[prev].length();

        if(m - n != 1) return false;

        //now check that previous string is subsequnce of next string
        int i = 0 , j = 0 ;
        while(i < n && j < m){
            if(words[prev].charAt(i) == words[idx].charAt(j)){
                i++;
                j++;
            }else{
                j++;
            }
        }
        if(i == n) return true;

        return false;
    }
}