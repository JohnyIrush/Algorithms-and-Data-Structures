package Trees;

public class Search
{
    public static Tree.Node search(int value, Tree.Node root)
    {
        if (root == null)
            return null;
        if (value == root.value)
            return  root;
        if (value < root.value)
            return search(value, root.left);
        else
            return search(value, root.right);
    }

    public static void main(String[] args)
    {
        Tree.Node left = new Tree.Node(4);
        Tree.Node right = new Tree.Node(13);
        Tree.Node root = new Tree.Node(9, left, right);
        left.left = new Tree.Node(2);
        left.right = new Tree.Node(7);
        right.right = new Tree.Node(17);

        Tree.Node result = search(7, root);
        if (result != null)
            System.out.println("Node found it is: " + result.value);
        else
            System.out.println("Node found");
    }
}
