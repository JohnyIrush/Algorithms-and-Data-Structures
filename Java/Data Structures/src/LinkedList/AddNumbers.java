package LinkedList;
import LinkedList.LinkedList.Node;

import java.util.Scanner;

public class AddNumbers
{
    public Node create(int Number)
    {
        Node head = null;
        LinkedList linkedList = new LinkedList();
        while (Number != 0)
        {
            head = linkedList.addBeginning(head, Number%10);
            Number = Number/10;
        }

        return head;
    }

    public Node addTwoNumbers(Node firstNo,Node secondNo)
    {
        Node result = new Node();
        int carry = 0, sum = 0;
        Node pointer1 = firstNo;
        Node pointer2 = secondNo;

        LinkedList linkedList = new LinkedList();

        while (pointer1 != null || pointer2 != null)
        {
            sum = 0;
            if (pointer1 != null)
                sum += pointer1.data;
            if (pointer2 != null)
                sum += pointer2.data;

            sum += carry;
            carry = sum/10;
            sum = sum%10;

            result = linkedList.addBeginning(result, sum);

            if (pointer1 != null)
                pointer1 = pointer1.link;
            if (pointer2 != null)
                pointer2 = pointer2.link;
        }
        if (carry != 0)
            result = linkedList.addBeginning(result,carry);

        return result;
    }

    public static void main(String[] args)
    {
        System.out.println("Enter First Number: ");
        Scanner input = new Scanner(System.in);
        int firstNumber = Integer.parseInt((input.nextLine()));

        System.out.println("Enter Second Number: ");
        Scanner input2 = new Scanner(System.in);
        int secondNumber = Integer.parseInt((input2.nextLine()));

        AddNumbers addNumbers = new AddNumbers();
        Node firstNo = addNumbers.create(firstNumber);
        Node secondNo = addNumbers.create(secondNumber);

        LinkedList linkedList = new LinkedList();
        System.out.println("First Number ");
        //firstNo = linkedList.reverse(firstNo);
        linkedList.print(firstNo);
        System.out.println();
        System.out.println("Second Number ");
        secondNo = linkedList.reverse(secondNo);
        linkedList.print(secondNo);

        Node result = new Node();
        System.out.println("result is: ");
        result = addNumbers.addTwoNumbers(firstNo, secondNo);
        //result = linkedList.reverse(result);
        linkedList.print(result);






    }
}

