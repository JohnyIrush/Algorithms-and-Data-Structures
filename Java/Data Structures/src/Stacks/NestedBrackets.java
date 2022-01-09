import java.util.Scanner;

import static java.lang.System.exit;

public class NestedBrackets
{
    private static boolean check_balanced(char[] expression)
    {
        StackTwo stack = new StackTwo();
        for (int i = 0; i < expression.length; i++)
        {
            if (expression[i] == '[' || expression[i] == '{' || expression[i] == '(')
            {
                stack.push(String.valueOf(expression[i]));
            }
            if (expression[i] == ']' || expression[i] == '}' || expression[i] == ')')
            {
                if (stack.isEmpty())
                {
                    System.out.println("Right brackets are more than the left.");
                    return false;
                }
                else
                {
                    String temp = stack.pop();
                    if (!match_bracket(temp,String.valueOf(expression[i])))
                    {
                        System.out.println("Mismatched brackets.");
                        return false;
                    }
                }

            }
        }
        return true;
    }

    private static boolean match_bracket(String openningbracket, String closingbracket)
    {
        if (openningbracket == String.valueOf('[')  && closingbracket == String.valueOf(']'))
            return  true;
        if (openningbracket == String.valueOf('(') && closingbracket == String.valueOf(')'))
            return  true;
        if (openningbracket == String.valueOf('{') && closingbracket == String.valueOf('}'))
            return  true;

        return false;
    }

    public static void main(String[] args)
    {
        System.out.println("Enter the algebraic expression: ");
        Scanner input = new Scanner(System.in);
        char[] expression = input.nextLine().toCharArray();
        System.out.println(check_balanced(expression));
    }
}
