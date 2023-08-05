
 /**
 * Assignment #: 11
 * Name: Joel Hudgens
 * StudentID: 1224491216
 * Lecture: T, Th 10: 30
 * Description: This class is a game object.
 * Each game has four instance variables.
 */

public class Game {
    // Declare instance variables
    private String name;
    private String description;
    private double price;
    private int downloads;

    // Define constructor
    public Game(String name, String description, double price, int downloads) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.downloads = downloads;
    }

    // Define accessor methods
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getDownloads() {
        return downloads;
    }

    // Define string representation of Game objects
    @Override
    public String toString() {
        return name + "\n" + description + "\nZyBox Price: $" + String.format("%.2f", price) + "\n" + downloads
                + " downloads\n";
    }
}