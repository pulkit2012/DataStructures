package QueueImplementation;

public class Definition<E> implements QueueADT<E> {

    static class Node<E> {
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

    private Node<E> front;
    private Node<E> rear;
    private int size = 0;

    @Override
    public void enQueue(E data) {
        Node<E> node = new Node<>(data);
        if (rear == null) {
            front = rear = node;
        } else {
            rear.next = node;
            rear = node;
        }
        size++;
    }

    @Override
    public void deQueue() {
        if (front == null) {
            System.out.print("Queue is empty");
        } else {
            front = front.getNext();
            if (front == null) {
                rear = null;
            }
        }
    }

    @Override
    public void display() {
        Node<E> temp = front;
        while (temp != rear.getNext()) {
            System.out.print(temp.getData() + " ");
            temp = temp.getNext();
        }
    }
}
