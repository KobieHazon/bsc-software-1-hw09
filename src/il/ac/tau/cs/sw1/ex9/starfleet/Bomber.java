package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class Bomber extends AbstractBattleSpaceship{

	public int numberOfTechnicians;
	private final int bomberCost = 5000;
	
	public Bomber(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, List<Weapon> weapons, int numberOfTechnicians){
		super(name, commissionYear, maximalSpeed, crewMembers, weapons);
		this.numberOfTechnicians = numberOfTechnicians;
	}
	
	public int getNumberOfTechnicians() {
		return this.numberOfTechnicians;
	}
	
	@Override
	public int getAnnualMaintenanceCost() {
		return (int) (bomberCost + super.getWeaponCost()*(1 - this.numberOfTechnicians*0.1));
	}

	@Override
	public String toString() {
		return "Bomber" + System.lineSeparator() + super.toString() + System.lineSeparator() + 
				"\tNumberOfTechnicians=" + this.getNumberOfTechnicians();
	}
}
