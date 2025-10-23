class Solution {
    public boolean hasSameDigits(String s) {
        int n = s.length(); 
 
        while(s.length() > 2){
            n = s.length();
            StringBuilder sb = new StringBuilder();
            for(int i = 0 ; i < n - 1 ; i++){
                long num1 = s.charAt(i) - '0';
                long num2 = s.charAt(i + 1) - '0';
                long num = (num1 + num2) % 10;
                sb.append(num);
            }
            s = sb.toString();
            System.out.println(s);
        }
        return (s.charAt(0) == s.charAt(1));
    }
}