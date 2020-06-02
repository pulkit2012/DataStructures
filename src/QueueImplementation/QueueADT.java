package QueueImplementation;

public interface QueueADT<E> {
    void enQueue(E data);
    void deQueue();
    void display();
}
