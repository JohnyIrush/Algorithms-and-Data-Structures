package LinkedList;

public class CircularDoublyLinkedList
{
    static class Node
    {
        Node previous;
        int data;
        Node next;
        public Node(int data)
        {
            this.data = data;
        }
    }

    public Node head = null;
    public  Node tail = null;

    public Node add(int data)
    {
        Node newNode = new Node(data);
        newNode.data = data;

        if (head == null)
        {
            head = newNode;

            tail.previous = head;
            tail.next = head;

            head.previous = tail;
            head.next = tail;
        }
        else
        {
            tail.next = newNode;

            tail.next = head;
            head.previous = tail;
        }
        return head;
    }
    //Displays all the nodes in the list
    public void display() {
        Node current = head;
        if(head == null)
        {
            System.out.println("List is empty");
        }
        else
        {
            System.out.println("Nodes of the circular linked list: ");
            do{
                //Prints each node by incrementing pointer.
                System.out.print(" "+ current.data);
                current = current.next;
            }while(current != head);
            System.out.println();
        }
    }

    public Node addBeggining(int data)
    {
        Node temp;
        Node newNode = new Node(data);

        if (head == null)
            add(data);
        else
            {
                temp = head.next;

                head.next = temp;

                head = newNode;
                tail.next = head;
                head.previous = tail;
            }
        return head;
    }

    public void deleteFirstNode()
    {
        if (head != null)
        {
            if (head.next == head)
            {
                head = tail = null;
            }

            head = head.next;
            tail.next = head;
            head.previous = tail;
        }
    }

    public Node deleteIntermediate(int position)
    {
        if (head != null)
        {
            if (head.next == head)
            {
                head = null;
                return null;
            }
            if (position == 1)
            {
                deleteFirstNode();
                return head;
            }
            else
            {
                Node current = head;

                while (position != 1)
                {
                    position--;
                    current = current.next;
                }
                current.previous.next = current.next;
                return head;
            }
        }
        return null;
    }

    public static void main(String[] args)
    {

        CircularLinkedList circularLinkedList = new CircularLinkedList();
        CircularLinkedList.Node list = circularLinkedList.add(1);
         list = circularLinkedList.add(2);
         circularLinkedList.add(3);
        circularLinkedList.add(4);
        circularLinkedList.addBeggining(0);
        circularLinkedList.addBeggining(-1);
        circularLinkedList.addBeggining(-2);
        //circularLinkedList.deleteFirstNode();
        //circularLinkedList.deleteFirstNode();
        circularLinkedList.deleteIntermediate(2);
        circularLinkedList.display();
    }
}
