package LinkedList;

import java.util.Scanner;

public class PolynomilalArithmetic
{
    class Node
    {
        int data;
        Node next;
        float coefficient; 
        int exponent;

        public Node(float coefficient, int exponent)
        {
            this.coefficient = coefficient;
            this.exponent = exponent;
            this.next = null;
        }
    }


    public Node create()
    {
        Node head = null;
        float coefficient;
        int exponent;

        System.out.println("Enter the Number of Terms: ");
        Scanner input = new Scanner(System.in);
        int terms = Integer.parseInt((input.nextLine()));

        for (int i = 0; i < terms; i++)
        {
            System.out.println("Enter the coefficient for term: " + (i + 1));
            Scanner coefficientInput = new Scanner(System.in);
            coefficient = Integer.parseInt((input.nextLine()));

            System.out.println("Enter the exponent for term: " + (i + 1));
            Scanner exponentInput = new Scanner(System.in);
            exponent = Integer.parseInt((input.nextLine()));
            head = insert(head, coefficient, exponent);
        }

        return head;
    }

    public Node insert(Node head, float coefficient, int exponent)
    {
        Node temp;
        Node newNode = new Node(coefficient, exponent);

        if(head == null || exponent > head.exponent)
        {
            newNode.next = head;
            head = newNode;
        }
        else
        {
            temp = head;
            while (temp.next != null && temp.next.exponent > exponent)
                temp = temp.next;
            newNode.next = temp.next;
            temp.next = newNode;
        }
        return head;
    }
    
    public Node print(Node head)
    {
        Node current = head;
        while (current != null)
        {
            System.out.printf("(%.1fx^%d)",current.coefficient, current.exponent);
            current = current.next;
            if(current != null)
                System.out.print("+");
        }
        return head;
    }


    public static void main(String[] args)
    {
        PolynomilalArithmetic polynomilalArithmetic = new PolynomilalArithmetic();

        System.out.println("Enter the polynomial: ");

        Node head = polynomilalArithmetic.create();
        polynomilalArithmetic.print(head);

    }
}
