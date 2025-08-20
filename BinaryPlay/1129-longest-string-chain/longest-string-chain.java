class Solution { 
    public boolean checkPredcessor(String s1 , String s2){
        int n1 = s1.length(); //curr
        int n2 = s2.length(); // prev

        if(n2 >= n1 || n1 - n2 != 1) return false;
        int i = 0 , j = 0;
        while(i < n1 && j < n2){
            if(s1.charAt(i) == s2.charAt(j)){
                j++;
            }
            i++;
        }
        return j == n2;
    }
    public int longestStrChain(String[] words) {

        int n = words.length;
        Arrays.sort(words , (a, b) -> a.length() - b.length());

        int[] t = new int[n]; 
        Arrays.fill(t , 1);

        int maxi = 1;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < i ; j++){
                if(checkPredcessor(words[i] , words[j])){
                    t[i] = Math.max(t[i] , t[j] + 1);
                    maxi = Math.max(maxi , t[i]);
                }
            }
        }
        return maxi;
    } 
}