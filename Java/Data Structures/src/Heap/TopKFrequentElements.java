package Heap;

import java.util.*;


public class TopKFrequentElements
{
    public class Node implements Comparator<Node>
    {
        int number;
        int frequency;

        Node()
        {

        }
        Node(int number, int frequency)
        {
            number = number;
            frequency = frequency;
        }

        @Override
        public int compare(Node o1, Node o2) {
            return (o1.frequency < o2.frequency)? 1: 0;
        }
    }

    public List<Integer> topKFrequent(int[] numbers, int k)
    {
        //HashMap<Integer, Integer> hashMap = new HashMap<>();
        int[] array = new int[10];

        for (int element: numbers)
            array[element]++;

        for (int element: array)
            System.out.print(array[element]);


        PriorityQueue<Node> heap = new PriorityQueue<Node>(Collections.reverseOrder());

        for (int i = 0; i < array.length; i++)
            heap.add(new Node(i,array[i]));

        List<Integer> answer = new ArrayList<>();

        while (k != 0)
        {
            k--;
            answer.add(heap.poll().number);
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 1, 2, 1};
        TopKFrequentElements topKFrequentElements = new TopKFrequentElements();

        System.out.println(topKFrequentElements.topKFrequent(numbers, 2));

    }
}
