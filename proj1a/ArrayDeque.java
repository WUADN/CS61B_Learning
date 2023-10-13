public class ArrayDeque<Wu>{
    private Wu[] items;
    private int size;
    private int front;


    public ArrayDeque(){
        items = (Wu[]) new Object[8];
        front = size = 0;
    }

       /*获取队列的容量 */
    public int capacity(){
        return items.length;
    }

      /*if the deque is fullfilled, resize the deque */
    public void resize(){
        Wu[] newarr = (Wu[]) new Object[capacity() * 2];
        System.arraycopy(items, front, newarr, 0, size);
        items = newarr;
        front = 0;
    }

    /*check wheather the deque is empty  */
    public boolean isEmpty(){
       return size == 0;
    }

    /*return size */
    public int size(){
        return size;
    }

    /*add last item */
    public void addLast(Wu item){
        if(size == items.length){
            resize();
        }
        int rear = (front + size) % capacity();
        items[rear] = item;
        size ++;
    }

    /*remove last item */
    public void removeLast(){
        if(size == 0){
            return;
        }
        int last = (front + size - 1) % capacity();
        items[last] = null;
        size --;
    }

    /*add first items */
    public void addFirst(Wu item){
        front --;
    
        if(front < 0){
            front = capacity() - 1;
        }
        items[front] = item;

        size --;
    }

    /*remove first item */
    public void removeFirst(){
        if(size == 0){
            return;
        }
        front = (front + 1) % capacity();
    }

    /*get the index item */
    public Wu get(int index){
        int goalIndex = (front + index) % capacity();
        return items[goalIndex];
    }
    
    public void printDeque(){
        for(int i = 0; i < size; i++){
            System.out.print(get(i) + " ");
        }
    }
    
}
