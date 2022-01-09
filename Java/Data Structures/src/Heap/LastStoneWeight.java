package Heap;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class LastStoneWeight
{
    public static int lastStoneWeight(int[] stones)
    {
        PriorityQueue<Integer> max_heap = new PriorityQueue<Integer>(Collections.reverseOrder());

        int number = stones.length;

        for (int i = 0; i < number; i++)
            max_heap.add(stones[i]);

        int first, second;

        while (number > 1)
        {
            first = max_heap.poll();
            second = max_heap.poll();
            number -= 2;

            if (first - second > 0)
            {
                max_heap.add(first - second);
                number += 1;
            }
        }
        if (!max_heap.isEmpty())
            return max_heap.poll();
        return 0;
    }

    public static void main(String[] args)
    {
        int[] stones = {2,7,4,10};
        System.out.println(lastStoneWeight(stones));
    }
}
