package QueueImplementation;

public class Execution {
    public static void main(String[] args) {
        Definition<Integer> queue = new Definition<>();
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(3);
        queue.deQueue();
        queue.display();
    }
}
