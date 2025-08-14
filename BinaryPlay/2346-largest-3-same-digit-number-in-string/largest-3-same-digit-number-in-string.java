class Solution {
    public String largestGoodInteger(String num) {
        //we have to find unique digits in string of length 3
        // as constraint is 1000 so , string can be
        String[] str = {"999" , "888" , "777" , "666" , "555" ,"444" , "333" ,"222" , "111" , "000"};

        for(int i = 0 ; i < str.length ; i++){
            //check each i indx of str in num
            if(num.contains(str[i])){
                return str[i]; // as str is in descending order so it will give max value in starting;
            }
        }
        return "";
    }
}