class Solution {
    public boolean hasDuplicate(String w1 , String w2){
        int[] mp1 = new int[26];
        for(char ch : w1.toCharArray()){
            mp1[ch - 'a']++;
            if(mp1[ch - 'a'] > 1) return false;
        }

        int[] mp2 = new int[26];
        for(char ch : w2.toCharArray()){
            mp2[ch - 'a']++;
            if(mp2[ch - 'a'] > 1) return false;
        }

        for(int i = 0; i < 26 ; i++){
            if((mp1[i] == 0 && mp2[i] == 0) || (mp1[i] == 0 && mp2[i] != 0) || (mp1[i] != 0 && mp2[i] == 0)) continue;

            return false;
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
        if(!hasDuplicate(arr.get(i) , temp)){
            //only exclude
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