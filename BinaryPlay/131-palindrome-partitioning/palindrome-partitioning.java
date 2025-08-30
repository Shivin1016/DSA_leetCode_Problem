class Solution { 
    int n;
    public List<List<String>> partition(String s) {
        n = s.length(); 

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
        //two option to check every index -> partition or no partition --> O(n * (2 ^ n))
        for(int j = i ; j < n ; j++){
            if(isPalindrom(s.toCharArray() , i , j)){
                // s[i to j] is plaindrom
                part.add(s.substring(i , j + 1));
                solve(s , j + 1 , ans , part);
                part.remove(part.size() - 1);
            }
        }
    }
    public boolean isPalindrom(char[] s , int i , int j){
        while(i < j){
            if(s[i] != s[j]){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

}