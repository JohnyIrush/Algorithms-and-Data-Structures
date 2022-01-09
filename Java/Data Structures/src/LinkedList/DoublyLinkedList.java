package LinkedList;

public class DoublyLinkedList
{
    static class Node
    {
        Node previous;
        int data;
        Node next;
    }

    public Node add(Node head, int data)
    {
        Node temp = new Node();
        temp.previous = null;
        temp.data = data;
        temp.next = null;
        head = temp;
        return head;
    }

    public Node addAtFirst(Node head, int data)
    {
        Node temp;
        Node newNode = new Node();
        newNode.previous = null;
        newNode.data = data;
        newNode.next = null;

        temp = head;

        newNode.next = temp;

        head = newNode;

        return head;
    }

    public void addEnd(Node head, int data)
    {
        Node temp = new Node();
        temp.previous = null;
        temp.data = data;
        temp.next = null;
        Node pointer = head;

        while(pointer.next != null)
            pointer = pointer.next;

        pointer.next = temp;
        temp.previous = pointer;
    }

    public void addBetween(Node head, int data, int position)
    {
        Node pointer, temp2, newNode = null;
        Node temp = head;

        newNode = add(newNode, data);

        while (position != 1)
        {
            temp = temp.next;
            position--;
        }
        if (temp.next == null)
        {
            temp.next = newNode;
            newNode.previous = temp;
        }
        else
        {
            temp2 = temp.next;
            temp.next = newNode;
            temp2.previous = newNode;
            newNode.next = temp2;
            newNode.previous = temp;
        }
    }

    public void print(Node head)
    {
        while (head != null)
        {
            System.out.print(head.data);
            head = head.next;
        }
    }

    public Node deleteFirstNode(Node head)
    {
        /*Node temp = head;
        head = head.next;
        temp = null;
        head.previous = null;
         */
        return head.next;
    }

    public Node deleteLastNode(Node head)
    {
        Node temp, temp2 = null;
        temp = head;
        while(temp.next != null)
            temp = temp.next;
        temp2 = temp.previous;
        temp2.next = null;

        return head;
    }

    public Node deleteIntermediateNode(Node head, int position)
    {
        Node temp, temp2 = null;
        temp = head;
        if (position == 1)
        {
            head = deleteFirstNode(head);
            return head;
        }

        while(position > 1)
        {
            temp = temp.next;
            position--;
        }
        if (temp.next == null)
            head = deleteLastNode(head);
        else
        {
            temp2 = temp.previous;
            temp2.next = temp.next;
            temp.next.previous = temp2;
            temp = null;
        }
        return head;
    }

    public Node reverse(Node head)
    {
        Node pointer1 = head;
        Node pointer2 = pointer1.next;

        pointer1.next = null;
        pointer1.previous = pointer2;

        while (pointer2 != null)
        {
            pointer2.previous = pointer2.next;
            pointer2.next = pointer1;
            pointer1 = pointer2;
            pointer2 = pointer2.previous;
        }

        head = pointer1;
        return head;
    }


    public static void main(String[] args)
    {
        Node head = null;
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        head = doublyLinkedList.add(head,1);
        doublyLinkedList.addEnd(head,2);
        doublyLinkedList.addEnd(head,3);
        doublyLinkedList.addEnd(head,4);
        //doublyLinkedList.addBetween(head, 3, 1);
        //doublyLinkedList.addBetween(head, 4, 2);
        //doublyLinkedList.addBetween(head, 30000, 4);
        //head = doublyLinkedList.deleteFirstNode(head);
        //head = doublyLinkedList.deleteFirstNode(head);
        //head = doublyLinkedList.deleteFirstNode(head);
        //doublyLinkedList.deleteLastNode(head);
        //head = doublyLinkedList.deleteFirstNode(head);
        doublyLinkedList.addEnd(head,60);
        head = doublyLinkedList.addAtFirst(head,50);
        //head = doublyLinkedList.deleteIntermediateNode(head, 2);
        head = doublyLinkedList.reverse(head);
        doublyLinkedList.print(head);
    }
}
