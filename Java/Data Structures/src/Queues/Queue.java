package Queues;

public class Queue
{
    private static class Node
    {
        private int data;
        private Node next;
        private Node(int data)
        {
            this.data = data;
        }
    }
    
    private Node head;
    private Node tail;
    
    public boolean isEmpty()
    {
        return head == null;
    }

    public int peek()
    {
        return head.data;
    }

    public void enqueue(int data)
    {
        Node node = new Node(data);
        if (tail != null)
            tail.next = node;
        tail = node;

        if (isEmpty())
            head = node;
    }
    public int dequeue()
    {
        Node output = head;

        head = output.next;
        if (isEmpty())
            tail = null;
        return output.data;
    }
}
