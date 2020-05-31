package circularLinkedListImplementation;

public class
Definition<E> implements CircularADT<E> {
    class Node<E>{
        private E data;
        private Node<E> next;

        public Node(E data) {
            this.data = data;
        }

        public E getData() {
            return data;
        }

        public Node<E> getNext() {
            return next;
        }
    }
    private Node<E> head;
    private Node<E> tail;
    private int size = 0;
    private Node<E> getNode(int index){
        Node<E> temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.getNext();
        }
        return temp;
    }
    @Override
    public void insertAtBeginning(E data) {
        Node<E> node = new Node<>(data);
        if(head == null){
            head = node;
            node.next = head;
        }
        else {
            Node<E> temp = head;
            for (int i = 0; i < size - 1; i++) {
                temp = temp.getNext();
            }
            temp.next = node;
            node.next = head;
            head = node;
        }
        size++;
    }

    @Override
    public void insertAtLast(E data) {
        Node<E> node = new Node<>(data);
        if(head == null){
            head = node;
        }
        else {
            Node<E> temp = head;
            while(temp.next != head){
                temp = temp.getNext();
            }
            temp.next = node;
        }
        node.next = head;
        size++;
    }

    @Override
    public void insertAtPos(int index , E data) {
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        else if(index == 0){
            insertAtBeginning(data);
        }
        else if(index == size - 1){
            insertAtLast(data);
        }
        else {
            Node<E> node = new Node<>(data);
            Node<E> curr_node = this.getNode(index);
            Node<E> prev_node = this.getNode(index - 1);
            prev_node.next = node;
            node.next = curr_node;
            size++;
        }
    }

    @Override
    public void delFromBeginning() {
        Node<E> temp = head;
        while(temp.next != head){
            temp = temp.next;
        }
        temp.next = head.next;
        head = head.next;
        size--;
    }

    @Override
    public void delFromLAst() {
        Node<E> temp = head;
        while(temp.next.next != head){
            temp = temp.next;
        }
        temp.next = temp.next.next;
        size--;

    }
    @Override
    public void delFromPos(int index) {
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        else if(index == 0){
            delFromBeginning();
        }
        else if(index == size - 1){
            delFromLAst();
        }
        else {
            Node<E> curr_node = this.getNode(index);
            Node<E> prev = this.getNode(index - 1);
            prev.next = curr_node.next;
            size--;
        }
    }

    @Override
    public int search(E data) {
        for (int i = 0; i < size; i++) {
            E data1 = this.getNode(i).getData();
            if(data.equals(data1)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public void display() {
        if(head == null){
            System.out.println("List Is Empty");
        }
        else {
            Node<E> temp = head;
            while(temp.next != head){
                System.out.print(temp.data + " ");
                temp = temp.getNext();
            }
            System.out.print(temp.data);
        }
        System.out.println();
    }
}
