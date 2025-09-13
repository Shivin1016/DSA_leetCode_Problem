class Solution {
    
    public int maxFreqSum(String s) {

        int[] frq = new int[26];

        for(char ch : s.toCharArray()){
            frq[ch - 'a']++;
        }

        int frq1 = 0 , frq2 = 0;
        for(int i = 0; i < 26 ; i++){

            if(frq[i] == 0) continue;

            char ch = (char)(i + 'a');

            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                frq1 = Math.max(frq1 , frq[i]);
            }
            else{
                frq2 = Math.max(frq2 , frq[i]);
            }
        }

        return frq1 + frq2;
    }
}