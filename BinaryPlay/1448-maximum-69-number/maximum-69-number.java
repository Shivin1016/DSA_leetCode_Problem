class Solution {
    public int maximum69Number (int num) {
        String sb = Integer.toString(num);
        int n = sb.length();
        int maxi = num;
        for(int i = 0 ; i < n ; i++){
            if(sb.charAt(i) == '6'){
                StringBuilder str = new StringBuilder(sb); 
                str.setCharAt(i , '9'); 
                maxi = Math.max(maxi , Integer.parseInt(str.toString())); 
            }
        }
        return maxi;
    }
}