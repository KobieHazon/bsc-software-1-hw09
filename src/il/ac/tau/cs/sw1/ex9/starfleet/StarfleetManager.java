package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class StarfleetManager {

	/**
	 * Returns a list containing string representation of all fleet ships, sorted in descending order by
	 * fire power, and then in descending order by commission year, and finally in ascending order by
	 * name
	 */
	public static List<String> getShipDescriptionsSortedByFirePowerAndCommissionYear (Collection<Spaceship> fleet) {
		List<Spaceship> compFleet = new ArrayList<Spaceship>();
		for (Spaceship ship: fleet) {
			compFleet.add(ship);
		}
		List<String> shipDesc = new ArrayList<String>();
		Collections.sort(compFleet, new Comparator<Spaceship>() {

			@Override
			public int compare(Spaceship o1, Spaceship o2) {
				if (o1.getFirePower() < o2.getFirePower()) 
					return 1;
				else if (o1.getFirePower() > o2.getFirePower()) 
					return -1;
				else {
					if (o1.getCommissionYear() < o2.getCommissionYear())
						return 1;
					else if (o1.getCommissionYear() > o2.getCommissionYear()) 
						return -1;
					else
						return o1.getName().compareTo(o2.getName());
				}
			}
		});
		for (Spaceship ship: compFleet) {
			shipDesc.add(ship.toString());
		}
		return shipDesc;
	}

	/**
	 * Returns a map containing ship type names as keys (the class name) and the number of instances created for each type as values
	 */
	public static Map<String, Integer> getInstanceNumberPerClass(Collection<Spaceship> fleet) {
		Map<String, Integer> counts = new HashMap<String, Integer>();
		for (Spaceship ship: fleet) {
			if (counts.containsKey(ship.getClass().getSimpleName())) {
				counts.put(ship.getClass().getSimpleName(), counts.get(ship.getClass().getSimpleName()) + 1);
			}
			else {
				counts.put(ship.getClass().getSimpleName(), 1);
			}
		}
		return counts;
	}


	/**
	 * Returns the total annual maintenance cost of the fleet (which is the sum of maintenance costs of all the fleet's ships)
	 */
	public static int getTotalMaintenanceCost (Collection<Spaceship> fleet) {
		int sum = 0;
		for (Spaceship ship: fleet) {
			sum += ship.getAnnualMaintenanceCost();
		}
		return sum;
	}


	/**
	 * Returns a set containing the names of all the fleet's weapons installed on any ship
	 */
	public static Set<String> getFleetWeaponNames(Collection<Spaceship> fleet) {
		Set<String> weaponNames = new HashSet<String>();
		for (Spaceship ship: fleet) {
			if (AbstractBattleSpaceship.class.isAssignableFrom(ship.getClass())) {
				AbstractBattleSpaceship tmp =  (AbstractBattleSpaceship) ship;
				for (Weapon weapon: tmp.getWeapon()) {
					if (!weaponNames.contains(weapon.getName()))
						weaponNames.add(weapon.getName());
				}
			}
		}
		return weaponNames;
	}

	/*
	 * Returns the total number of crew-members serving on board of the given fleet's ships.
	 */
	public static int getTotalNumberOfFleetCrewMembers(Collection<Spaceship> fleet) {
		int sum = 0;
		for (Spaceship ship: fleet) {
			sum += ship.getCrewMembers().size();
		}
		return sum;

	}

	/*
	 * Returns the average age of all officers serving on board of the given fleet's ships. 
	 */
	public static float getAverageAgeOfFleetOfficers(Collection<Spaceship> fleet) {
		int ageSum = 0;
		int cnt = 0;
		for (Spaceship ship: fleet) {
			for (CrewMember member: ship.getCrewMembers()) {
				if (member instanceof Officer) {
					Officer tmp = (Officer) member;
					ageSum += tmp.getAge();
					cnt++;
				}
			}
		}
		return (float)ageSum/cnt;
	}

	/*
	 * Returns a map mapping the highest ranking officer on each ship (as keys), to his ship (as values).
	 */
	public static Map<Officer, Spaceship> getHighestRankingOfficerPerShip(Collection<Spaceship> fleet) {
		Map<Officer, Spaceship> highestRank = new HashMap<Officer, Spaceship>();
		List<Officer> officersOnShip = new ArrayList<Officer>();
		for (Spaceship ship: fleet) {
			officersOnShip = new ArrayList<Officer>();
			for (CrewMember member: ship.getCrewMembers()) {
				if (member instanceof Officer) {
					Officer tmp = (Officer) member;
					officersOnShip.add(tmp);
				}

			}
			if (officersOnShip.size() != 0) {
				Collections.sort(officersOnShip, new Comparator<Officer>() {
					
					@Override
					public int compare(Officer o1, Officer o2) {
						return o1.getRank().compareTo(o2.getRank());
					}});
				highestRank.put(officersOnShip.get(officersOnShip.size()-1), ship);
			}
		}
		return highestRank;
	}

	/*
	 * Returns a List of entries representing ranks and their occurrences.
	 * Each entry represents a pair composed of an officer rank, and the number of its occurrences among starfleet personnel.
	 * The returned list is sorted ascendingly based on the number of occurrences.
	 */
	public static List<Map.Entry<OfficerRank, Integer>> getOfficerRanksSortedByPopularity(Collection<Spaceship> fleet) {
		Map<OfficerRank, Integer> rankTimes = new HashMap<OfficerRank, Integer>();
		for (Spaceship ship: fleet) {
			for (CrewMember member: ship.getCrewMembers()) {
				if (member instanceof Officer) {
					Officer officer = (Officer) member;
					if (rankTimes.containsKey(officer.getRank())) {
						rankTimes.put(officer.getRank(), rankTimes.get(officer.getRank()) + 1);
					}
					else {
						rankTimes.put(officer.getRank(), 1);
					}
				}
			}
		}
		List<Map.Entry<OfficerRank, Integer>> popularity = new ArrayList<Map.Entry<OfficerRank, Integer>>();
		popularity.addAll(rankTimes.entrySet());
		Collections.sort(popularity, new Comparator<Map.Entry<OfficerRank, Integer>>() {

			@Override
			public int compare(Entry<OfficerRank, Integer> o1, Entry<OfficerRank, Integer> o2) {
				if (o1.getValue().compareTo(o2.getValue()) == 0)
					return o1.getKey().compareTo(o2.getKey());
				else
					return o1.getValue().compareTo(o2.getValue());
			}
			
		});
		return popularity;
	}

}
