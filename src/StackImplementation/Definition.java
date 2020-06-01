package StackImplementation;

import jdk.dynalink.NamedOperation;

public class Definition<E> implements StackADT<E> {
    static class Node<E>{
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
    private int size = 0;
    private Node<E> top;
    public boolean isEmpty(){
        return size == 0;
    }
    @Override
    public void push(E data) {
        Node<E> node = new Node<>(data);
        node.next = top;
        top = node;
        size++;
    }

    @Override
    public E peek() {
        E temp = null;
        if(top == null){
            System.out.println("Stack is Empty");
        }
        else {
            temp = top.getData();
        }
        return temp;
    }

    @Override
    public void pop() {
        if(top == null){
            System.out.println("Stack UnderFlow");
        }
        else {
            top = top.getNext();
            size--;
        }
    }

    @Override
    public void display() {
        if(top == null){
            System.out.println("Stack Underflow");
        }
        else {
            Node<E> temp = top;
            while(temp != null){
                System.out.print(temp.getData() + " ");
                temp = temp.getNext();
            }
            System.out.println();
        }
    }
}
