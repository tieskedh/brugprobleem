package week3;

public class Farmer extends Thread{
	private String id;
	private Direction origin;
	private Bridge bridge;
	private static final int walkingDuration=5000;
	
	public Farmer(String id, Direction origin, Bridge bridge) {
		this.id = id;
		this.origin = origin;
		this.bridge = bridge;
	}
	
	private void walk(){
		System.out.println("farmer "+id+" waiting for entering");
		bridge.waitForEntering(this);
		System.out.println("farmer "+id+" enters bridge");
		
		try {
			Thread.sleep(walkingDuration);
			System.out.println("farmer "+id+" leaving bridge");
			bridge.leaveBridge();
			System.out.println("farmer "+id+" left bridge");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public Direction getOrigine() {
		return origin;
	}

	@Override
	public void run() {
		walk();
	}
}
