package doublyLinkedListImplementation;

public class Execution {
    public static void main(String[] args) {
        Definition<Integer> doublyList = new Definition<>();
        doublyList.add(2);
        doublyList.add(3);
        doublyList.add(4);
        doublyList.print();
        doublyList.remove();
        doublyList.print();
        System.out.println(doublyList.search(2));
    }
}
