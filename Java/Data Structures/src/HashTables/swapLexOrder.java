package HashTables;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class swapLexOrder
{
    String solution(String str, int[][] pairs)
    {
        Map<Integer, Set<Integer>> map = new HashMap<>();

        for(int[] edge: pairs)
        {
            int u = edge[0];
            int v = edge[1];

            map.putIfAbsent(u, new HashSet<Integer>());
            map.putIfAbsent(v, new HashSet<Integer>());

            map.get(u).add(v);
            map.get(v).add(u);
        }

        print(map,pairs);
        return null;
    }

    void print(Map<Integer, Set<Integer>> map, int[][] pairs)
    {
        for (int i = 0; i < pairs.length; i++)
        {
            for (int j = 0; j < pairs[i].length; j++)
            {
                System.out.println(pairs[i][j] + "->");
                Object[] nodes = map.get(pairs[i][j]).toArray();
                for (int k = 0; k < nodes.length; k++)
                {
                    System.out.print("->");
                    System.out.print(nodes[k]);
                }
            }
        }
    }

    public static void main(String[] args)
    {
        swapLexOrder swapLexOrder = new swapLexOrder();

        String str = "abdc";

        int[][] pairs = {{1,4},{3,4}};

        swapLexOrder.solution(str, pairs);
    }
}
