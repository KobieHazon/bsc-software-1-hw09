package il.ac.tau.cs.sw1.ex9.starfleet;

public abstract class AbstractMember implements CrewMember {
	
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
		AbstractMember other = (AbstractMember) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	private String name;
	private int age; 
	private int serviceYears;
	
	public AbstractMember(int age, int serviceYears, String name) {
		this.name = name;
		this.age = age;
		this.serviceYears = serviceYears;
	}
	
	public String getName() {
		return this.name;
	}
	public int getAge() {
		return this.age;
	}
	public int getYearsInService() {
		return this.serviceYears;
	}
	
}
