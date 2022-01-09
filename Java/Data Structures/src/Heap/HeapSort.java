package Heap;

public class HeapSort extends Heap
{
    public static int[] heapSort(int[] heap)
    {
        for(int i = (heap.length/2) - 1; i >= 0; i--)
            heapify(heap, i, heap.length);


        for (int i = heap.length - 1; i > 0; --i)
        {
            swap(heap,0, i);
            heapify(heap,0, i);
        }

        return heap;
    }


    public static void main(String[] args)
    {
        int[] heap = {9,6,8,2,1,4,3};
        heap = heapSort(heap);

        System.out.println("Heap in Ascending Order is: ");
        for (int i = 0;i < heap.length; ++i)
            System.out.print(heap[i]);
    }
}
