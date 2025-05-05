class Solution {
public:
    int numEquivDominoPairs(vector<vector<int>>& dominoes) {
        int n = dominoes.size();

        map<vector<int> , int> mp;

        for(int i = 0; i < n ; i++){
            if(dominoes[i][0] > dominoes[i][1]){
                swap(dominoes[i][0] , dominoes[i][1]);
            }

            mp[dominoes[i]]++;
        }
        int pairs = 0;
        for (const auto& pair : mp){ 
            int frq = pair.second;
            if(frq > 1){
                pairs += (frq * (frq - 1)) / 2; 
            }
        }
        return pairs;
    } 
};