package LinkedListImplemented;


public class Execution {
    public static void main(String[] args) {
        Definition<Integer> list = new Definition<>();
        list.print();
        list.add(1);
        list.add(2);
        list.print();
        list.remove();
        list.print();
    }
}
