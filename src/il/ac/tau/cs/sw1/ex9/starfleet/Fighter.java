package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class Fighter extends AbstractBattleSpaceship {

	private final int fighterCost = 2500;

	public Fighter(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, List<Weapon> weapons){
		super(name, commissionYear, maximalSpeed, crewMembers, weapons);
	}

	@Override
	public int getAnnualMaintenanceCost() {
		return fighterCost + super.getWeaponCost() + (int)(1000*this.getMaximalSpeed());
	}

	@Override
	public String toString() {
		return "Fighter" + System.lineSeparator() + super.toString();
	}
}
