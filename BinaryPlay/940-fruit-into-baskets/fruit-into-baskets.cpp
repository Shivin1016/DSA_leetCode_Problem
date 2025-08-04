class Solution {
public:
    int totalFruit(vector<int>& fruits) {
        int n = fruits.size();

        unordered_map<int , int> basket ;

        int i = 0 , j = 0 ;
        int maxLen = 0;

        while(j < n){
            basket[fruits[j]]++; //take the fruit

            //if basket reached the limit greater than 2 then take off the fruit
            if(basket.size() > 2){
                basket[fruits[i]]--;
                if(basket[fruits[i]] == 0){
                    basket.erase(fruits[i]);
                }
                i++;
            }else{
                maxLen = max(maxLen , (j - i + 1));
            }
            j++;
        }
        return maxLen;

    }
};