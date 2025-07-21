class Solution {
    public String makeFancyString(String s) {

        int n = s.length();

        char[] temp = s.toCharArray();
        int frqCnt = 1;
        int pos = 1;
        for (int i = 1 ; i < n ; i++) {

            if (s.charAt(i) == s.charAt(i - 1)) {
                frqCnt++; 
            }
            else{
                frqCnt = 1; 
            }

            //frqCnt >= 3 --> means consecutive characters are found-->then don't take this character
            if (frqCnt > 2)
                continue;

            // //if not consecutive of three then take it 
            temp[pos++] = temp[i];
        }
        return new String(temp , 0 , pos);
    }
}