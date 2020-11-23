package Trees;


import java.util.Scanner;

public class Tree {
    static class Node {
        int value;
        Node left, right;

        public Node(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    public void insert(Node node, int value) {
        if (value < node.value) {
            if (node.left != null) {
                insert(node.left, value);
            } else {
                System.out.println("inserted " + value + " to the left of " + node.value);
                node.left = new Node(value);
            }
        } else if (value > node.value) {
            if (node.right != null) {
                insert(node.right, value);
            } else {
                System.out.println("inserted " + value + " to the right of " + node.value);
                node.right = new Node(value);
            }
        }
    }

    public void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(" " + node.value);
            inOrder(node.right);
        }
    }

    public void preOrder(Node node) {
        if (node != null) {
            System.out.print(" " + node.value);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(" " + node.value);
        }
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        System.out.println("Do you want to create a binary tree..? Yes/No");
        Scanner in = new Scanner(System.in);
        String a = in.nextLine().trim();
        if (a.equals("Yes")) {
            System.out.println("We are creating the root please enter the value ");
            int rootVal = in.nextInt();
            in.nextLine();
            Node root = new Node(rootVal);
            System.out.println("Thanks, root successfully created, Do you Want to add more Nodes..? Yes/No");
            String str = in.nextLine().trim();
            if (str.equals("Yes")) {
                System.out.println("Type Exit whenever you want to stop inserting values, initialising your tree please start entering values");
                while (true) {
                    String val = in.nextLine();
                    if (val.equals("Exit")) {
                        break;
                    } else {
                        tree.insert(root, Integer.parseInt(val));
                    }
                }
            }
            System.out.println("Do You Want to traverse the Tree...? Yes/No");
            if (in.nextLine().equals("Yes")) {
                boolean switcher = true;
                while (switcher) {
                    System.out.println("Which Traversal You Want to Use..?\nType 1 for Inorder\nType 2 for preOrder\nType 3 for postOrder\nType 4 for Exit");
                    int input = in.nextInt();
                    in.nextLine();
                    switch (input) {
                        case 1:
                            System.out.print("Traversed tree:");
                            tree.inOrder(root);
                            System.out.println("\n--------------------------------");
                            break;
                        case 2:
                            System.out.print("Traversed tree:");
                            tree.preOrder(root);
                            System.out.println("\n--------------------------------");
                            break;
                        case 3:
                            System.out.print("Traversed tree:");
                            tree.postOrder(root);
                            System.out.println("\n--------------------------------");
                            break;
                        case 4:
                             switcher = false;
                             break;
                    }
                }
            }
            System.out.println("\n--------------------------------");
        }
        System.out.println("Thanks for testing our code");
    }
}
