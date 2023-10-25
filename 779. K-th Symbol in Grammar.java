// We build a table of n rows (1-indexed). We start by writing 0 in the 1st row. Now in every subsequent row, we look at the previous row and replace each 
// occurrence of 0 with 01, and each occurrence of 1 with 10.

// For example, for n = 3, the 1st row is 0, the 2nd row is 01, and the 3rd row is 0110.
// Given two integer n and k, return the kth (1-indexed) symbol in the nth row of a table of n rows.

class Solution {
    public int kthGrammar(int n, int k) {
         if (n == 1) {
            return 0;
        }
        
        // Calculate the length of the previous row (2^(n-1)).
        int prevLen = (int) Math.pow(2, n - 1);
        
        // If k is in the first half of the current row, it will be the same as k in the previous row.
        if (k <= prevLen / 2) {
            return kthGrammar(n - 1, k);
        } else {
            // If k is in the second half of the current row, it will be the opposite of k in the previous row.
            return 1 - kthGrammar(n - 1, k - prevLen / 2);
        }
    }
}
