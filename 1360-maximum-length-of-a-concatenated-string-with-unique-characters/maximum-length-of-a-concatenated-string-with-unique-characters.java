class Solution {
    public boolean isUniue(String w1 , String w2){

        int[] mp = new int[26];

        for(char ch : w1.toCharArray()){
            mp[ch - 'a']++;
            //for cases like {"aa" , "bb"}
            if(mp[ch - 'a'] > 1) return false;
        }

        for(char ch : w2.toCharArray()){
            if(mp[ch - 'a'] > 0) return false;
        } 

        return true;

    }
    public int maxLength(List<String> arr) {
        int n = arr.size(); 

        String temp = "";

        return solve(0 , arr , temp , n);
    }

    public int solve(int i , List<String> arr , String temp , int n){
        if(i >= n) return temp.length();

        int skip = 0 , take = 0;
        if(!isUniue(arr.get(i) , temp)){
            //if not uniue then we have only exclude
            skip = solve(i + 1 , arr , temp , n);
        }else{
            //skip
            skip = solve(i + 1 , arr , temp , n);
            //take
            take = solve(i + 1 , arr , temp + arr.get(i) , n);
        }

        return Math.max(skip , take);
    }


}