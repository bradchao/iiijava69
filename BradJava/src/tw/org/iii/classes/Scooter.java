package tw.org.iii.classes;

public class Scooter extends Bike {
	private int gear;
	
	public void upSpeed() {
		if (gear > 0) {
			speed = speed < 1 ? 1 : speed * 1.9 * gear;
		}
	}
	
	public int upGear() {
		if (gear < 4) gear++;
		return gear;
	}
	
	public int downGear() {
		if (gear > 1) gear--;
		return gear;
	}
}
