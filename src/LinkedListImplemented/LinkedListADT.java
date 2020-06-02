package LinkedListImplemented;

public interface LinkedListADT<E> {
    void add(E data);
    E remove();
    int search(E item);
    void print();
    void middle();
}
