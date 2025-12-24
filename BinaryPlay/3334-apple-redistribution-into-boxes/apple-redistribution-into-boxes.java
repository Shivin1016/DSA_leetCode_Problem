class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
   
        int m = capacity.length;

        int totalApples = 0;
        for(int app : apple ){
            totalApples += app;
        } 

        Arrays.sort(capacity);   // ascending 

        int box = 0;
        int len = 0;
        for(int i = m - 1 ; i >= 0 ; i--){
            box += capacity[i];
            len++; 
            if(box >= totalApples){
                return len;
            }
        }
        return len;
    }
}