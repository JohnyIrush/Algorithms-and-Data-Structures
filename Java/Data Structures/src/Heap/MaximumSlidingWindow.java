package Heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

import static Heap.Heap.*;

public class MaximumSlidingWindow
{
    public class Node implements Comparable
    {
        int index;
        int value;

        Node()
        {

        }
        Node(int index, int value)
        {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(Object o) {
            return (this.value < ((Node) o).value)? 1: 0;
        }
    }

    public List<Integer> maximumSlidingWindow(int[] numbers, int k)
    {
        ArrayList<MaximumSlidingWindow.Node> heap = new ArrayList<>(10);
        List<Integer> maxWindows = new ArrayList<>();

        for (int i = 0; i < numbers.length; ++i)
        {
            while (heap.size() != 0 && heap.get(0).index <= (i - k))
                popNode(heap);
            pushNode((new Node(i, numbers[i])));
            if (i >= (k - 1))
                maxWindows.add(heap.get(0).value);
        }
        return maxWindows;
    }

    public static void main(String[] args)
    {
        int[] numbers = {1,3,-1,-3,5};
        MaximumSlidingWindow maximumSlidingWindow =  new MaximumSlidingWindow();
        System.out.println(maximumSlidingWindow.maximumSlidingWindow(numbers, 3));
    }
}

