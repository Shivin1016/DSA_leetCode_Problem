class Solution {
    public int maxDifference(String s) {
        // odd frquency must be maximum 
        //even frequency must be minimum

        int oddFrq = 0;
        int evenFrq = Integer.MAX_VALUE;

        int[] mp = new int[26];

        for(char ch : s.toCharArray()){
            mp[ch - 'a']++;
        }

        for(int frq : mp){ 
            
            if(frq == 0) continue; // this character is not present in the string hence skip this frq

            if(frq % 2 != 0){
                oddFrq = Math.max(oddFrq , frq);
            }else{
                //for even frq
                evenFrq = Math.min(evenFrq , frq);
            }
        }

        return oddFrq - evenFrq;


    }
}