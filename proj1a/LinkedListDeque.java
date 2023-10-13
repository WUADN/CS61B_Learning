public class LinkedListDeque<T> {
    private class StuffNode {
        private T itemWu;
        private StuffNode prv;
        private StuffNode next;

        public StuffNode(T i, StuffNode p, StuffNode n) {
            itemWu = i;
            prv = p;
            next = n;
        }

        public StuffNode() {
            {
                itemWu = null;
                prv = this;
                next = this;
            }
        }
    }

    /*the first item is sentinel */
    private int size;
    private StuffNode sentinel;

    /*creat a empty deque  */
    public LinkedListDeque() {
        sentinel = new StuffNode();
        size = 0;
    }

    /*Adds an item of type wu to the front of the deque */
    public void addFirst(T item) {
        StuffNode first = sentinel.next;
        StuffNode addfirst = new StuffNode(item, sentinel, first);
        sentinel.next = addfirst;
        first.prv = addfirst; 
        size++;
    }

    /* Adds an item of type T to the back of the deque */
    public void addLast(T item) {
        StuffNode last = sentinel.prv;
        StuffNode addlast = new StuffNode(item, last, sentinel);
        sentinel.prv = addlast;
        last.next = addlast;
        size++;
    }

    /* Removes and returns the item at the front of the deque.
     * If no such item exists, returns null.
    */

    public T removeFirst() {
        if (sentinel.next == sentinel) {
            return null;
        } else {
            size--;
            T i = sentinel.next.itemWu;
            StuffNode firstNode = sentinel.next;
            StuffNode secondNode = firstNode.next;
            sentinel.next = secondNode;
            secondNode.prv = sentinel;
            return i;
        }
    }

    /* Removes and returns the item at the back of the deque.
    * If no such item exists, returns null.
    */

    public T removeLast() {
        if (sentinel.next == sentinel) {
            return null;
        } else {
            size--;
            T i = sentinel.prv.itemWu;
            StuffNode lastNode = sentinel.prv;
            StuffNode secondLastNode = lastNode.prv;
            secondLastNode.next = sentinel;
            sentinel.prv = secondLastNode;
            return i;
        }
    }

    /*Returns true if deque is empty, false otherwise. */
    public boolean isEmpty() {
        return sentinel.next == sentinel;
    }

    /*Returns the number of items in the deque. */
    public int size() {
        return size;
    }

    /* Prints the items in the deque from first to last, separated by a space. */
    public void printDeque() {
        StuffNode printptr = sentinel.next;
        while (printptr != sentinel) {
            System.out.print(printptr.itemWu);
            System.out.print(" ");
            printptr = printptr.next;
        }
    }
    /*get the index item */
    public T get(int index) {
        StuffNode ptr = sentinel;
        for (int i = 0; i <= index; i++) {
            ptr = ptr.next;
            if (ptr == sentinel) {
                return null;
            }
        }
        return ptr.itemWu;
    }

    /*use recursive to get index item */
    public T getRecursive(int index) {
        StuffNode ptr = helperRecursive(index, sentinel);
        return ptr.itemWu;
    }

    /*helper function for getRecursive */
    private StuffNode helperRecursive(int index, StuffNode node) {
        if (index == -1) {
            return node;
        }
        StuffNode ptrNode = node;
        ptrNode = ptrNode.next; 
        return helperRecursive(index - 1, helperRecursive(index - 1, ptrNode));
    }


} 

    
