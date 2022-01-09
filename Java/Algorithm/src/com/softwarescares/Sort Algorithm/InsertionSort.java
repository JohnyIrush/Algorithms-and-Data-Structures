package com.softwarescares;

public class InsertionSort
{
    public static void sort(int[] array)
    {
        for (int i = 1; i < array.length; i++) // {8,2,4,1,3}
        {
            var current = array[i];
            var j = i - 1;

            while (j >= 0 && array[j] > current)
            {
                array[j +  1] = array[j];
                j--;
            }
            array[j +  1] = current;
        }
    }
}
