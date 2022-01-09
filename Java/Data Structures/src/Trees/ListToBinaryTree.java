package Trees;
import LinkedList.LinkedList;
import LinkedList.LinkedList.Node;

public class ListToBinaryTree
{
    public static Tree.Node listToBinaryTree(Node head)
    {
        if (head == null)
            return null;

        Node mid = mid(head);
        Tree.Node root = new Tree.Node(mid.data);

        if (head == mid)
            return root;

        root.left = listToBinaryTree(head);
        root.right = listToBinaryTree(mid.link);

        return root;
    }

    public static Node mid(Node head)
    {
        Node fast = head;
        Node slow = head;
        Node prev = head;

        while (fast != null && fast.link != null)
        {
            prev = slow;
            slow = slow.link;
            fast = fast.link.link;
        }

        if (prev != null)
            prev.link = null;

        return slow;
    }

    public static void main(String[] args)
    {
        Node head = new Node();

        LinkedList linkedList = new LinkedList();

        head = linkedList.addEnd(head, 100);
        head = linkedList.addEnd(head, 200);
        head = linkedList.addEnd(head, 300);
        head = linkedList.addEnd(head, 400);
        head = linkedList.addEnd(head, 500);
        linkedList.print(head);

        Tree.Node tree = listToBinaryTree(head);

        System.out.println(Traversal.preorder(tree));
    }
}
