package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.HashSet;
import java.util.Set;

public abstract class AbstractSpaceship implements Spaceship {
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractSpaceship other = (AbstractSpaceship) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	private String name;
	private int commissionYear;
	private float maximalSpeed;
	private int firePower;
	private Set<? extends CrewMember> crewMembers;
	
	public AbstractSpaceship(String name, int commissionYear, float maximalSpeed, Set<? extends CrewMember> crewMembers) {
		this.name = name;
		this.commissionYear = commissionYear;
		this.maximalSpeed = maximalSpeed;
		this.firePower = 10;
		this.crewMembers = new HashSet<CrewMember>(crewMembers);
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getCommissionYear() {
		return this.commissionYear;
	}
	
	public float getMaximalSpeed() {
		return this.maximalSpeed;
	}
	
	public int getFirePower() {
		return this.firePower;
	}
	
	public Set<? extends CrewMember> getCrewMembers() {
		return this.crewMembers;
	}
	
	public abstract int getAnnualMaintenanceCost();
	
	public String toString() {
		String str = "\tName=" + this.getName() + System.lineSeparator() + "\tCommissionYear=" + this.getCommissionYear() + 
				System.lineSeparator() + "\tMaximalSpeed=" + this.getMaximalSpeed() + System.lineSeparator() + "\tFirePower=" + 
				this.getFirePower() + System.lineSeparator() + "\tCrewMembers=" + this.getCrewMembers().size() + 
				System.lineSeparator();
		return str;
	}
	
}
