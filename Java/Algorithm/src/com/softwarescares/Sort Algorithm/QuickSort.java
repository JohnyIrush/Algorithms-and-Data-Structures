package com.softwarescares;

import java.util.Random;

public class QuickSort
{
    public static void quickSort(int[] array)
    {
        quickSort(array, 0, array.length - 1);
    }
    public static void quickSort(int[] array,int lowIndex, int highIndex)
    {
        if (lowIndex >= highIndex)
            return;

        int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex; // Select Pivot index to get
        // best performance on average

        int pivot = array[pivotIndex]; //get the pivot element using the pivot Index
        swap(array, pivotIndex, highIndex); // set the pivot at the last position of the array

        int leftPointer = partition(array, lowIndex, highIndex, pivot); // Partition the array,
        // move all the elements greater than the pivot to the right and move all elements less
        // than pivot to the left

        quickSort(array, lowIndex, leftPointer - 1);
        quickSort(array, leftPointer + 1, highIndex);
    }


    private static void swap(int[] array, int index1, int index2)
    {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    private static int partition(int[] array, int lowIndex, int highIndex, int pivot)
    {
        int leftPointer = lowIndex;
        int rightPointer = highIndex;

        while (leftPointer < rightPointer) // Until partition is complete
        {
            while (array[leftPointer] <= pivot && leftPointer < rightPointer)
            {
                leftPointer++;
            }

            while (array[rightPointer] >= pivot && leftPointer < rightPointer)
            {
                rightPointer--;
            }
            swap(array, leftPointer, rightPointer);
        }
        swap(array, leftPointer, highIndex); // Move pivot between the left and right elements

        return leftPointer;
    }
}
