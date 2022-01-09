import static java.lang.System.exit;

public class Stack
{
    private int MAX = 100;
    private int[] stack = new int[MAX];
    private int top = -1;
    
    public void push(int data)
    {
        if (top == MAX - 1)
        {
            System.out.println("Stack Overflow");
            return;
        }
        top++;
        stack[top] = data;
    }
    
    public int pop()
    {
        if (top == -1)
        {
            System.out.println("Stack Underflow");
           exit(1);
        }
        int output = stack[top];
        top--;
        return output;
    }

    public boolean isFull()
    {
        return (top == MAX - 1)? true: false;
    }

    public boolean isEmpty()
    {
        return (top == -1)? true: false;
    }

    public void pushTwo(int data)
    {
        top++;
        for (int i = top; i > 0; i--)
            stack[i] = stack[i-1];

        stack[0] = data;

    }

    public int popTwo()
    {
        if (top == -1)
        {
            System.out.println("Stack Underflow");
            exit(1);
        }
        int output = stack[0];
        top--;
        return output;
    }
    public static void main(String[] args)
    {
        Stack stack = new Stack();
        stack.pushTwo(1);
        stack.pushTwo(10);
        stack.pushTwo(500000);
        stack.pushTwo(1200000);
        // System.out.println(stack.pop());
        // System.out.println(stack.pop());
        // System.out.println(stack.pop());
        System.out.println(stack.popTwo());
        //System.out.println(stack.isFull());
    }
}
