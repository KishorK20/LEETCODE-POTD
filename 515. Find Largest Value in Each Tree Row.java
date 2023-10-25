//Given the root of a binary tree, return an array of the largest value in each row of the tree (0-indexed).

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> largestValues(TreeNode root) {
     List<Integer> result = new ArrayList<>();

        if (root == null) {

            return result;

        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {

            int rowMax = Integer.MIN_VALUE;

            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {

                TreeNode node = queue.poll();

                rowMax = Math.max(rowMax, node.val);

                if (node.left != null) {

                    queue.offer(node.left);

                }

                if (node.right != null) {

                    queue.offer(node.right);

                }

            }

            result.add(rowMax);

        }

        return result;   
    }
}
