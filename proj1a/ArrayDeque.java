public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int front;


    public ArrayDeque() {
        items = (T[]) new Object[8];
        front = 0;
        size = 0;
    }

    /*获取队列的容量 */
    private int capacity() {
        return items.length;
    }

    /*if the deque is fullfilled, resize the deque */
    private void resize() {
        T[] newarr = (T[]) new Object[capacity() * 2];
        System.arraycopy(items, front, newarr, 0, size);
        items = newarr;
        front = 0;
    }

    /*check wheather the deque is empty  */
    public boolean isEmpty() {
        return size == 0;
    }

    /*return size */
    public int size() {
        return size;
    }

    /*add last item */
    public void addLast(T item) {
        if (size == items.length) {
            resize();
        }
        int rear = (front + size) % capacity();
        items[rear] = item;
        size++;
    }

    /*remove last item */
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        int last = (front + size - 1) % capacity();
        T item = items[last];
        items[last] = null;
        size--;
        return item;
    }

    /*add first items */
    public void addFirst(T item) {
        front--;
    
        if (front < 0) {
            front = capacity() - 1;
        }
        items[front] = item;

        size++;
    }

    /*remove first item */
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T item = items[front];
        front = (front + 1) % capacity();
        size--;
        return item;
        
    }

    /*get the index item */
    public T get(int index) {
        int goalIndex = (front + index) % capacity();
        return items[goalIndex];
    }
    
    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.print(get(i) + " ");
        }
    }
}
