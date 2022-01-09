public class StackTwo
{
    Node top = null;
    class Node
    {
        String data;
        Node link;
    }

    public void push(String data)
    {
        Node node = new Node();

        node.data = data;
        node.link = null;

        node.link = top;
        top = node;
    }

    public String pop()
    {
        Node output = top;
        top = top.link;
        return output.data;
    }

    public boolean isEmpty()
    {
        return (top == null)? true: false;
    }

    public static void main(String[] args)
    {
        StackTwo stack = new StackTwo();
        stack.push("10");
        //stack.push(30);
        //stack.push(70);
        //stack.push(90);
        //System.out.println(stack.pop());
        //System.out.println(stack.pop());
        //System.out.println(stack.pop());
    }
}
