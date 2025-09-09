class Solution { 
    int m = 1000000007;
    int[] t ;
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int total = 0;

        t = new int[1001];
        Arrays.fill(t , -1);
        t[1] = 1; // know the screte

        for(int day = 2 ; day <= n ; day++){
            int count = 0 ;
            for(int d = day - forget + 1 ; d <= day - delay ; d++){
                if(d > 0){
                    count = (count + t[d]) % m;
                }
            }
            t[day] = count;
        }

        for(int day = n - forget + 1 ; day <= n ; day++){
            if(day > 0){
                total = (total + t[day]) % m;
            }
        }

        return total;
    } 
}