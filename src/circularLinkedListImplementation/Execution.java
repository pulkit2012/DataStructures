package circularLinkedListImplementation;

public class Execution {
    public static void main(String[] args) {
        Definition<Integer> definition = new Definition<>();
        definition.insertAtBeginning(1);
        definition.insertAtBeginning(2);
        definition.insertAtBeginning(3);
        definition.insertAtBeginning(4);
        definition.display();
        definition.insertAtLast(9);
        definition.insertAtLast(10);
        definition.insertAtLast(11);
        definition.display();
        definition.delFromLAst();
        definition.display();
        definition.delFromBeginning();
        definition.display();
        definition.insertAtPos(1,13);
        definition.display();
        definition.delFromPos(3);
        definition.display();
        System.out.println("Search Method ");
        System.out.println("Index : " + definition.search(10));
    }
}
