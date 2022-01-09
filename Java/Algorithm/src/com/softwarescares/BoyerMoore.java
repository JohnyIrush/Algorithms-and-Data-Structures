package com.softwarescares;

public class BoyerMoore
{
    // Function to find majority element
    public static int findMajority(int[] numbers)
    {
        int count = 0, candidate = -1;
        for (int i = 0; i < numbers.length; i++) // { 1, 1, 1, 1, 2, 3, 4 };
        {
            if (count == 0)
            {
                candidate = numbers[i];
                count = 1;
            }
            else
            {
                if (numbers[i] == candidate)
                    count++;
                else
                    count--;
            }
        }

        // Checking if majority candidate occurs more than
        // n/2 times
        return chechMajority(candidate, numbers);
    }

    private static int chechMajority(int candidate, int[] numbers)
    {
        int count = 0;
        for (int i = 0; i < numbers.length; i++)
        {
            if (numbers[i] == candidate)
                count++;
        }
        if (count > (numbers.length / 2))
            return candidate;
        return -1;
    }

    public static void main(String[] args)
    {
        int array[] = { 1, 1, 1, 1, 2, 3, 4 };
        int majority = findMajority(array);
        System.out.println(" The majority element is : "
                + majority);
    }

}
