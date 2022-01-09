package Trees;

public class Insert
{
    public static Tree.Node insert(int value, Tree.Node root)
    {
        if (root == null)
            root = new Tree.Node(value);
        else
        {
            if (value < root.value)
                root.left = insert(value, root.left);
            else
                root.right = insert(value, root.right);
        }
        return root;
    }

    public static void main(String[] args)
    {
        Tree.Node left = new Tree.Node(5);
        Tree.Node right = new Tree.Node(9);
        Tree.Node root = new Tree.Node(8, left, right);
        left.left = new Tree.Node(2);
        left.right = new Tree.Node(6);

        int value = 7;
        System.out.println("Inorder Traversal before Inserting " + value);
        System.out.println(Traversal.inorder(root));

        insert(value, root);

        System.out.println("Inorder Traversal after Inserting " + value);
        System.out.println(Traversal.inorder(root));
    }
}
