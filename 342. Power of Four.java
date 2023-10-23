//Given an integer n, return true if it is a power of four. Otherwise, return false.
//An integer n is a power of four, if there exists an integer x such that n == 4x.
//Example 1:
//Input: n = 16
//Output: true

class Solution {
    publicclass boolean isPowerOfFour(int n) {
       if (n <= 0) {

            return false;

        }

        // Check if it's a power of two

        if ((n & (n - 1)) != 0) {

            return false;

        }

        // Check if the number of trailing zeros is odd

        int count = 0;

        while (n > 1) {

            n >>= 1;

            count++;

        }

        return count % 2 == 0;
    }
}
