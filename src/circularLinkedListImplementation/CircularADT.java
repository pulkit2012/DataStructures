package circularLinkedListImplementation;

public interface CircularADT<E> {
    void insertAtBeginning(E data);
    void insertAtLast(E data);
    void insertAtPos(int index , E data);
    void delFromBeginning();
    void delFromLAst();
    void delFromPos(int index);
    int search(E data);
    void display();
}

