class Solution {
    public String reverseWords(String s) {

        int n = s.length();

        StringBuilder sb = new StringBuilder(s);
        sb.reverse();

        String ans = "";
        int lastSeenSpace = -1;
        int i = n - 1;
        while(i >= 0){
            if(sb.charAt(i) == ' '){
                //found spcae -> found one sentance
                int currentSeenSpace = i;
                String subStr = "";
                if(lastSeenSpace == -1){
                    subStr = sb.substring(currentSeenSpace + 1 , n);
                }else{
                    subStr = sb.substring(currentSeenSpace + 1 , lastSeenSpace);
                }
                lastSeenSpace = currentSeenSpace;
                ans = ans + subStr + " "; // add space
            } 
            i--;
        }
        //for last word
        ans += sb.substring(0 , lastSeenSpace == -1 ? n : lastSeenSpace);

        return ans;
    }
}