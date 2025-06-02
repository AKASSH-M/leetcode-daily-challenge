package June_25_DCC;

public class Distribute_Candies_Among_Children_II_2929 {
    static class Solution {

        public long distributeCandies(int n, int limit) {
            long res = 0;
            for(int i = 0; i <= Math.min(limit, n); i++){
                if(n - i > 2 * limit){
                    continue;
                }
                res += Math.min(n - i, limit) - Math.max(0, n - i - limit) + 1;
            }
            return res;
        }
    }
}
