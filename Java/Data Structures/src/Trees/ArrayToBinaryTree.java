package Trees;

public class ArrayToBinaryTree
{
    public static Tree.Node arrayToBinaryTree(int[] array, int start, int end)
    {
        if (start > end)
            return null;

        int mid = (start + end)/2;
        Tree.Node root = new Tree.Node(array[mid]);
        root.left = arrayToBinaryTree(array, start, mid-1);
        root.right = arrayToBinaryTree(array,mid+1, end);
        return root;
    }

    public static void main(String[] args)
    {
        int[] array = {-10,-3,0,5,9};
        Tree.Node tree = arrayToBinaryTree(array, 0, array.length -1);
        System.out.println(Traversal.preorder(tree));
    }
}
