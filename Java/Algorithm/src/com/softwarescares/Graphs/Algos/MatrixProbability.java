package com.softwarescares;

public class MatrixProbability
{
    public static boolean isSafe(int x, int y, int m, int n)
    {
        return  (x >= 0 && x < m && y >= 0 && y < n);
    }

    public static double findProbability(int m, int n, int x, int y, int N)
    {
        if (! isSafe(x, y, m, n))
            return 0.0;

        if (N == 0)
            return 1.0;

        double prob = 0.0;


        prob += findProbability(m, n, x - 1, y, N - 1) * 0.25; // Move up

        prob += findProbability(m, n, x, y + 1, N - 1) * 0.25; // Move Right

        prob += findProbability(m, n, x + 1, y, N - 1) * 0.25; // Move down

        prob += findProbability(m, n, x, y - 1, N - 1) * 0.25; // Move Left

        return prob;
    }
}
