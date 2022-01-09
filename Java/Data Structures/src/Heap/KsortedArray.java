package Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class KsortedArray
{
    public static void kSort(int[] array, int length, int k)
    {
        PriorityQueue<Integer> min_heap = new PriorityQueue<Integer>();

        int index = 0;

        for (int i = k + 1; i < length; i++) // {2,6,3,12,56,8};
        {
            array[index++] = min_heap.poll();
            min_heap.add(array[i]);
        }

        while (!min_heap.isEmpty())
            array[index++] = min_heap.poll();
    }

    public static void printArray(int[] array, int length)
    {
        for (int i = 0; i < length; i++)
            System.out.print(array[i]);
    }

    public static void main(String[] args)
    {
        int k = 3;
        int array[] = {2,6,3,12,56,8};

        kSort(array, array.length, k);

        System.out.println("Following is sorted array");
        printArray(array, array.length);
    }
}
