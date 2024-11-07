class TreeNode {
    int val; // Node value
    TreeNode left; // Left child
    TreeNode right; // Right child

    // Constructor
    TreeNode() {}

    // Constructor with value
    TreeNode(int val) { this.val = val; }

    // Constructor with value, left child, and right child
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    private int[] nums;

    /**
     * Convert a sorted array into a height-balanced binary search tree.
     *
     * @param nums Sorted array of integers
     * @return Root of the height-balanced binary search tree
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        return constructBSTRecursive(0, nums.length - 1);
    }

    /**
     * Recursive helper method to construct BST from the sorted array.
     *
     * @param left  The starting index of the subarray
     * @param right The ending index of the subarray
     * @return The root of the BST subtree constructed from subarray
     */
    private TreeNode constructBSTRecursive(int left, int right) {
        // Base case: If left > right, the subarray is empty and should return null
        if (left > right) {
            return null;
        }
      
        // Find the middle element to maintain BST properties. Use `left + (right - left) / 2`
        // to avoid integer overflow
        int mid = left + (right - left) / 2;

        // Recursively construct the left subtree
        TreeNode leftSubtree = constructBSTRecursive(left, mid - 1);
      
        // Recursively construct the right subtree
        TreeNode rightSubtree = constructBSTRecursive(mid + 1, right);
      
        // Create a new TreeNode with the mid element and the previously constructed left and right subtrees
        TreeNode node = new TreeNode(nums[mid], leftSubtree, rightSubtree);
      
        return node;
    }
}