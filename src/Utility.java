import java.util.ArrayList;
import java.util.List;

class Utility {
    public static final String MONEY = "Money";
    public static final String APPROVAL = "Approval";
    public static final String FLOOD_PROTECTION_INFRASTRUCTURE = "Flood protection infrastructure";
    public static final String POPULATION = "Population";
    public static final String GREENERY_LEVEL = "Greenery level";
    public static final String RIVER_CAPACITY = "River capacity";
    public static final String LAND_SUBSIDENCE  = "Land subsidence";

    public static final List<String> VALUES = List.of(MONEY, APPROVAL, FLOOD_PROTECTION_INFRASTRUCTURE, POPULATION, GREENERY_LEVEL, RIVER_CAPACITY, LAND_SUBSIDENCE);

    public static final String SCALE  = "s";
    public static final String TRANSLATE  = "t";

    public static final Scenario SCENARIO_ONE = new Scenario(
        "Test",
        new Update(MONEY, TRANSLATE, -1000),
        new Policy("Policy 1", "roblox becomes a core subject in sch", new Update(FLOOD_PROTECTION_INFRASTRUCTURE, APPROVAL, 2)),
        new Policy("Policy 2", "ur gf leaves u", new Update(FLOOD_PROTECTION_INFRASTRUCTURE, APPROVAL, 2)),
        new Policy("Policy 3", "something has happened", new Update(FLOOD_PROTECTION_INFRASTRUCTURE, APPROVAL, 2)),
        new Policy("Policy 4", "the chicken rice stall ran out of chili", new Update(FLOOD_PROTECTION_INFRASTRUCTURE, APPROVAL, 2))
    );

    public static final List<Scenario> SCENARIO_LIST = new ArrayList<>(List.of(SCENARIO_ONE));
}