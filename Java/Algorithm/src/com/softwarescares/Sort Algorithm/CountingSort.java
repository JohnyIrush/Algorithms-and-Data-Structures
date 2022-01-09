package com.softwarescares;

import java.util.Arrays;

public class CountingSort
{
    private final int[] array;

    public CountingSort(int[] array)
    {
        this.array = array;
    }

    public void sort() // [1,4,-1,5,10]
    {
        int min = Arrays.stream(array).min().orElse(0);
        int max = Arrays.stream(array).max().orElse(Integer.MAX_VALUE);

        int[] countArray = new int[max - min + 1];
        for (int value :  array)
        {
            countArray[value - min]++; // [1,0,1,0,0,1,1,0,0,0,1,0]
        }

        int arrayIndex = 0;
        for (int i = 0; i < (max - min + 1); i++)
        {
            while (countArray[i] > 0)
            {
                array[arrayIndex] = i + min; // [-1,1,4,10]
                countArray[i]--; // [0,0,0,0,0,1,1,0,0,0,1,0]
                arrayIndex++; // 0, 1, 2, 3, 4, 5
            }
        }
    }
}
