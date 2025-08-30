class Solution {
    int[][] t;
    int n;
    public List<List<String>> partition(String s) {
        n = s.length();

        t = new int[n][n];
        //t[i][j] -> 1(true) => s[i..j] palindrom , 0(false) s[i..j] not palindrom

        //for length 1 it is always palindrom
        for(int i = 0; i < n ; i++){
            t[i][i] = 1;
        }

        //t.c : O(n ^2)
        for(int L = 2 ; L <= n  ; L++){
            for(int i = 0 ; i + L - 1 < n ; i++){
                int j = i + L - 1;
                if(s.charAt(i) == s.charAt(j)){
                    if(i + 1 == j){
                        t[i][j] = 1;
                    }else{
                        t[i][j] = (t[i + 1][j - 1] == 1) ? 1 : 0;
                    }
                } 
            }
        }

        List<List<String>> ans = new ArrayList<>(); 
        List<String> temp = new ArrayList<>();
        //t.c : O(2^n)
        solve(s , 0 , ans , temp);
        return ans;
    }
    public void solve(String s , int i , List<List<String>> ans , List<String> part){
        if(i > n){
            return ;
        }

        if(i == n){
            List<String> temp = new ArrayList<>(part); 
            ans.add(temp);
            return;
        }

        //further explore
        //two option to check every index -> partition or no partition --> O(2 ^ n)
        for(int j = i ; j < n ; j++){
            if(t[i][j] == 1){
                // s[i to j] is plaindrom
                part.add(s.substring(i , j + 1));
                solve(s , j + 1 , ans , part);
                part.remove(part.size() - 1);
            }
        }
    }

}