package doublyLinkedListImplementation;

import javax.swing.event.MenuKeyListener;

public class Definition<E> implements DoublyLinkedADT<E> {
    class Node<E> {
        private E data;
        private Node<E> prev;
        private Node<E> next;

        public Node(E data) {
            this.data = data;
        }

        public E getData() {
            return data;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public Node<E> getNext() {
            return next;
        }
    }

    private int size = 0;
    private Node<E> head;
    private Node<E> tail;

    private Node<E> getNode(int index) {
        Node<E> temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.getNext();
        }
        return temp;
    }

    private void addFirst(E data) {
        Node<E> node = new Node<E>(data);
        node.next = head;
        node.prev = null;
        if (head != null) {
            head.prev = node;
        }
        head = node;
        size++;
    }

    private void addAfter(Node<E> prev, E data) {
        Node<E> node = new Node<>(data);
        node.next = prev.next;
        prev.next = node;
        node.prev = prev;
        if (node.next != null) {
            node.next.prev = node;
        }
        size++;
    }

    public void add(int index, E data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        } else if (index == 0) {
            addFirst(data);
        } else {
            Node<E> prev = getNode(index - 1);
            addAfter(prev, data);
        }
    }

    @Override
    public void add(E data) {
        add(size, data);
    }

    private E removeFirst() {
        E resp = null;
        Node<E> temp = head;
        if (head != null) {
            head = head.getNext();
            head.prev = null;
            size--;
            resp = temp.getData();
        }
        return resp;
    }

    private E removeLast() {
       E resp = null;
        Node<E> temp = head;
       while(temp.next != null){
           temp = temp.getNext();
       }
       temp = temp.getPrev();
       temp.next = null;
       resp = temp.getData();
       size--;
        return resp;
    }

    public E remove(int index) {
        E resp = null;
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        } else if (index == 0) {
            resp = removeFirst();
        } else {
            Node<E> prev = getNode(index - 1);
            resp = removeLast();
        }
        return resp;
    }

    @Override
    public void remove() {
        remove(size - 1);
    }

    @Override
    public void print() {
        System.out.print("[");
        Node<E> temp = head;
        for (int i = 0; i < size; i++) {
            System.out.print(temp.data + (i < size - 1 ? ", " : ""));
            temp = temp.getNext();
        }
        System.out.println("]");
    }

    @Override
    public int search(E data) {
        int temp = -1;
        for (int i = 0; i < size; i++) {
            E data1 = this.getNode(i).getData();
            if(data.equals(data1)){
                temp = i;
                break;
            }
        }
        return temp;
    }
}
