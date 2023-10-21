// Given an integer array nums and an integer k, return the maximum sum of a non-empty subsequence of that array such that for every two consecutive integers in the subsequence, nums[i] and nums[j], where i < j, the condition j - i <= k is satisfied.
// A subsequence of an array is obtained by deleting some number of elements (can be zero) from the array, leaving the remaining elements in their original order.

// Example 1:
// Input: nums = [10,2,-10,5,20], k = 2
// Output: 37
// Explanation: The subsequence is [10, 2, 5, 20].

class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        Deque<Integer> dq = new LinkedList<>();
        int res = Integer.MIN_VALUE;

        for(int i=0; i<nums.length; i++){
            int temp = Math.max(0, dq.isEmpty()?0:nums[dq.peekFirst()]);
            nums[i] += temp;
            res = Math.max(res, nums[i]);

            while(!dq.isEmpty() && nums[i]>=nums[dq.peekLast()]){
                dq.pollLast();
            }
            dq.addLast(i);
            if(i-dq.peekFirst()+1 > k){
                dq.removeFirst();
            }
        }
        return res;
    }
}
