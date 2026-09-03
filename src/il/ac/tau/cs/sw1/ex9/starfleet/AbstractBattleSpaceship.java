package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public abstract class AbstractBattleSpaceship extends AbstractSpaceship {
	
	private List<Weapon> weapons;
	
	public AbstractBattleSpaceship(String name, int commissionYear, float maximalSpeed, Set<? extends CrewMember> crewMembers, List<Weapon> weapons) {
		super(name, commissionYear, maximalSpeed, crewMembers);
		this.weapons = new ArrayList<Weapon>(weapons);
	}
	
	public List<Weapon> getWeapon() {
		return this.weapons;
	}
	
	@Override
	public int getFirePower() {
		int firePower = super.getFirePower();
		for (Weapon weapon: weapons) {
			firePower += weapon.getFirePower();
		}
		return firePower;
	}
	
	public int getWeaponCost() {
		int weaponCost = 0;
		for (Weapon weapon: weapons) {
			weaponCost += weapon.getAnnualMaintenanceCost();
		}
		return weaponCost;
	}
	
	public abstract int getAnnualMaintenanceCost();
	
	public String toString() {
		return super.toString() + "\tAnnualMaintenanceCost=" + this.getAnnualMaintenanceCost() +
				System.lineSeparator() + "\tWeaponArray=" + Arrays.toString(this.getWeapon().toArray());
	}
	
}
