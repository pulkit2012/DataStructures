package StackImplementation;

public interface StackADT<E> {
    void push(E data);
    E peek();
    void pop();
    void display();
}
