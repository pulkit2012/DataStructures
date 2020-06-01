package StackImplementation;

public class execution {
    public static void main(String[] args) {
        Definition<Integer> stack = new Definition<>();
        stack.push(1);
        stack.push(2);
        stack.display();
        stack.push(3);
        stack.display();
        stack.pop();
        stack.display();
        System.out.println(stack.peek());
    }
}
