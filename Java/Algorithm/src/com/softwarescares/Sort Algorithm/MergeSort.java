package com.softwarescares;

public class MergeSort
{
    public static void mergeSort(int[] inputArray)
    {
        int inputLength = inputArray.length;

        if (inputLength < 2) // Array has only one element
            return;

        int midIndex = inputLength / 2;

        // Divide Array into two - Smaller sub-problems
        int[] leftHalf = new int[midIndex];
        int[] rightHalf = new int[inputLength - midIndex];

        for (int i = 0; i < midIndex; i++)
        {
            leftHalf[i] = inputArray[i];
        }


        for (int i = midIndex; i < inputLength; i++)
        {
            rightHalf[i - midIndex] = inputArray[i];
        }

        //-- Merge sort Recursively

        mergeSort(leftHalf);
        mergeSort(rightHalf);

        //merge
        merge(inputArray, leftHalf, rightHalf);
    }

    private static void merge(int[] inputArray, int[] leftHalf, int[] rightHalf)
    {
      int leftSize = leftHalf.length;
      int rightSize = rightHalf.length;

      int i = 0, j = 0, k = 0;

      while (i < leftSize && j < rightSize)
      {
          if (leftHalf[i] <= rightHalf[j])
          {
            inputArray[k] = leftHalf[i];
            i++;
          }
          else
          {
              inputArray[k] = rightHalf[j];
              j++;
          }
          k++;
      }
      while (i <  leftSize)
      {
          inputArray[k] = leftHalf[i];
          i++;
          k++;
      }

      while (j <  rightSize)
      {
          inputArray[k] = rightHalf[j];
          j++;
          k++;
      }

    }
}
