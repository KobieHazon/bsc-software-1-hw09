package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class CylonRaider extends AbstractBattleSpaceship {

	private final int raiderCost = 3500;
	
	public CylonRaider(String name, int commissionYear, float maximalSpeed, Set<Cylon> crewMembers,
			List<Weapon> weapons) {
		super(name, commissionYear, maximalSpeed, crewMembers, weapons);
	}
	
	@Override
	public int getAnnualMaintenanceCost() {
		return (int) (raiderCost + super.getWeaponCost() + 500*super.getCrewMembers().size() + 1200*super.getMaximalSpeed());
	}

	@Override
	public String toString() {
		return "CylonRaider" + System.lineSeparator() + super.toString();
	}


}
