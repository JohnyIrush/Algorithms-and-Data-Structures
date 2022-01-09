package com.softwarescares;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class JumpingNumbers
{

    public void bfs(int x, int num)
    {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(num);


        while (!queue.isEmpty())
        {
            num = queue.poll();

            if (num <= x)
            {
                System.out.print(num + " ");
                int last_digit = num % 10;

                if (last_digit == 0)
                {
                    queue.add((num * 10) + (last_digit + 1));
                }
                else if (last_digit == 9)
                {
                    queue.add((num * 10) + (last_digit - 1));
                }
                else
                {
                    queue.add((num * 10) + (last_digit - 1));
                    queue.add((num * 10) + (last_digit + 1));
                }
            }
        }
    }

    public void printJumpingNumbers(int x)
    {
        System.out.print("0 ");

        for (int i = 1; i <= 9 && i <= x ; i++)
        {
            this.bfs(x, i);
        }
    }
}
