class Solution {
    public int binaryGap(int n) {
        String binary = Integer.toBinaryString(n);
        int len = binary.length();
        int maxDistance = 0;
        int i = 0 , first_1 = -1;
        while(i < len){
            int cnt = 1;
            if(first_1 == -1 && binary.charAt(i) == '1'){
                first_1 = 1;
                i++;
            } 
            while(i < len && binary.charAt(i) == '0'){
                i++;
                cnt++;
            }

            if(first_1 == 1 && i < len && binary.charAt(i) == '1'){
                maxDistance = Math.max(maxDistance , cnt);
            }
            i++;
        }

        return maxDistance;
    }
}