package HashTable;
public class HashTable
{
    private HashNode[] buckets;
    private int numberOfBuckets; // capacity
    private int size; // Number of hashnodes

    public HashTable()
    {
        this(10);
    }

    public HashTable(int capacity)
    {
        this.numberOfBuckets = capacity;
        this.buckets = new HashNode[numberOfBuckets];
        this.size = 0;
    }

    public class HashNode
    {
        private Integer key; // can be generic type
        private String value; // can be generic type
        private HashNode next; // reference to the next HashNode

        public HashNode(Integer key, String value)
        {
            this.key = key;
            this.value = value;
        }
    }

    public int size()
    {
        return size;
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    public void put(Integer key, String value)
    {
        int bucketIndex = getBucketIndex(key);
        HashNode head = buckets[bucketIndex];
        while (head != null)
        {
            if (head.key.equals(key))
            {
                head.value = value;
                return;
            }
            head = head.next;
        }
        size++;
        head = buckets[bucketIndex];
        HashNode node = new HashNode(key, value);
        node.next = head;
        buckets[bucketIndex] = node;
    }

    private int getBucketIndex(Integer key)
    {
        return key % numberOfBuckets;
    }

    public String get(Integer key)
    {
        int bucketIndex = getBucketIndex(key);
        HashNode head = buckets[bucketIndex];
        while (head != null)
        {
            if (head.key.equals(key))
            {
                System.out.println(head.value);
            }
            head = head.next;
        }
        return null;
    }

    public String remove(Integer key)
    {
        return null;
    }

    public static void main(String[] args)
    {
        HashTable table = new HashTable(10);
        table.put(105,"Tom");
        table.put(21, "Sana");
        table.put(1, "Johny");
        System.out.println(table.size());
        System.out.println(table.get(1));
    }
}
