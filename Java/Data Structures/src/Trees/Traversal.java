package Trees;

import java.util.*;

public class Traversal
{
    static List<Integer> result = new ArrayList<>();

     static int fullNodes;
    static int halfNodes;
    static int leafNodes;

    public static List<Integer> preorder(Tree.Node root)
    {
        if (root != null)
        {
            result.add(root.value);
            preorder(root.left);
            preorder(root.right);
        }
        return result;
    }

    public static List<Integer> inorder(Tree.Node root)
    {
        if (root != null)
        {
            inorder(root.left);
            result.add(root.value);
            inorder(root.right);
        }
        return result;
    }

    public static List<Integer> postorder(Tree.Node root)
    {
        if (root != null)
        {
            postorder(root.left);
            postorder(root.right);
            result.add(root.value);
        }
        return result;
    }

    public static List<Integer> iterativePreorder(Tree.Node root)
    {
        Stack<Tree.Node> stack = new Stack<>();
        Tree.Node current = root; //[1,2,3,4,5,6,7]
        while (true)
        {
            while (current != null)
            {
                result.add(current.value);
                stack.push(current);
                current = current.left;
            }
            if (stack.isEmpty()) break;
            current = stack.pop();
            current = current.right;
        }
        return result;
    }

    public static List<Integer> iterativeInorder(Tree.Node root)
    {
        Stack<Tree.Node> stack = new Stack<>();
        Tree.Node current = root; //[1,2,3,4,5,6,7]
        while (true)
        {
            while (current != null)
            {
                stack.push(current);
                current = current.left;
            }
            if (stack.isEmpty()) break;
            current = stack.pop();
            result.add(current.value);
            current = current.right;
        }
        return result;
    }

    public static List<Integer> iterativepostorder(Tree.Node root)
    {
        Stack<Tree.Node> stack = new Stack<>();
        Tree.Node current = root; //[1,2,3,4,5,6,7]
        Tree.Node previous = null;
        
        while (true)
        {
            while (current != null)
            {
                stack.push(current);
                current = current.left;
            }
            if (stack.isEmpty()) break;
            while (current == null && !stack.isEmpty())
            {
                current = stack.peek();

                if (current.right == null || current.right == previous)
                {
                    result.add(current.value);
                    stack.pop();
                    previous = current;
                    current = null;
                }
                else
                    current = current.right;
            }
        }
        return result;
    }

    public static List<Integer> levelorder(Tree.Node root)
    {
        Queue<Tree.Node> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty())
        {
            //int size = queue.size();
            //while (size-- > 0)
            //{
                Tree.Node current = queue.remove();
                result.add(current.value);
                if (current.left != null)
                    queue.add(current.left);
                if (current.right != null)
                    queue.add(current.right);
            //}
        }
        return result;
    }
    
    public  static Tree.Node lowestCommonAncestor(Tree.Node p, Tree.Node q, Tree.Node root)
    {
        if (root == null)
            return null;

        if (root.equals(p) || root.equals(q))
            return root;

        Tree.Node left = lowestCommonAncestor(p, q, root.left);
        Tree.Node right = lowestCommonAncestor(p, q, root.right);

        if (left != null && right != null) return root;

        return (left != null)? left: right;
    }

    //public int[] countNodes =  {0,0,0};
    //int fullNodes, halfNodes, leafNodes;
    public static void countNodes(Tree.Node root)
    {
        if (root != null)
        {
            if (root.left != null && root.right != null)
            {
                //countNodes[0] = countNodes[0] + 1; System.out.print("1");
                fullNodes += 1;
            }
            else if (root.left != null || root.right != null)
            {
                //countNodes[1] = countNodes[1] + 1; System.out.print("2");
                halfNodes += 1;
            }
            else
            {
                //countNodes[2] = countNodes[2] + 1; System.out.print("3");
                leafNodes += 1;
            }

            countNodes(root.left);
            countNodes(root.right);
        }

    }


    public static void displayCounts()
    {
        System.out.print("fullNodes: " + fullNodes + " halfNodes: " + halfNodes + " leafNodes: " + leafNodes);
    }
    public static void main(String[] args)
    {
        /*
        Tree.Node left = new Tree.Node(2);
        Tree.Node right = new Tree.Node(3);
        Tree.Node root = new Tree.Node(1,left, right);

        left.left  = new Tree.Node(4);
        left.right = new Tree.Node(5);
        right.left = new Tree.Node(6);
        right.right = new Tree.Node(7);
         */

        Tree.Node left = new Tree.Node(2);
        Tree.Node right = new Tree.Node(3);
        Tree.Node root = new Tree.Node(1,left, right);

        left.right = new Tree.Node(4, new Tree.Node(6),new Tree.Node(7));
        right.right = new Tree.Node(5, null, right.right = new Tree.Node(8));



        // Recursive traversal
       //System.out.println(preorder(root));
       //System.out.println(inorder(root));
       //System.out.println(postorder(root));

        //System.out.println(iterativeInorder(root));
        //System.out.println(iterativePreorder(root));
        //System.out.println(iterativepostorder(root));
        //System.out.println(levelorder(root));
        //System.out.println(lowestCommonAncestor(left, right,root).value);
        countNodes(root);
        displayCounts();
    }

}
