package HashTable;
import java.util.ArrayList;
import java.util.Arrays;

public class HashTables
{
    String[] theArray;
    int arraySize;
    int itemsInArray = 0;

    HashTables(int size)
    {
        arraySize = size;
        theArray = new String[size];
        Arrays.fill(theArray,"-1");
    }

    public void hashFunctionOne(String[] strings, String[] theArray)
    {
        for (int n = 0; n < strings.length; n++)
        {
            String newElementVal = strings[n];
            theArray[Integer.parseInt(newElementVal)] = newElementVal;
        }
    }

    public void hashFunctionTwo(String[] strings, String[] theArray)
    {
        for (int i = 0; i < strings.length; i++)
        {
            String newElement = strings[i];

            int arrayIndex = Integer.parseInt(newElement) % arraySize;

            // System.out.println("Modulus Index= " + arrayIndex + " for value " + newElement);


            while (theArray[arrayIndex] != "-1")
            {
                ++arrayIndex;
                System.out.println("Collition Try " + arrayIndex + " Instead");
                arrayIndex %= arraySize;
            }

            theArray[arrayIndex] = newElement;
        }
    }

    public void doubleHashFunction(String[] strings, String[] theArray)
    {
        for (int i = 0; i < strings.length; i++)
        {
            String newElement = strings[i];

            int arrayIndex = Integer.parseInt(newElement) % arraySize;

            int stepDistance = 5 - (Integer.parseInt(newElement) % 5);

            //System.out.println("Modulus Index= " + arrayIndex + " for value " + newElement);


            while (theArray[arrayIndex] != "-1")
            {
                arrayIndex += stepDistance;
                System.out.println("Collition Try " + arrayIndex + " Instead");
                arrayIndex %= arraySize;
            }

            theArray[arrayIndex] = newElement;
        }
    }


    public String findKey(String key)
    {
        int arrayIndexHash = Integer.parseInt(key) % arraySize;

        int stepDistance = 5 - (Integer.parseInt(key) % 5);

        while (theArray[arrayIndexHash] != "-1")
        {
            if (theArray[arrayIndexHash] == key)
            {
                System.out.println(key + " was Found in Index " + arrayIndexHash);
                return theArray[arrayIndexHash];
            }
            arrayIndexHash += stepDistance;



        }

        return null;
    }

    public String findKeyDoubleHash(String key)
    {
        int arrayIndexHash = Integer.parseInt(key) % arraySize;

        while (theArray[arrayIndexHash] != "-1")
        {
            if (theArray[arrayIndexHash] == key)
            {
                System.out.println(key + " was Found in Index " + arrayIndexHash);
                return theArray[arrayIndexHash];
            }
            arrayIndexHash++;



        }

        return null;
    }

    public boolean isPrime(int number)
    {
        if (number % 2 == 0)
            return false;
        for (int i = 3; i * i <= number; i+=2)
        {
            if (number % i == 0)
                return false;
        }
        return true;
    }

    public int getNextPrime(int minNumberToCheck)
    {
        for (int i = minNumberToCheck; true; i++)
        {
            if (isPrime(i))
                return i;
        }
    }

    public void increaseArraySize(int minArraySize)
    {
        int newArraySize = getNextPrime(minArraySize);
        moveOldArray(newArraySize);
    }

    private void moveOldArray(int newArraySize)
    {
        String[] cleanArray = removeEmptySpacesInArray(theArray);
        theArray = new String[newArraySize];

        arraySize = newArraySize;

        fillArrayWithNeg1();
        hashFunctionTwo(cleanArray, theArray);
    }

    private void fillArrayWithNeg1()
    {
        Arrays.fill(theArray, "-1");
    }

    private String[] removeEmptySpacesInArray(String[] theArray)
    {
        ArrayList<String> stringList = new ArrayList<String>();

        for (String theString : theArray)
            if (!theString.equals("-1") && !theString.equals(""))
                stringList.add(theString);

        return stringList.toArray(new String[stringList.size()]);
    }

    public void displayHashTable(String[] elements, String[] theArray)
    {
        int count = 0;
        for (int i = 0; i < theArray.length; i++)
        {
            count++;
            System.out.print(theArray[i] != "-1"? "|"+theArray[i]+"|": "   " +"|");

            if (count == 10)
            {
                System.out.println();
                count = 0;
            }
        }
        System.out.println();
    }



    public static void main(String[] args)
    {
        HashTables hashTables = new HashTables(31);
        //String[] elements = {"1","2","4","21","26"};
        //hashTables.hashFunctionOne(elements, hashTables.theArray);

        //String[] elements = {"12","92","103","409","60","5","8","9","4","7","125","752","666","620","54","44",
        //        "111","22","334","40","69","57","81","99","43","732","577","551","621","578"};
        //hashTables.hashFunctionTwo(elements, hashTables.theArray);
        //hashTables.displayHashTable(elements, hashTables.theArray);
        //hashTables.findKey("111");

        String[] elements = {"120","92","103","409","60","510","840","9","4","7","125","752","666","620","54","44",
                "111","22","334","40","69","57","81","99","43","900","577","551","621","578"};

        hashTables.hashFunctionTwo(elements, hashTables.theArray);

        hashTables.increaseArraySize(60);
        hashTables.displayHashTable(elements, hashTables.theArray);

        hashTables.fillArrayWithNeg1();
        hashTables.doubleHashFunction(elements, hashTables.theArray);

        hashTables.displayHashTable(elements, hashTables.theArray);


    }


}
