package Trees;

public class Tree
{
    public static class Node extends CharacterTree.Node {
        int value;
        Node left;
        Node right;

        Node()
        {

        }

        Node(int value)
        {
            this.value = value;
        }

        Node(int value, Node left, Node right)
        {
            this.value = value;
            this.left = left;
            this.right = right;
        }


        @Override
        public boolean equals(Object object)
        {
            return this.value == ((Node) object).value;
        }
    }
}
