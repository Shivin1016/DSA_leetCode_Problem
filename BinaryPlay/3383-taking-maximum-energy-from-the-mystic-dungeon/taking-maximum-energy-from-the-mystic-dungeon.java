class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;

        int maxEnergy = Integer.MIN_VALUE; 
        for(int i = n - k ; i < n ; i++){ 
            int j = i;
            int sum = 0;
            while(j >= 0){
                sum += energy[j];
                j = j - k;
                maxEnergy = Math.max(maxEnergy , sum);
            }
        }
        return maxEnergy;
    }
}