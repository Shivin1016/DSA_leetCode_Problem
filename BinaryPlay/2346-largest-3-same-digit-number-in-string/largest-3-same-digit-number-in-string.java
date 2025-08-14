class Solution {
    public String largestGoodInteger(String num) {
        int n = num.length();

        int max = Integer.MIN_VALUE;
        int i = 0;
        while(i < n){
            String str = "";
            if(i + 3 <= n){
                str = num.substring(i , i + 3);
            }
            boolean isEqual = true;
            for(int j = 0 ; j < str.length() - 1 ; j++){
                if(str.charAt(j) != str.charAt(j + 1)){
                    isEqual = false;
                    break;
                }
            }
            if(isEqual == true && !str.equals("")){
                int integer = Integer.parseInt(str);
                max = Math.max(max , integer);
                i = i + 3;
            }else{
                i++;
            }
        }
        if(max == 0){
            return "000";
        }else if(max == Integer.MIN_VALUE){
            return "";
        }
        return Integer.toString(max);
    }
}