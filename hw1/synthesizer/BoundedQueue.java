package synthesizer;

public interface BoundedQueue<T> {
    public int capacity();
    public int fillCount();
    public void enqueue(T x);
    public T dequeue();
    public T peek();
    default boolean isEmpty(){
        if (fillCount() == 0) {
            return true;    
        }
        return false;
    };
    default boolean isFull() {
        if (fillCount() == capacity()){
            return true;
        }
        return false;
    }
}
