/**
 * Assignment #: 11
 * Name: Joel Hudgens
 * StudentID: 1224491216
 * Lecture: T, Th 10: 30
 * Description: This class is a node object that will be used in the tree
 * Each node has a game, and two pointers (left and right)
 */

public class Node {
    // Declare instance variables
    private Game game;
    private Node left, right;

    // Define constructor
    public Node(Game game) {
        this.game = game;
        left = null;
        right = null;
    }

    // Define accessors/mutators
    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }
}