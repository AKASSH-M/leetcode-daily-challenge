public class Divisible_and_Non_divisible_Sums_Difference {
    static class Solution {
        public int differenceOfSums(int n, int m) {
            // result = num1 - num2
            /*num1 is the sum of number
            from 1 to n which is not divisible by m */

            /*num2 is the sum of numbers divisible
            * by m in the range*/

            // num1 = sum(n numbers) - num2
            // num2 = [1m + 2m + 3m + ... + km] km <= n
            // k <= n/m
            // num2 = m [ 1 + 2 + ..... + K ] = m ( K) (K + 1)/2

            int sum = (n*(n+1))/2 , k = n /m;
            int num2 = (m * k * (k+1))/2;
            return  sum -  2 * num2;
        }
    }
}
