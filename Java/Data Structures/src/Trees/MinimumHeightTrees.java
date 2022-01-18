package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinimumHeightTrees
{
    public List<Integer> findMinHeightTrees(int n, int[][] edges)
    {
        List<Integer> result = new ArrayList<>();

        if (n <= 0) return result;

        if(n == 1)
        {
            result.add(0);
            return result;
        }

        int degree[] = new int[n];
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++)
        {
          adj.add(new ArrayList<>());
        }

        for (int[] e: edges)  //[[1,0],[1,2],[1,3]] [1,3,1,1]
        {
            degree[e[0]]++;
            degree[e[1]]++;
            adj.get(e[1]).add(e[0]); // ["0" => 1,"1" => [0,2,3], "2" => 1, "3" => 1]
            adj.get(e[0]).add(e[1]);
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++)
        {
            if (degree[i] == 1)
                queue.add(i);
        }

        while (n > 2)
        {
            int size = queue.size();
            n -= size;

            while (size --> 0)
            {
                int v = queue.poll();

                for (int  i: adj.get(v))
                {
                    degree[i]--;
                    if (degree[i] == 1)
                        queue.add(i);
                }
            }
        }
        result.addAll(queue);
        return result;
    }
}
