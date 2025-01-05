import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root != null) {
            findPaths(root, "", paths);
        }
        return paths;
    }

    private void findPaths(TreeNode node, String currentPath, List<String> paths) {
        currentPath += Integer.toString(node.val);
        if (node.left == null && node.right == null) {
            paths.add(currentPath);
        } else {
            currentPath += "->"; 
            if (node.left != null) {
                findPaths(node.left, currentPath, paths);
            }
            if (node.right != null) {
                findPaths(node.right, currentPath, paths);
            }
        }
    }

    public static void main(String[] args) {
   
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);

        Solution solution = new Solution();
        List<String> paths = solution.binaryTreePaths(root);
        System.out.println("Root-to-leaf paths: " + paths);
    }
}