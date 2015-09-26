package week3;

public enum Direction {
	NORTH, SOUTH;
	
	final static int amountOfDirections = Direction.values().length;
	
	public static Direction switchDirection(Direction dir){
		int returnDir = (dir.ordinal()+1)%amountOfDirections;
		return Direction.values()[returnDir];
	}
}
