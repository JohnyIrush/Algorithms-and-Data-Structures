package com.softwarescares;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class ShortChainLength
{
    public static int shortestChainLength(String start, String target, Set<String> Dictionary)
    {
        if (start == target)
            return 0;

        if (!Dictionary.contains(target))
            return 0;

        int level = 0, wordLength = start.length();

        Queue<String> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty())
        {
            System.out.println("Level: " + level);
            level++;

            int sizeOfQueue = queue.size();

            for (int i = 0; i < sizeOfQueue; i++)
            {
                char []word = queue.peek().toCharArray();
                queue.remove();

                for (int position = 0; position < wordLength; position++)
                {
                    char original_character = word[position];

                    for (char character = 'a'; character <= 'z'; ++character)
                    {
                        word[position] = character;

                        if (String.valueOf(word).equals(target))
                            return level + 1;

                        if (!Dictionary.contains(String.valueOf(word)))
                        {
                            System.out.println("Jumping out of inner Loop: " + "word is: " + String.valueOf(word));
                            continue;
                        }

                        Dictionary.remove(String.valueOf(word));
                        System.out.println(word);
                        queue.add(String.valueOf(word));
                    }

                    System.out.println("Ended inner Loop");
                    word[position] = original_character;
                }
            }
        }

        return 0;
    }
}
