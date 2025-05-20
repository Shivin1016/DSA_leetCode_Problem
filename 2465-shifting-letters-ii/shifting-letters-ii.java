class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        
        int n = s.length();
        int m = shifts.length;

        int[] diff = new int[n];

        for(int[] shift : shifts){

            int start = shift[0];
            int end = shift[1];
            int val = (shift[2] == 0) ? -1 : 1;

            diff[start] += val;

            if(end + 1 < n){
                diff[end + 1] -= val;
            }

        }
        String ans = "";
        //now take commulative sum
        int commSum = 0;
        for(int i = 0 ; i < n ; i++){

            commSum += diff[i];

            diff[i] = commSum;

            //for handling negative numbers
            int shift =  (diff[i] % 26 + 26) % 26; 

            char ch = (char)(((s.charAt(i) - 'a' + shift)) % 26 + 'a');

            ans += ch;
        }
        return ans;
    }
}