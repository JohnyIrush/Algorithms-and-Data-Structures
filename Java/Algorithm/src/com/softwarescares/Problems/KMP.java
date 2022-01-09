package com.softwarescares;

public class KMP
{
    public void kmp(String string, String pattern)
    {
        int M = pattern.length();
        int N = string.length();

        // create lps[] that will hold the longest
        // prefix suffix values for pattern
        int lps[] = new int[M];
        int j = 0; // index for pattern[]

        // Preprocess the pattern (calculate lps[]
        // array)
        createLPS(pattern, M, lps);

        int i = 0;

        while (i < N)
        {
            if (pattern.charAt(j) == string.charAt(i))
            {
                j++;
                i++;
            }
            if (j == M)
            {
                System.out.println("Found pattern "
                        + "at index " + (i - j));
                j = lps[j - 1];
            }

            // mismatch after j matches
            else if (i < N && pattern.charAt(j) != string.charAt(i))
            {
                // Do not match lps[0..lps[j-1]] characters,
                // they will match anyway
                if (j != 0)
                    j = lps[j - 1];
                else
                    i = i + 1;
            }
        }

    }

    public void createLPS(String pattern, int m, int[] lps)
    {
        // length of the previous longest prefix suffix
        int len = 0;
        int i = 1;
        lps[0] = 0; // lps[0] is always 0

        // the loop calculates lps[i] for i = 1 to M-1
        while (i < m)
        {
            if (pattern.charAt(i) == pattern.charAt(len))
            {
                len++;
                lps[i] = len;
                i++;
            }
            else // (pat[i] != pat[len])
            {
                // This is tricky. Consider the example.
                // AAACAAAA and i = 7. The idea is similar
                // to search step.
                if (len != 0) {
                    len = lps[len - 1];

                    // Also, note that we do not increment
                    // i here
                }
                else // if (len == 0)
                {
                    lps[i] = len;
                    i++;
                }
            }
        }
    }
    /*
    public Boolean kmp(String string, String pattern)
    {
        for (int i = 0; i < string.length(); i++)
        {
            int j = 0;
            for (;j < pattern.length(); j++)
            {
                int stringPointer = i;
                if (match(stringPointer, j,string, pattern))
                {
                    stringPointer++;
                    if (stringPointer == pattern.length())
                        return true;
                }
            }
            j = 0;
        }
        return false;
    }

    public Boolean match(int stringIndex, int patternIndex,String string, String pattern)
    {
        if(pattern.toCharArray()[patternIndex] == string.toCharArray()[stringIndex]) return true;
        return false;
    }
     */
}
