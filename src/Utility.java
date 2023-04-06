import java.util.ArrayList;
import java.util.List;

class Utility {
    public static final String MONEY = "MONEY";
    public static final String APPROVAL = "APPROVAL";
    public static final String FLOOD_PROTECTION_INFRASTRUCTURE = "FLOOD PROTECTION"; // removed the trailing infrastructure word
    public static final String POPULATION = "POPULATION";
    public static final String GREENERY_LEVEL = "Greenery level";
    public static final String RIVER_CAPACITY = "River capacity";
    public static final String LAND_SUBSIDENCE  = "Land subsidence";

    public static final List<String> VALUES = List.of(MONEY, APPROVAL, FLOOD_PROTECTION_INFRASTRUCTURE, POPULATION, GREENERY_LEVEL, RIVER_CAPACITY, LAND_SUBSIDENCE);
    public static final List<Double> INITIAL_STOCKS = List.of(10000.0, 100.0, 100.0, 100000.0); 
    public static final List<Double> INITIAL_VARIABLES = List.of(0.0, 0.0, 0.0);

    public static final String SCALE  = "s";
    public static final String TRANSLATE  = "t";

    public static final int LAST_ROUND = 10;

    public static final Scenario SCENARIO_ONE = new Scenario(
        "your very first test in parliament!!!!!!!",
        new Update(MONEY, TRANSLATE, -1000),
        new Policy("\nroblox becomes a core subject in sch\n", "student council candidate gets elected for promising free ROBUX", new Update(FLOOD_PROTECTION_INFRASTRUCTURE, TRANSLATE, 2)),
        new Policy("ur gf leaves u", "u now have more money for yoself", new Update(FLOOD_PROTECTION_INFRASTRUCTURE, TRANSLATE, 2), new FutureUpdate(new Update(POPULATION, SCALE, 0.5), 1)),
        new Policy("fc wok fried has closed down...", "u died from sadness", new Update(FLOOD_PROTECTION_INFRASTRUCTURE, TRANSLATE, 2)),
        new Policy("ur room aircon spoil", "OH... your approval rating has dropped", new Update(FLOOD_PROTECTION_INFRASTRUCTURE, TRANSLATE, 2))
    );

    public static final Scenario SCENARIO_TWO = new Scenario(
        "Test",
        new Update(MONEY, TRANSLATE, -1000),
        new Policy("Policy 1", "hehe jiraiya vs pain", new Update(FLOOD_PROTECTION_INFRASTRUCTURE, TRANSLATE, 2)),
        new Policy("Policy 2", "ur bf leaves u", new Update(FLOOD_PROTECTION_INFRASTRUCTURE, TRANSLATE, 2), new FutureUpdate(new Update(POPULATION, SCALE, 2), 1)),
        new Policy("Policy 3", "something has NOT happened", new Update(FLOOD_PROTECTION_INFRASTRUCTURE, TRANSLATE, 2)),
        new Policy("Policy 4", "the duck rice stall ran out of chili", new Update(FLOOD_PROTECTION_INFRASTRUCTURE, TRANSLATE, 2))
    );

    public static final List<Scenario> SCENARIO_LIST = new ArrayList<>(List.of(SCENARIO_ONE, SCENARIO_TWO));
}