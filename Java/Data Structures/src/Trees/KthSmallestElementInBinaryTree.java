package Trees;

public class KthSmallestElementInBinaryTree
{
    int k;
    int result = 0;

    public int kthSmallest(Tree.Node root, int k)
    {
        this.k = k;
        inorder(root);
        return result;
    }

    public void inorder(Tree.Node root)
    {
        if (root == null)
            return;
        inorder(root.left);
        if (--k == 0)
        {
            result = root.value;
            return;
        }
        inorder(root.right);
    }

    public static void main(String[] args)
    {
        Tree.Node left = new Tree.Node(4);
        Tree.Node right = new Tree.Node(13);
        Tree.Node root = new Tree.Node(9, left, right);
        left.left = new Tree.Node(2);
        left.right = new Tree.Node(7);
        right.right = new Tree.Node(17);

        System.out.println(new KthSmallestElementInBinaryTree().kthSmallest(root,3));
    }
}
