import java.util.Scanner;

public class InfixToPostfix
{
    char infix[], postfix[] = new char[100];

    private void infixToPostfix(char[] infixExpression)
    {
        StackTwo stack = new StackTwo();
        char symbol;
        int j = 0;
        int k = 0;

        for (int i = 0; i < infixExpression.length; i++)
        {
            symbol = infixExpression[i];
            switch (symbol)
            {
                case '(':
                    stack.push(String.valueOf(symbol));
                    break;
                case ')':
                    String next = stack.pop();
                    while (!stack.isEmpty() && next != String.valueOf('('))
                    {
                        this.postfix[j++] = next.toCharArray()[0];
                        k++;
                            next = stack.pop();
                    }
                    break;
                case '+':

                case '-':

                case '*':

                case '^':

                case '/':
                    while (!stack.isEmpty() && precedence(stack.top.data) >= precedence(String.valueOf(symbol)))
                        postfix[j++] = stack.pop().toCharArray()[0];
                    stack.push(String.valueOf(symbol));
                    break;
                default:
                    postfix[j++] = symbol;
                    k++;


            }
        }
        print(j);
    }

    public void print(int size)
    {
        for (int i = 0; i < size + 1; i++)
        {
            System.out.print(postfix[i]);
        }
    }
    private int precedence(String symbol)
    {

        switch (symbol)
        {
            case "^":
                return 3;
            case "/":
                return 2;
            case "*":
                return 2;
            case "-":
                return 1;
            default:
                return 0;
        }
    }


    public static void main(String[] args)
    {
        System.out.println("Enter the infix expression: ");
        Scanner input = new Scanner(System.in);
        char[] infixExpression = input.nextLine().toCharArray();

        InfixToPostfix infixToPostfix = new InfixToPostfix();
        infixToPostfix.infixToPostfix(infixExpression);

    }

}
