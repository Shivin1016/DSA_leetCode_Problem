class Solution {
    public int minOperations(int[] nums, int k) {

        int sum = 0; /// total sum 

        for (int num : nums) {
            sum += num;
        }

        return sum % k; // minimum operations required to make num divisible by k
    }
}