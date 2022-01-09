package com.softwarescares;

public class Euclidean
{
    public int gcd(int a, int b)
    {
        return euclidean(a, b);
    }

    public int euclidean(int a, int b)
    {
        if (b == 0)
            return a;

        return gcd(b, a%b);
    }
}
