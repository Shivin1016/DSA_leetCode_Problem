class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;

        int remain = 0;
        int[] filled = new int[1001];

        for(int i = 0 ; i < n ; i++){

            boolean isfill = false;

            for(int j = 0 ; j < n ; j++){

                if(filled[j] == 1) continue;

                if(fruits[i] <= baskets[j]){
                    filled[j] = 1; 
                    isfill = true;
                    break;
                }
            } 
            if(!isfill) remain++;
        }
        return remain;
    }
}