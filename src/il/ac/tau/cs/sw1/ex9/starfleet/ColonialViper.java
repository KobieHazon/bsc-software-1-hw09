package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class ColonialViper extends AbstractBattleSpaceship {

	private final int viperCost = 4000;

	public ColonialViper(String name, int commissionYear, float maximalSpeed, Set<CrewWoman> crewMembers,
			List<Weapon> weapons) {
		super(name, commissionYear, maximalSpeed, crewMembers, weapons);
	}

	@Override
	public int getAnnualMaintenanceCost() {
		return (int) (viperCost + super.getWeaponCost() + 500*super.getCrewMembers().size() + 500*super.getMaximalSpeed());
	}

	@Override
	public String toString() {
		return "ColonialViper" + System.lineSeparator() + super.toString();
	}

}
