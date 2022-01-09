package Trees;

public class MaximumPathSum
{
    static int maxSum = Integer.MIN_VALUE;

    public static int maxSum(Tree.Node node)
    {
        if (node == null)
            return 0;

        int left = Math.max(0, maxSum(node.left));
        int right = Math.max(0, maxSum(node.right));
        int currentSum = node.value + left + right;

        maxSum = Math.max(currentSum, maxSum);

        return Math.max(node.value + left, node.value + right);
    }

    public static void main(String[] args)
    {
        Tree.Node left = new Tree.Node(9);
        Tree.Node right = new Tree.Node(20, new Tree.Node(15), new Tree.Node(7));
        Tree.Node root = new Tree.Node(-10, left, right);

        if (root == null)
            System.out.println("Max Sum is: 0");
        else
        {
            maxSum(root);
            System.out.println("Max Sum is: "+ maxSum);
        }
    }
}
