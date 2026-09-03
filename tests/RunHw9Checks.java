import il.ac.tau.cs.sw1.ex9.riddles.forth.B4;
import il.ac.tau.cs.sw1.ex9.riddles.second.B2;
import il.ac.tau.cs.sw1.ex9.riddles.third.B3;
import il.ac.tau.cs.sw1.ex9.starfleet.Bomber;
import il.ac.tau.cs.sw1.ex9.starfleet.CrewMember;
import il.ac.tau.cs.sw1.ex9.starfleet.CrewWoman;
import il.ac.tau.cs.sw1.ex9.starfleet.Fighter;
import il.ac.tau.cs.sw1.ex9.starfleet.Officer;
import il.ac.tau.cs.sw1.ex9.starfleet.OfficerRank;
import il.ac.tau.cs.sw1.ex9.starfleet.Spaceship;
import il.ac.tau.cs.sw1.ex9.starfleet.StarfleetManager;
import il.ac.tau.cs.sw1.ex9.starfleet.TransportShip;
import il.ac.tau.cs.sw1.ex9.starfleet.Weapon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RunHw9Checks {
    public static void main(String[] args) throws Exception {
        testStarfleetModel();
        testRiddles();
        System.out.println("All HW9 checks passed");
    }

    private static void testStarfleetModel() {
        Officer ensign = new Officer("Ari", 30, 4, OfficerRank.Ensign);
        Officer captain = new Officer("Dana", 42, 15, OfficerRank.Captain);
        CrewWoman engineer = new CrewWoman(28, 3, "Maya");
        Set<CrewMember> mixedCrew = new HashSet<>(Arrays.asList(ensign, captain, engineer));
        List<Weapon> weapons = Arrays.asList(new Weapon("Laser", 10, 100), new Weapon("Torpedo", 20, 200));

        Fighter fighter = new Fighter("Falcon", 2020, 2.5f, mixedCrew, weapons);
        Bomber bomber = new Bomber("Bomber", 2019, 1.0f, mixedCrew, weapons, 2);
        TransportShip transport = new TransportShip("Cargo", 2022, 1.2f, mixedCrew, 100, 50);
        List<Spaceship> fleet = new ArrayList<>(Arrays.asList(transport, bomber, fighter));

        checkEquals(40, fighter.getFirePower(), "fighter fire power includes weapons");
        checkEquals(5300, fighter.getAnnualMaintenanceCost(), "fighter maintenance cost");
        checkEquals(5240, bomber.getAnnualMaintenanceCost(), "bomber maintenance cost");
        checkEquals(3650, transport.getAnnualMaintenanceCost(), "transport maintenance cost");

        List<String> descriptions = StarfleetManager.getShipDescriptionsSortedByFirePowerAndCommissionYear(fleet);
        check(descriptions.get(0).startsWith("Fighter"), "highest firepower ship sorted first");
        checkEquals(3, StarfleetManager.getInstanceNumberPerClass(fleet).values().stream().mapToInt(Integer::intValue).sum(),
                "instance count covers fleet");
        check(StarfleetManager.getFleetWeaponNames(fleet).contains("Laser"), "fleet weapon names include laser");
        checkEquals(9, StarfleetManager.getTotalNumberOfFleetCrewMembers(fleet), "crew members counted per ship");
        checkFloat(36.0f, StarfleetManager.getAverageAgeOfFleetOfficers(fleet), "average officer age");

        Map<Officer, Spaceship> highestRanking = StarfleetManager.getHighestRankingOfficerPerShip(fleet);
        checkEquals(fighter, highestRanking.get(captain), "captain is highest ranking fighter officer");

        List<Map.Entry<OfficerRank, Integer>> rankPopularity = StarfleetManager.getOfficerRanksSortedByPopularity(fleet);
        checkEquals(OfficerRank.Ensign, rankPopularity.get(0).getKey(), "rank popularity tie uses enum order");
        checkEquals(OfficerRank.Captain, rankPopularity.get(1).getKey(), "rank popularity includes captain");
    }

    private static void testRiddles() throws Exception {
        B2 second = new B2();
        checkEquals("HELLO", second.getA(true).foo("Hello"), "B2 true branch uppercases");
        checkEquals("hello", second.getA(false).foo("Hello"), "B2 false branch lowercases");

        B3 third = new B3("match");
        boolean threw = false;
        try {
            third.foo("match");
        } catch (B3 expected) {
            threw = true;
            checkEquals("match", expected.getMessage(), "B3 message preserves payload");
        }
        check(threw, "B3 throws itself on match");

        Iterator<String> forth = new B4(new String[] {"a", "b"}, 2);
        List<String> values = new ArrayList<>();
        while (forth.hasNext()) {
            values.add(forth.next());
        }
        checkEquals(Arrays.asList("a", "b", "a", "b"), values, "B4 cycles array k times");
    }

    private static void check(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError(message);
        }
    }

    private static void checkEquals(Object expected, Object actual, String message) {
        if (!expected.equals(actual)) {
            throw new AssertionError(message + ": expected " + expected + " but got " + actual);
        }
    }

    private static void checkFloat(float expected, float actual, String message) {
        if (Math.abs(expected - actual) > 1e-5) {
            throw new AssertionError(message + ": expected " + expected + " but got " + actual);
        }
    }
}
