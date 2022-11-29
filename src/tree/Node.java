package tree;

public class Node {

    private Node left;
    private Node right;
    private int data;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node node) {
        this.left = node;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node node) {
        this.right = node;
    }
}
