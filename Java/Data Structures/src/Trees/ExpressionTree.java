package Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ExpressionTree
{
    static List<Character> result;
    private static CharacterTree.Node createExpressionTree(char[] postfixTree, int size)
    {
        Stack<CharacterTree.Node> stack = new Stack<>();

        for (int i = 0; i < size; i++) // (A+B)*C
        {
            char value = postfixTree[i];
            if (!isOperator(value))
            {
                CharacterTree.Node node = new CharacterTree.Node(value);
                stack.push(node);
            }
            else
            {
                CharacterTree.Node right = stack.pop();
                CharacterTree.Node left = stack.pop();
                CharacterTree.Node node = new CharacterTree.Node(value, left, right);
                stack.push(node);
            }
        }
        return stack.pop();
    }

    private static boolean isOperator(char character)
    {
        return character == '+' || character == '+' || character == '-' || character == '/' || character == '*';
    }

    public static List<Character> inorder(CharacterTree.Node root)
    {
        if (root != null)
        {
            inorder(root.left);
            result.add(root.value);
            inorder(root.right);
        }
        return result;
    }

    public static void main(String[] args)
    {
        System.out.println("creating a tree for expression :" +
                "(A+B)*C");

        char[] postfixTree = {'A', 'B', '+', 'C', '*'};
        CharacterTree.Node root = createExpressionTree(postfixTree,postfixTree.length);

        result = new ArrayList<>();
        System.out.println("Inorder Traversal for the Expression Tree is: " +
                inorder(root));
    }
}
