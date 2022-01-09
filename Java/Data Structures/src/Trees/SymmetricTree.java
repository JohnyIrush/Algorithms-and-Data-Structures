package Trees;

public class SymmetricTree
{

    public static boolean isMirror(Tree.Node a, Tree.Node b)
    {
        if (a == null && b == null)
            return true;
        if (a != null && b != null)
            return a.value == b.value
            && isMirror(a.left, b.right)
            && isMirror(b.right, a.left);
        else
            return false;
    }

    public static void main(String[] args)
    {
        Tree.Node left = new Tree.Node(2);
        Tree.Node right = new Tree.Node(3);
        Tree.Node root = new Tree.Node(1, left, right);
        left.right = new Tree.Node(5);
        right.right = new Tree.Node(7);

        if (root == null)
            System.out.println("Tree is Symmetric");
        else
        {
            boolean isSymmetric = isMirror(root.left, root.right);
            System.out.println("Tree is " + (isSymmetric ? "Symmetric" : "Not Symmetric"));
        }
    }
}
