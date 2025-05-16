class Solution {
    public String getEncryptedString(String s, int k) {

        int n = s.length();

        StringBuilder ans = new StringBuilder();

        for(int i = 0 ; i < n ; i++){
            int replaceIdx = (i + k) % n;
            ans.append(s.charAt(replaceIdx));
        }
        return ans.toString();
    }
}