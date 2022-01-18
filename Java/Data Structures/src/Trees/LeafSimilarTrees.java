package Trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeafSimilarTrees {

    //Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private static ArrayList<Integer> leafNodes = new ArrayList<>();

    public static ArrayList<Integer> preorder(TreeNode root)
    {
        if(root == null)
            return leafNodes;
        if (root.left == null && root.right == null)
            leafNodes.add(root.val);
        preorder(root.left);
        preorder(root.right);

        return leafNodes;
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leafNodes1 = preorder(root1);
        leafNodes = new ArrayList<>();
        List<Integer> leafNodes2 = preorder(root2);

        for (int i = 0; i < leafNodes1.size(); i++) {
            if (leafNodes1.get(i) != leafNodes2.get(i))
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        // [1,2,3]
        //[1,3,2]
        //TreeNode left = new TreeNode(1);
        //TreeNode right = new TreeNode(3);
        TreeNode root1 = new TreeNode(1);

        //TreeNode left2 = new TreeNode(1);
        //TreeNode right2 = new TreeNode(2);
        TreeNode root2 = new TreeNode(1);

        //List<Integer> leafNodes1 = preorder(root1);
        //leafNodes = new ArrayList<>();
        //List<Integer> leafNodes2 = preorder(root2);

        //System.out.println(leafNodes1);
        //System.out.println(leafNodes2);
        System.out.println(new LeafSimilarTrees().leafSimilar(root1, root2));

    }
}
