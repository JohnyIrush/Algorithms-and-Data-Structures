import java.util.Scanner;

public class DecimalToBinary
{
    public Stack binaryToDecimal(int number)
    {
        Stack stack = new Stack();

        while(number != 0)
        {
            stack.pushTwo(number%2);
            number = number/2;
        }

        return stack;
    }
    public static void main(String[] args)
    {
        System.out.println("Enter Decimal number: ");
        Scanner input = new Scanner(System.in);
        int number = Integer.parseInt(input.nextLine());
        DecimalToBinary binary = new DecimalToBinary();
        Stack binaryStack = binary.binaryToDecimal(number);
        System.out.println(binaryStack.pop());
        System.out.println(binaryStack.pop());
        System.out.println(binaryStack.pop());
        System.out.println(binaryStack.pop());
        System.out.println(binaryStack.pop());
        System.out.println(binaryStack.pop());
        System.out.println(binaryStack.pop());
    }
}
