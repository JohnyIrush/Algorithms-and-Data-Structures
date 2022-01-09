package Trees;

public class ThreadedBinaryTree
{
    static class Node
    {
        int value;
        Node left;
        Node right;
        //boolean leftThread;
        boolean rightThread;

        Node()
        {

        }

        Node(int value)
        {
            this.value = value;
        }

        Node(int value, Node left, Node right, boolean rightThread)
        {
            this.value = value;
            this.left = left;
            this.right = right;
            this.rightThread = rightThread;
        }

    }

    //Returns Inorder traversal

    public static void inorder(Node node)
    {
        Node current = leftmost(node);

        while (current != null && current.value != -1)
        {
            System.out.print(current.value + " ");
            if (current.rightThread)
                current = current.right;
            else
                current = leftmost(current.right);
        }
    }

    // Returns non-null leftmost child for the node
    private static  Node leftmost(Node node)
    {
        if (node == null)
            return null;
        while (node.left != null)
            node = node.left;
        return node;
    }

    public static void main(String[] args)
    {
        Node dummy = new Node(-1);
        Node ten = new Node(10);
        Node eight = new Node(8);
        Node twelve = new Node(12);
        Node fifteen = new Node(15);
        Node two = new Node(2);
        Node seven = new Node(7);

        //Adding left and riht child nodes
        ten.left = eight;
        ten.right = twelve;
        eight.left = fifteen;
        eight.right = two;
        two.left = seven;
        dummy.left = ten;

        //Adding threads
        dummy.right = dummy;
        dummy.rightThread = true;

        fifteen.right = eight;
        fifteen.rightThread = true;

        seven.right = two;
        seven.rightThread = true;

        two.right = ten;
        two.rightThread = true;

        twelve.right = dummy;
        twelve.rightThread = true;

        inorder(dummy);
    }

}
