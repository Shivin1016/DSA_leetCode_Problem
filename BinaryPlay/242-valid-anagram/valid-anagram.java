class Solution {
    public boolean isAnagram(String s, String t) {
        int n = s.length();

        int[] frq = new int[26];

        for(char ch : s.toCharArray()){
            frq[ch - 'a']++;
        }

        for(char ch : t.toCharArray()){ 
            frq[ch - 'a']--; 
        }

        for(int i = 0 ; i < 26 ; i++){
            if(frq[i] != 0) return false;
        }

        return true;

    }
}