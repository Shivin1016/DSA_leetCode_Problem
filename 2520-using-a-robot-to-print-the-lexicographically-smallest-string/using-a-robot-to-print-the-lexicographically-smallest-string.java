class Solution {
    public String robotWithString(String s) {

        int n = s.length();

        //find minCHarTOright using preprocessing to right
        char[] minCharToRight = new char[n];

        char minChar = s.charAt(n - 1);
        minCharToRight[n - 1] = s.charAt(n - 1);
        for(int i = n - 2 ; i >= 0 ; i--){
            minCharToRight[i] = (char)(Math.min(s.charAt(i) , minCharToRight[i + 1]));
        }

        //traverse through s
        StringBuilder t = new StringBuilder(); // t store reverse of the s String

        StringBuilder paper = new StringBuilder(); // robot write on the paper if it found that there is no such character lower then me in right hand side  

        int j = 0;
        while(j < n){
            t.append(s.charAt(j));

            char miniChar = (j + 1 < n) ? minCharToRight[j + 1] : s.charAt(j);

            int k = t.length() - 1;
            while(k >= 0 && t.charAt(k) <= miniChar){
                paper.append(t.charAt(k));
                t.deleteCharAt(k);
                k--;
            }

            j++;
        }
        //write remaining character on paper from t
        int i = t.length() - 1;
        while(i >= 0){
            paper.append(t.charAt(i));
            t.deleteCharAt(i);
            i--;
        }


        return paper.toString(); 


    }
}