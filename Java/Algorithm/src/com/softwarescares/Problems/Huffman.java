package com.softwarescares;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Huffman
{
    /*
    private Node root;
    private final String text;
    private Map<Character, Integer> charFrequencies;
    private final Map<Character, String> huffmanCodes;

    public Huffman(String text)
    {
        this.text = text;
        fillCharFrequenciesMap();
        huffmanCodes = new HashMap<>();
    }

    private void fillCharFrequenciesMap()
    {
        for (char character : text.toCharArray())
        {
            Integer integer = charFrequencies.get(character);
            charFrequencies.put(character, integer != null ? integer + 1 : 1);
        }
    }

    public String encode()
    {
        Queue<Node> queue = new PriorityQueue<>();
        charFrequencies.forEach((character, frequecy) ->
                queue.add(new Leaf(character, frequecy)));

        while (queue.size() > 1)
        {
            queue.add(new Node(queue.poll(), queue.poll()));
        }
        generateHuffmanCodes(root = queue.poll(), "");
        return getEncodedText();
    }

    public String decode()
    {
        StringBuilder sb = new StringBuilder();
        Node current = root;
        for (char character : getEncodedText().toCharArray())
        {
            current = character == '0' ? current.getLeftNode() : current.getRightNode();
            if (current instanceof Leaf)
            {
                sb.append(((Leaf) current).getCharacter());
                current = root;
            }
        }
        return sb.toString();
    }

    private void generateHuffmanCodes(Node node, String code)
    {
        if (node instanceof Leaf)
        {
            huffmanCodes.put(((Leaf) node).getCharacter(), code);
        }
        generateHuffmanCodes(node.getLeftNode(), code.concat("0"));
        generateHuffmanCodes(node.getRightNode(), code.concat("1"));
    }

    private String getEncodedText()
    {
        StringBuilder sb = new StringBuilder();
        for (char character : text.toCharArray())
        {
            sb.append(huffmanCodes.get(character));
        }
        return sb.toString();
    }
    //-- Node
    @Getter
    @RequiredArgsConstructor
    class Node implements Comparable<Node>
    {
        private final int frequency;
        private Node leftNode;
        private Node rightNode;

        public Node(Node leftNode, Node rightNode)
        {
            this.frequency = leftNode.frequency + rightNode.frequency;
            this.leftNode = leftNode;
            this.rightNode = rightNode;
        }

        @Override
        public int compareTo(Node node)
        {
            return Integer.compare(frequency, node.getFrequency());
        }

        public int getFrequency()
        {
            return frequency;
        }

        public Node getLeftNode()
        {
            return leftNode;
        }

        public void setLeftNode(Node leftNode) {
            this.leftNode = leftNode;
        }

        public Node getRightNode()
        {
            return rightNode;
        }

        public void setRightNode(Node rightNode)
        {
            this.rightNode = rightNode;
        }
    }

    //-- Node leaf
    @Getter
    @EqualsAndHashCode(callSuper = true)
    public class Leaf extends Node
    {
        private final char character;
        public Leaf(char character, int frequency)
        {
            super(frequency);
            //super(frequency);
            this.character = character;
        }

        public char getCharacter() {
            return character;
        }
    }

*/

}
