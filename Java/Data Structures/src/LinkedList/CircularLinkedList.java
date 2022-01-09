package LinkedList;

public class CircularLinkedList
{
    static class Node
    {
        int data;
        Node next;
        public Node(int data)
        {
          this.data = data;
        }
    }

    //Declaring head and tail pointer as null.
    public Node head = null;
    public Node tail = null;


    public Node add(int data)
    {
        Node newNode = new Node(data);
        if (head == null)
        {
            head = newNode;
            tail = newNode;
            newNode.next = head;
            return head;
        }
        else
        {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
            return head;
        }
    }

    public Node addBeggining(int data)
    {
        Node newNode = new Node(data);
        if (head == null)
        {
            head = newNode;
            tail = newNode;
            newNode.next = head;
            return head;
        }
        else
        {
            Node temp = head.next; //
            head.next = temp;
            newNode.next = head;
            head = newNode;
            tail.next = head;
            return head;
        }
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
    private Node deleteLast()
    {
        if (head != null)
        {
            if (head.next == head)
            {
                head = null;
                return null;
            }
            else
            {
                Node current = head;
                while (current.next.next != head)
                    current = current.next;
                current.next = head;
                return head;
            }
        }
        return null;
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
                Node previous = null;
                while (position != 1)
                {
                    position--;
                    previous = current;
                    current = current.next;
                }
                previous.next = current.next;
                return head;
            }
        }
        return null;
    }

    Node deleteFirstNode()
    {
        if (head != null)
        {
            if (head.next == head)
            {
                head = null;
                return null;
            }
            head = head.next;
            tail.next = head;
            return head;
        }
        return null;
    }

    public static void main(String[] args)
    {
        CircularLinkedList list = new CircularLinkedList();
        Node nodes = list.add(1);
        nodes = list.add(2);
        nodes = list.add(3);
        nodes = list.add(4);
        nodes = list.addBeggining(8);
        //nodes = list.deleteLast();
        //nodes = list.deleteLast();
        //nodes = list.deleteLast();
        //nodes = list.deleteFirstNode();
        nodes = list.deleteIntermediate(3);
        list.display();
    }
}
