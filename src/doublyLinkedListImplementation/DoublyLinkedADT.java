package doublyLinkedListImplementation;

public interface DoublyLinkedADT<E> {
    void add(E data);
    void remove();
    void print();
    int search(E data);
}
