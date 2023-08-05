/**
 * Assignment #: 11 Name: Joel Hudgens StudentID: 1224491216 Lecture: T, Th 10:30
 * Description: This class is the Game store. The store is a Binary Tree. The
 * tree is sorted by price of the Games This class has methods which manipulate
 * the tree. These methods are called in the main driver upon user action
 */

public class ZyBoxLiveStore {

	private Node root; // Binary Search Tree root node

	// Constructor
	public ZyBoxLiveStore() {
		this.root = null;
	}

	// Adds a Game to the correct position in the store (sorted by price)
	// Returns the node in which the Game was added
	public Node addGameToStore(Node temp, Game gameToAdd) {
		if (temp == null) {
			return new Node(gameToAdd); // Add it when we reach an empty node
		}
		double priceOfGameToAdd = gameToAdd.getPrice();
		double priceOfCurrentGame = temp.getGame().getPrice();

		if (priceOfGameToAdd < priceOfCurrentGame) {
			temp.setLeft(addGameToStore(temp.getLeft(), gameToAdd)); // Go to left if price is less than
		}
		if (priceOfGameToAdd > priceOfCurrentGame) {
			temp.setRight(addGameToStore(temp.getRight(), gameToAdd)); // Go to right if price is greater than
		}
		if (priceOfGameToAdd == priceOfCurrentGame) {
			System.out.print("Game at this price is in store inventory already.\n");
		}
		return temp;
	}

	// Lists all of the games in the store
	// The store is a Binary tree, sorted by price
	// Therefore, this method is an in-order traversal of the tree, with a print
	// statement
	public void listGamesByPrice(Node temp) {
		if (temp == null) {
			return;
		}
		listGamesByPrice(temp.getLeft());
		System.out.println(temp.getGame().toString());
		listGamesByPrice(temp.getRight());
	}

	// Removes a game from the BST based on the game's price (the BST key)
	public Node removeGameFromStore(Node node, double price) {
		if (node == null) {
			return null;
		}

		double nodePrice = node.getGame().getPrice();

		if (price < nodePrice) {
			node.setLeft(removeGameFromStore(node.getLeft(), price));
		} else if (price > nodePrice) {
			node.setRight(removeGameFromStore(node.getRight(), price));
		} else {
			// Found the node to be removed
			if (node.getLeft() == null) {
				return node.getRight();
			} else if (node.getRight() == null) {
				return node.getLeft();
			} else {
				// Node has two children, find successor and replace node
				Node successor = findMinNode(node.getRight());
				node.setGame(successor.getGame());
				node.setRight(removeGameFromStore(node.getRight(), successor.getGame().getPrice()));
			}
		}
		return node;
	}

	// Finds the Game with the lowest price in the store
	private Node findMinNode(Node right) {
		if (right.getLeft() == null) {
			return right;
		} else {
			findMinNode(right.getLeft());
		}
		return null;// Should never execute
	}

	// Searches for a game (by name) in the store. Returns null if there are no
	// games in the store or the game was not found. Otherwise, returns the Game
	// object with the game's matching name
	public Game searchByName(Node node, String name) {
		if (node == null) {
			return null;
		}
		Game leftResult = searchByName(node.getLeft(), name); // checks all left nodes
		if (leftResult != null) {
			return leftResult;
		}
		if (node.getGame().getName().equals(name)) { // return the Game if it's name matches
			return node.getGame();
		}
		Game rightResult = searchByName(node.getRight(), name); // checks all right nodes
		return rightResult;
	}

	// Returns the number of games in the store
	public int countGamesInStore(Node temp) {
		if (temp == null) {
			return 0;
		}
		int count = 1;
		Node left = temp.getLeft();
		Node right = temp.getRight();

		count += countGamesInStore(left); // count left nodes
		count += countGamesInStore(right);// count right nodes
		return count;
	}

	// Searches the Store using Binary search tree
	// If the price is equal to key, then return that Game
	public Game searchByPrice(Node temp, double key) { // where key is the price of the game
		if (temp == null) {
			return null;
		}

		double priceOfCurrentNode = temp.getGame().getPrice();

		if (priceOfCurrentNode == key) { // If the game's price equals key, return that game
			return temp.getGame();
		} else if (priceOfCurrentNode < key) { // If the games price is less than key, traverse to right node
			return searchByPrice(temp.getRight(), key);
		} else if (priceOfCurrentNode > key) { // If the games price is greater than key, traverse to left node
			return searchByPrice(temp.getLeft(), key);
		} else {
			return null; // If Game is not found
		}
	}

	// Returns the sum of all of the Game's prices in the store
	public double calculateStoreValue(Node temp) {
		if (temp == null) {
			return 0;
		} else {
			double sum = temp.getGame().getPrice();
			sum += calculateStoreValue(temp.getLeft()); // add prices of left nodes
			sum += calculateStoreValue(temp.getRight()); //// add prices of right nodes
			return sum;
		}
	}

	// Returns the Game with the most amount of downloads
	public Game searchMostPopularGame(Node temp) {
		Game mostPopular = temp.getGame();

		// check left subtree
		if (temp.getLeft() != null) {
			Game leftPopular = searchMostPopularGame(temp.getLeft());
			if (leftPopular.getDownloads() > mostPopular.getDownloads()) {
				mostPopular = leftPopular;
			}
		}

		// check right subtree
		if (temp.getRight() != null) {
			Game rightPopular = searchMostPopularGame(temp.getRight());
			if (rightPopular.getDownloads() > mostPopular.getDownloads()) {
				mostPopular = rightPopular;
			}
		}
		return mostPopular;
	}

	// * get/setRoot(...) METHODS PROVIDED AS PART OF TEMPLATE
	// getters and setters for the BST root
	public void setRoot(Node root) {
		this.root = root;
	}

	public Node getRoot() {
		return root;
	}

}