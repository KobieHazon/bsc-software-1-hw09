package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class StealthCruiser extends Fighter {

	private static int stealthCruiserNum = 0;

	public StealthCruiser(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, List<Weapon> weapons) {
		super(name, commissionYear, maximalSpeed, crewMembers, weapons);
		stealthCruiserNum++;
	}

	public StealthCruiser(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers){
		this(name, commissionYear, maximalSpeed, crewMembers, getDefaultList());
	}

	public static List<Weapon> getDefaultList() {
		List<Weapon> weapons = new ArrayList<Weapon>();
		weapons.add(new Weapon ("Laser Cannons",10,100));
		return weapons;
	}

	@Override
	public int getAnnualMaintenanceCost() {
		return super.getAnnualMaintenanceCost() + 50*stealthCruiserNum;
	}

	@Override
	public String toString() {
		return "StealthCruiser" + super.toString().substring(super.toString().indexOf(System.lineSeparator()));
	}
}
