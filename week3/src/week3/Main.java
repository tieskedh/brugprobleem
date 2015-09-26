package week3;

public class Main {

	public static void main(String[] args) {
		Bridge bridge = new Bridge();
		Farmer north = new Farmer("north", Direction.NORTH, bridge);
		Farmer north2 = new Farmer("north2", Direction.NORTH, bridge);
		
		Farmer south = new Farmer("south", Direction.SOUTH, bridge);
		north.start();
		south.start();
		north2.start();
	}
}