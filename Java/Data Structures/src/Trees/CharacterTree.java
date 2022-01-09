package Trees;

public class CharacterTree
{
    public static class Node {
        Character value;
        Node left;
        Node right;

        Node() {

        }

        Node(Character value) {
            this.value = value;
        }

        Node(Character value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
}
