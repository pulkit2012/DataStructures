package LinkedListImplemented;


public class Definition<E> implements LinkedListADT<E> {
    class Node<E>{
        private E data;
        private Node<E> next;

        public Node(E data) {
            this.data = data;
        }

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }

        public E getData() {
            return data;
        }

        public Node<E> getNext() {
            return next;
        }
    }
    private Node<E> head;
    private int size;
    private Node<E> getNode(int index){
        Node<E> temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.getNext();
        }
        return temp;
    }
    private void addFirst(E data){
        head = new Node<E>(data);
        size++;
    }
    private void addAfter(Node<E> node,E data){
        node.next = new Node<E>(data);
        size++;
    }
    public void add(int index,E data){
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        else if(index == 0){
            addFirst(data);
        }
        else {
            Node<E> prevNode = getNode(index - 1);
            addAfter(prevNode,data);
        }
    }
    @Override
    public void add(E data) {
        add(size,data);
    }
    private E removeFirst(){
        E temp = null;
        Node<E> resp = head;
        if(head != null) {
            head = head.getNext();
        }
        if(resp != null){
            size--;
            temp = resp.getData();
        }
        return temp;
    }
    private E removeAfter(Node<E> node) {
        E resp = null;
        Node<E> temp = node.getNext();
        if(temp != null){
            node.next = temp.getNext();
            size--;
            resp = temp.getData();
        }
        return resp;
    }
    public E remove(int index){
        E resp = null;
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        else if(index == 0){
           resp = removeFirst();
        }
        else {
            Node<E> prev = getNode(index - 1);
            resp = removeAfter(prev);
        }
        return resp;
    }
    @Override
    public E remove() {
      return remove(size - 1);
    }

    @Override
    public int search(E item) {
        int temp = -1;
        for (int i = 0; i < size; i++) {
            E data = this.getNode(i).getData();
            if(item.equals(data)){
                temp = i;
                break;
            }
        }
        return temp;
    }

    @Override
    public void print() {
        System.out.print("[");
        for (int i = 0; i < size; i++) {
            E data = this.getNode(i).getData();
            System.out.print(data + (i < size - 1 ? ", " : ""));
        }
        System.out.println("]");
    }
}
