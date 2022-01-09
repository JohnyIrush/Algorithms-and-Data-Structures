package com.softwarescares;

public class Kadanes
{
    int[] array;

    public Kadanes(int[] array)
    {
        this.array = array;
    }

    public int largeSumSubArray()
    {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;

        for (int i = 0; i < array.length; i++)
        {
            currentSum += array[i];
            if (currentSum < array[i])
                currentSum = array[i];
            if (maxSum < currentSum)
                maxSum = currentSum;
        }

        return maxSum;
    }
}
