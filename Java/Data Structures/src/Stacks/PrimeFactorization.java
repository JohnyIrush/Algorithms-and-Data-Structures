public class PrimeFactorization
{
    public Stack prime_fact(int number)
    {
        int i = 2;
        Stack stack = new Stack();
        while(number != 1)
        {
            while(number % i == 0)
            {
                stack.pushTwo(i);
                number = number / i;
            }
            i++;
        }

        return stack;
    }

    public static void main(String[] args)
    {
        Stack stack = new PrimeFactorization().prime_fact(450);
        System.out.println(stack.isEmpty());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
