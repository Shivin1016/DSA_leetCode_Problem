class Solution { 

    public boolean doesAliceWin(String s) {
 
        //at least one vowel must be present for Alice wins
        for (char ch : s.toCharArray()) {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                return true;
            }
        }
        return false;
    }
}