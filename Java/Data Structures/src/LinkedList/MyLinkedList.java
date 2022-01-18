package LinkedList;

    public class MyLinkedList
    {
        public class Node
        {
            public Node next;
            public int val;

            public Node(int v)
            {
                this.val = v;
            }

            public Node(int v, Node next)
            {
                this.val = v;
                this.next = next;
            }
        }

        private Node head;

        /// <summary>
        /// Initialize your data structure here.
        /// </summary>
        public MyLinkedList()
        {

        }

        /// <summary>
        /// Get the value of the index-th node in the linked list.
        /// If the index is invalid, return -1.
        /// </summary>
        /// <param name="index">index of the node to be returned</param>
        /// <returns>value at the given index</returns>
        public int Get(int index)
        {
            if (this.head == null)
            {
                return -1;
            }

            Node temp = this.head;
            int curr = 0;

            while (curr < index && temp != null)
            {
                temp = temp.next;
                curr++;
            }

            if (curr == index && temp != null)
            {
                return temp.val;
            }
            else
            {
                return -1;
            }
        }

        /// <summary>
        /// Add a node of value val before the first element of the linked list.
        /// After the insertion, the new node will be the first node of the linked list.
        /// </summary>
        /// <param name="val"></param>
        public void AddAtHead(int val)
        {
            Node newHead = new Node(val, this.head);
            this.head = newHead;
        }

        /// <summary>
        /// Append a node of value val to the last element of the linked list.
        /// </summary>
        /// <param name="val">Add a new node at the tail of the list</param>
        public void AddAtTail(int val)
        {
            if (this.head == null)
            {
                this.head = new Node(val);
                return;
            }

            Node temp = this.head;
            while (temp.next != null)
            {
                temp = temp.next;
            }

            temp.next = new Node(val);
        }

        /// <summary>
        /// Add a node of value val before the index-th node in the linked list.
        /// If index equals to the length of linked list, the node will be appended
        /// to the end of linked list. If index is greater than the length,
        /// the node will not be inserted.
        /// </summary>
        /// <param name="index">index in the list</param>
        /// <param name="val">value to add at the given index</param>
        public void AddAtIndex(int index, int val)
        {
            if (index == 0)
            {
                Node newHead = new Node(val, this.head);
                this.head = newHead;
                return;
            }

            Node temp = this.head;
            int curr = 0;

            while (curr < index - 1 && temp != null)
            {
                temp = temp.next;
                curr++;
            }

            if (curr == index - 1)
            {
                temp.next = new Node(val, temp.next);
                return;
            }
        }

        /// <summary>
        /// Delete the index-th node in the linked list,
        /// if the index is valid.
        /// </summary>
        /// <param name="index">index from where the index needed to deleted</param>
        public void DeleteAtIndex(int index)
        {
            if (index == 0 && head != null)
            {
                this.head = this.head.next;
                return;
            }

            Node temp = this.head;
            int curr = 0;

            while (curr < index - 1 && temp != null)
            {
                temp = temp.next;
                curr++;
            }

            if (curr == index - 1 && temp.next != null)
            {
                temp.next = temp.next.next;
                return;
            }
        }


        public static void main(String[] args) {

                MyLinkedList myLinkedList = new MyLinkedList();
                myLinkedList.AddAtHead(1);
                myLinkedList.AddAtTail(3);
                myLinkedList.AddAtIndex(1, 2);
                //myLinkedList.Get(1);
                //myLinkedList.DeleteAtIndex(1);
                //myLinkedList.Get(1);

                System.out.println(myLinkedList.Get(1));
        }
    }

