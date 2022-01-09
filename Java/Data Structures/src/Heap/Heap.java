package Heap;

import java.util.ArrayList;
import java.util.Scanner;

import static Heap.HeapSort.heapSort;

public class Heap
{
    static int[] heap = new int[1001];
    static ArrayList<MaximumSlidingWindow.Node> heapTwo;
    static int heapSize;
    public static void heapify(int[] heap, int current, int size)
    {
        int largest = current;
        int left = ((2*current) + 1); // left child
        int right = ((2*current) + 2); // rigth child

        if (left < size && heap[left] > heap[largest])
            largest = left;
        if (right < size && heap[right] > heap[largest])
            largest = right;
        if (largest != current)
        {
            swap(heap,current,largest);
            heapify(heap, largest, size);
        }

    }

    public static void swap(int[] heap, int rootIndex, int index)
    {
        int temp = heap[rootIndex];
        heap[rootIndex] = heap[index];
        heap[index] = temp;
    }

    public static int pop(int[] heap)
    {
        if (heapSize <= 0)
        {
            System.out.println("Underflow");
            return -1;
        }


        int current = 0;
        int popped = heap[0];
        heap[0] = heap[heapSize - 1];
        heapSize--;

        //--Max_heapify
        while (((2*current) + 1) < heapSize) // while we don't reach a leaf node
        {
            int child;
            if (((2*current) + 2) == heapSize) // we only have the leftchild
                child = ((2*current) + 1);
            else // If both left and right child are present, and find the largest of both
            {
                if (heap[((2*current) + 1) ] > heap[((2*current) + 2) ])
                    child = ((2*current) + 1);
                else
                    child = ((2*current) + 2);
            }

            if (heap[current] < heap[child])
            {
                swap(heap,child, current);
                current = child;
            }
            else
                break;
        }

        return popped;
    }

    public static int popNode(ArrayList<MaximumSlidingWindow.Node> heap)
    {
        if (heapSize <= 0)
        {
            System.out.println("Underflow");
            return -1;
        }


        int current = 0;
        MaximumSlidingWindow.Node popped = heap.get(0);
        heap.add(0,heap.get(heapSize - 1));
        heapSize--;

        //--Max_heapify
        while (((2*current) + 1) < heapSize) // while we don't reach a leaf node
        {
            int child;
            if (((2*current) + 2) == heapSize) // we only have the leftchild
                child = ((2*current) + 1);
            else // If both left and right child are present, and find the largest of both
            {
                if (heap.get(((2*current) + 1)).value > heap.get(((2*current) + 2)).value)
                    child = ((2*current) + 1);
                else
                    child = ((2*current) + 2);
            }

            if (heap.get(current).value < heap.get(child).value)
            {
                swapNode(heap,child, current);
                current = child;
            }
            else
                break;
        }

        return popped.value;
    }

    private static void show()
    {
        for (int i = 0;i < heapSize; ++i)
            System.out.print(heap[i]);
    }
    private static void push(int value)
    {
        if (heapSize >= 1001)
        {
            System.out.println("Overflow");
            return;
        }
        heap[heapSize] = value;
        int current = heapSize;

        while (current > 0 && heap[(current-1)/2] < heap[current])
        {
            swap(heap, ((current- 1)/2),current);
            current = (current - 1)/2;
        }
        heapSize++;
    }

    public static void pushNode(MaximumSlidingWindow.Node node)
    {
        if (heapSize >= 1001)
        {
            System.out.println("Overflow");
            return;
        }
        heapTwo.add(heapSize,node);
        int current = heapSize;

        while (current > 0 && heapTwo.get((current-1)/2).value < heapTwo.get(current).value)
        {
            swapNode(heapTwo, ((current- 1)/2),current);
            current = (current - 1)/2;
        }
        heapSize++;
    }

    public static void swapNode(ArrayList<MaximumSlidingWindow.Node> heapTwo, int rootIndex, int index)
    {
        MaximumSlidingWindow.Node temp = heapTwo.get(rootIndex);
        heapTwo.add(rootIndex,heapTwo.get(index));
        heapTwo.add(index,temp);

    }

    public static void main(String[] args)
    {
        while (true)
        {
            System.out.println("1:Push...2:Pop...3:Show Heap...4:Terminate");
            int option;
            int element;

            Scanner input = new Scanner(System.in);
            option = Integer.parseInt(input.nextLine());

            switch (option)
            {
                case 1:
                    System.out.println("Enter Element: ");
                    element = Integer.parseInt(input.nextLine());
                    push(element);
                    break;
                case 2:
                    System.out.println("Popped " + pop(heap));
                    break;
                case 3:
                    show();
                    break;
                default:
                    return;
            }
        }
    }

}
