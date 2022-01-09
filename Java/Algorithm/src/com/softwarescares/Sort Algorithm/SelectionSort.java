package com.softwarescares;

public class SelectionSort<T extends  Comparable<T>>
{
    private final T[] array;

    SelectionSort(T[] array)
    {
        this.array = array;
    }

    public void sort()
    {
        for (int i = 0; i < array.length; i++) // [90,54,-1,1,7,77]
        {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++)
            {
                if (array[j].compareTo(array[minIndex]) < 0)
                    minIndex = j;
            }
            swap(minIndex, i);
        }
    }

    void swap(int minIndex, int index)
    {
        if (minIndex != index)
        {
            T temp = array[index];
            array[index] = array[minIndex];
            array[minIndex] = temp;
        }
    }
}
