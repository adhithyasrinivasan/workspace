package ctatic;

public class Bicycle {

int cadence,speed,gear;
	public Bicycle(int startCadence, int startSpeed, int startGear) {
		// TODO Auto-generated constructor stub
		this.cadence=startCadence;
		this.speed=startSpeed;
		this.gear=startGear;
	}
	public void printDescription(){
	    System.out.println("\nBike is " + "in gear " + this.gear
	        + " with a cadence of " + this.cadence +
	        " and travelling at a speed of " + this.speed + ". ");
	}

}
