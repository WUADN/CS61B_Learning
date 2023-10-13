public class LinkedListDeque<wu> {
    private class StuffNode{
        public wu itemWu;
        public StuffNode prv;
        public StuffNode next;

        public StuffNode(wu i, StuffNode p, StuffNode n){
            itemWu = i;
            prv = p;
            next = n;
        }

        public StuffNode (){{
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
    public LinkedListDeque(){
        sentinel = new StuffNode();
        size = 0;
    }

    /*initialize a deque */
    public LinkedListDeque(wu i){
        sentinel = new StuffNode();
        StuffNode first = new StuffNode(i, sentinel, sentinel);
        sentinel.next = first;
        sentinel.prv = first;
        size = 0;
    }
    /*Adds an item of type wu to the front of the deque */
    public void addFirst(wu item){
        StuffNode first = sentinel.next;
        StuffNode addfirst = new StuffNode(item, sentinel, first);
        sentinel.next = addfirst;
        first.prv = addfirst; 
        size ++;
    }

    /* Adds an item of type T to the back of the deque */
    public void addLast(wu item){
        StuffNode last = sentinel.prv;
        StuffNode addlast = new StuffNode(item, last, sentinel);
        sentinel.prv = addlast;
        last.next = addlast;
        size ++;
    }

    /* Removes and returns the item at the front of the deque.
     * If no such item exists, returns null.
    */

    public wu removeFirst(){
    if(sentinel.next == sentinel){
            return null;
        }else{
            size --;
            wu i = sentinel.next.itemWu;
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

    public wu removeLast(){
        if(sentinel.next == sentinel){
            return null;
        }
        else{
            size -= size;
            wu i = sentinel.prv.itemWu;
            StuffNode lastNode = sentinel.prv;
            StuffNode secondLastNode = lastNode.prv;
            secondLastNode.next = sentinel;
            sentinel.prv = secondLastNode;
            return i;
        }
    }

    /*Returns true if deque is empty, false otherwise. */
    public boolean isEmpty(){
        if(sentinel.next == sentinel){
            return true;
        }else{
            return false;
        }
    }

    /*Returns the number of items in the deque. */
    public int size(){
        return size;
    }

    /* Prints the items in the deque from first to last, separated by a space. */
    public void printDeque(){
        StuffNode printptr = sentinel.next;
        while(printptr != sentinel){
            System.out.print(printptr.itemWu);
            System.out.print(" ");
            printptr = printptr.next;
        }
    }
    /*get the index item */
    public wu get(int index){
        StuffNode ptr = sentinel;
        for(int i = 0; i < index; i++){
        ptr = ptr.next;
        if(ptr == sentinel){
            return null;
        }
    }
    return ptr.itemWu;
    }

    /*use recursive to get index item */
    public wu getRecursive(int index){
        StuffNode ptr = helperRecursive(index, sentinel);
        return ptr.itemWu;
    }

    /*helper function for getRecursive */
    public StuffNode helperRecursive(int index, StuffNode Node){
        if (index == 0){
            return Node;
        }
        StuffNode ptrNode = Node;
        ptrNode = ptrNode.next; 
        return helperRecursive(index - 1, helperRecursive(index - 1, ptrNode));
    }


} 

    
