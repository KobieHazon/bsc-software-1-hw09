package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Set;

public class TransportShip extends AbstractSpaceship{

	private int cargoCapacity;
	private int passangerCapacity;
	private final int transportCost = 3000;

	public TransportShip(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, int cargoCapacity, int passengerCapacity){
		super(name, commissionYear, maximalSpeed, crewMembers);
		this.cargoCapacity = cargoCapacity;
		this.passangerCapacity = passengerCapacity;
	}

	public int getCargoCapacity() {
		return this.cargoCapacity;
	}

	public int getPassengerCapacity() {
		return this.passangerCapacity;
	}

	@Override
	public int getAnnualMaintenanceCost() {
		return transportCost + (5*getCargoCapacity()) + (3*getPassengerCapacity());
	}

	@Override
	public String toString() {
		String str = "TransportShip" + System.lineSeparator() + super.toString() + "\tAnnualMaintenanceCost=" + this.getAnnualMaintenanceCost() +
				System.lineSeparator() + "\tCargoCapacity=" + this.getCargoCapacity() + System.lineSeparator() +
				"\tPassengerCapacity=" + this.getPassengerCapacity();
		return str;
	}

}
