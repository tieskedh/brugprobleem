package week3;

public class Bridge {
	private int onBridge;
	private Direction turn;
	
	
	public Bridge() {
		onBridge = 0;
		turn=Direction.NORTH;
	}
	
	public synchronized void waitForEntering(Farmer farmer){
		Direction origine = farmer.getOrigine();
		if(!turn.equals(origine)){
			if(onBridge==0){
				turn = origine;
				System.err.println("turn changed to "+turn);
				onBridge++;
				System.err.println(" "+onBridge+" persons on bridge");
				return;
			}else{
				while(!turn.equals(origine)){
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}else{
			onBridge++;
		}
	}
	
	public synchronized void leaveBridge(){
		System.err.println(" "+onBridge+"persons on bridge");
		if(--onBridge == 0){
			turn=Direction.switchDirection(turn);
			System.err.println("turn changed to "+turn);
		}
		notifyAll();
	}
}
