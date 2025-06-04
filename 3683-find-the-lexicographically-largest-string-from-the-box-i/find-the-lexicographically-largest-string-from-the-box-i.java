class Solution {
    public String answerString(String word, int numFriends) {

        int n = word.length();

        if(numFriends == 1) return word;

        String ans = "";
 
        int longestPossible = n - (numFriends - 1); 

        for(int i = 0 ; i < n ; i++){

            int canTakeLength = Math.min(longestPossible , n - i);

            String subs =  word.substring(i , i + canTakeLength);

            if(subs.compareTo(ans) > 0){
                ans = subs;
            }

        }
        return ans;
    }
}