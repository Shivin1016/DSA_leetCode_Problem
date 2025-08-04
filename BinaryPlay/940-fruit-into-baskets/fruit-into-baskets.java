class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;

        Map<Integer , Integer> basket = new HashMap<>();
        int i = 0 , j = 0 ;
        int maxLen = 0;

        while(j < n){
            //basket that can store fruit of type 2
            basket.put(fruits[j] , basket.getOrDefault(fruits[j] , 0) + 1);
            
            //shrink if basket store greater than 2
            if(basket.size() > 2){
                int left = basket.get(fruits[i]) - 1;
                if(left == 0){
                    basket.remove(fruits[i]);
                }else{
                    basket.put(fruits[i] , left);
                }
                i++;
            }else{
                maxLen = Math.max(maxLen , j - i + 1);
            }
            j++;
        }
        return maxLen;
    }
}