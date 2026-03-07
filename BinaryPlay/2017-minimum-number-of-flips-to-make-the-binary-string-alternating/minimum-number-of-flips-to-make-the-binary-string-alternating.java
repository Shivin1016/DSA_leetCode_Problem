class Solution {
    public int minFlips(String s) {

        int n = s.length();
        String str = s + s;

        int flip1 = 0, flip2 = 0;
        int res = Integer.MAX_VALUE;

        for(int i = 0; i < 2 * n; i++){

            char expected1 = (i % 2 == 0) ? '0' : '1';
            char expected2 = (i % 2 == 0) ? '1' : '0';

            if(str.charAt(i) != expected1) flip1++;
            if(str.charAt(i) != expected2) flip2++;

            if(i >= n){
                char prev1 = ((i - n) % 2 == 0) ? '0' : '1';
                char prev2 = ((i - n) % 2 == 0) ? '1' : '0';

                if(str.charAt(i - n) != prev1) flip1--;
                if(str.charAt(i - n) != prev2) flip2--;
            }

            if(i >= n - 1){
                res = Math.min(res, Math.min(flip1, flip2));
            }
        }

        return res;
    }
}