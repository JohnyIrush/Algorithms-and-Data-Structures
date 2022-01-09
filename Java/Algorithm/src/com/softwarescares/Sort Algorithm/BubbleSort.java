package com.softwarescares;

public class BubbleSort
{
    public void sort(int[] array)
    {
        for (int i = 0; i < array.length; i++)
        {
            for (int j = i + 1; j < array.length; j++)
            {
                if (array[i] > array[j])
                    swap(i, j, array);
            }
        }
    }

    public void swap(int index1, int index2, int[] array)
    {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
