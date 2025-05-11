class Solution {
    public int minDeletion(String s, int k) {
        int n = s.length();
        int[] mp = new int[26];

        for(char ch : s.toCharArray()){
            mp[ch - 'a']++;
        } 

        int op = 0;
        Arrays.sort(mp);
        
        int size = 0;
        for(int i = 0; i < 26 ; i++){
            if(mp[i] != 0) size++;
        } 
        
        for(int i = 0 ; i < 26 ; i++){
            if(mp[i] == 0) continue;

            if(size > k){
                op += mp[i];
                size--;
            }
                 
        } 

        
         
        return op;
    }
}