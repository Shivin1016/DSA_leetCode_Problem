class Solution {
    int n;
    public boolean isDuplicate(String st){
        int[] frq = new int[26];
        // System.out.println(st);
        for(char ch : st.toCharArray()){
            frq[ch - 'a']++;
            if(frq[ch - 'a'] > 1) return true; //find duplicates
        }
        return false;
    }
    Map<String , Integer> mp = new HashMap<>();
    public int solve(int i , List<String> arr , String temp){
        if(i >= n){
            return temp.length();
        }
        String key = i + "_" + temp;
        if(mp.containsKey(key)){
            return mp.get(key);
        }

        //include 
        int include = 0 , exclude = 0;
        if(isDuplicate(temp + arr.get(i))){
            //exlude in include path
            include = solve(i + 1 , arr , temp); 
        }else{
            //not duplicate then include
            include = solve(i + 1 , arr , temp + arr.get(i));
        }
        //exclude part 
        exclude = solve(i + 1 , arr , temp); 
        key = i + "_" + temp;
        mp.put(key , Math.max(include , exclude));
        return Math.max(include , exclude);
    }
    public int maxLength(List<String> arr) {
        n = arr.size();

        return solve(0 , arr , "");
    }
}