package LinkedList;
public class LinkedList
{
    public static class Node
    {
        public int data;
        public Node link;
    }

    public void count_of_nodes(Node head)
    {
        int count = 0;
        if (head == null)
            System.out.println("Linked List is Empty");
        Node pointer = null;
        pointer = head;
        while (pointer != null)
        {
            count++;
            pointer = pointer.link;
        }
        System.out.println("No of Nodes: " +  count);
    }

    public Node addEnd(Node head, int data)
    {
        Node pointer, temp;
        pointer = head;
        temp = new Node();
        temp.data = data;
        temp.link = null;

        while(pointer.link != null)
        {
            pointer = pointer.link;
        }
        pointer.link = temp;
        return head;
    }

    public Node addBeginning(Node head, int data)
    {
        Node pointer = new Node();
        pointer.data = data;
        pointer.link = null;

        if (head == null)
            head = pointer;
        else
        {

            pointer.link = head;
            head = pointer;
        }

        return head;
    }

    public void addAfter(Node head,int data, int position)
    {
        Node pointer = head;
        Node pointer2 = new Node();
        pointer2.data = data;
        pointer2.link = null;

        position--;
        while (position != 1)
        {
            pointer = pointer.link;
            position--;
        }

        pointer2.link = pointer.link;
        pointer.link = pointer2;
    }

    public void removeLastElement(Node head)
    {
        Node temp = head;
        if (head == null)
            System.out.println("Linked List is Empty");
        while(head.link.link != null)
        {
            temp = temp.link;
        }
        temp.link = null;
    }

    public Node reverse(Node head)
    {
        Node previous = null;
        Node next = null;

        while (head != null)
        {
            next = head.link; // 7->8  | 8->5->null | 5->null
            head.link = previous; // 5->null | 5->null | 7->5->null
            previous = head; // 5->null | 7->5->null | 8->7->5->null
            head = next; // 7->8->5->null | 8->5->null |

        }
        return previous;
    }

    public void rearrange(Node head)
    {
        Node pointer, q;
        int temp;
        if (head != null || head.link != null)
            return;
        pointer = head; q = head.link;

        while (q != null) // [1,2,3,4,5,6,7]
        {
            temp = pointer.data; pointer.data = q.data;
            q.data = temp; pointer = q.link;
            q = (pointer != null)? pointer.link : null;
        }
    }

    public boolean checkIncreasingOrder(Node head)
    {
        return ((head == null) || (head.link == null) || ((head.data <= head.link.data) && checkIncreasingOrder(head.link)));
    }

    public void print(Node head)
    {
        Node current = head;

        while (current != null)
        {
            if (current != null)
                System.out.print(current.data + " ");
            current = current.link;
        }
    }

    public static void main(String[] args)
    {
        Node head = new Node();

        LinkedList linkedList = new LinkedList();

        head = linkedList.addBeginning(head, 100);
        head = linkedList.addBeginning(head, 200);
        head = linkedList.addBeginning(head, 300);
        head = linkedList.addBeginning(head, 400);
        head = linkedList.addBeginning(head, 500);
        linkedList.print(head);
    }
}
