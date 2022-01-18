package HashTables;

import java.util.HashSet;
import java.util.Set;

public class possibleSums
{
    int solution(int[] coins, int[] quantity)
    {
        Set<Integer> set = new HashSet<>();

        set.add(0);

        for (int i = 0; i < coins.length; i++)
        {
            Set<Integer> next = new HashSet<>();

            for (int prev: set)
            {
                for (int j = 1; j <= quantity[i]; j++)
                {
                    next.add(prev + (j * coins[i]));
                }
            }
            set.addAll(next);
        }

        return set.size() - 1;
    }
}
