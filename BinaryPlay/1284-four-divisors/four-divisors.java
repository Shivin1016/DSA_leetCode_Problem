class Solution {
    public int sumFourDivisors(int[] nums) {
         int n = nums.length;
         long res = 0;
        for(int num : nums){
            List<Integer> factors = new ArrayList<>();
            for(int i = 1 ; i <= Math.sqrt(num) ; i++){
                if(num % i == 0){
                    if(num / i != i){
                        factors.add(num / i);
                    }
                    factors.add(i);
                }
            }
            int sum = 0;
            if(factors.size() == 4){
                for(int fact : factors){
                    sum += fact;
                }
            }
            res += sum;
        }
        return (int)res;
    }
}