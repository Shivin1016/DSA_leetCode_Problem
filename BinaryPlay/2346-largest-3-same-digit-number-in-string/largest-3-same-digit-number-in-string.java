class Solution {
    public String largestGoodInteger(String num) {
        int n = num.length();
        String max = "";

        for(int i = 0 ; i < n - 2 ; i++){

            String str = num.substring(i , i + 3);

            if(str.charAt(0) == str.charAt(1) && str.charAt(1) == str.charAt(2)){
                if(str.compareTo(max) > 0){
                    max = str;
                }
            }
        }
        return max;
    }
}