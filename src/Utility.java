import java.util.ArrayList;
import java.util.List;

class Utility {
    public static final String MONEY = "MONEY";
    public static final String APPROVAL = "APPROVAL";
    public static final String FLOOD_PROTECTION_INFRASTRUCTURE = "FLOOD PROTECTION"; // removed the trailing infrastructure word
    public static final String POPULATION = "POPULATION";
    public static final String GREENERY_LEVEL = "Greenery Level";
    public static final String RIVER_CAPACITY = "River Capacity";
    public static final String LAND_SUBSIDENCE  = "Land Subsidence";

    public static final List<String> VALUES = List.of(MONEY, APPROVAL, FLOOD_PROTECTION_INFRASTRUCTURE, POPULATION, GREENERY_LEVEL, RIVER_CAPACITY, LAND_SUBSIDENCE);
    public static final List<Double> INITIAL_STOCKS = List.of(8000.0, 60.0, 60.0, 75000.0); 
    public static final List<Double> INITIAL_VARIABLES = List.of(0.0, 0.0, 0.0);

    // Scale and translate corespond to multiply and add
    public static final String SCALE  = "s";
    public static final String TRANSLATE  = "t";

    public static final int LAST_ROUND = 11;

    // Scenario 1: Political Pressure

    // Default fall value
    public static int defaultChangeOne = -5;

    // Variables for policy 1:
    public static int moneyChangeOneOne = -500;
    public static int riverCapacityChangeOneOne = 5;
    public static int firstFallOneOne = -2;
    public static int secondFallOneOne = -3;
    public static int approvalChangeOneOne = 5;

    // Variables for policy 2:
    public static int approvalChangeOneTwo = 5;

    // Variables for policy 3:
    public static int moneyChangeOneThree = -5000;
    public static int approvalChangeOneThree = 10;
    public static int landSubsidenceChangeOneThree = 10;
    public static int riverCapacityChangeOneThree = 5;

    public static final Scenario SCENARIO_ONE = new Scenario(
        "Given the history of floods in Jakarta, your political opponents aim to make you lose support by claiming that your party is not doing anything to combat the flood situation! This causes your APPROVAL to decrease by 5.\n",
        // check this first argument thing
        new Update(APPROVAL, TRANSLATE, defaultChangeOne),
        new Policy("Initiate your plans for dredging, it will cost you $500", "Due to your dredging efforts, River Capacity and APPROVAL increased!", new Update(RIVER_CAPACITY, TRANSLATE, riverCapacityChangeOneOne), new Update(MONEY, TRANSLATE, moneyChangeOneOne), new Update(APPROVAL, TRANSLATE, approvalChangeOneOne), new FutureUpdate(new Update(RIVER_CAPACITY, TRANSLATE, firstFallOneOne), 1), new FutureUpdate(new Update(RIVER_CAPACITY, TRANSLATE, secondFallOneOne), 2)),
        new Policy("Have a discussion with your political opponents in parliament and broadcast the discussion to your people", "This debate has given your people a good impression of your government! APPROVAL increases!",new Update(APPROVAL, TRANSLATE, approvalChangeOneTwo)),
        new Policy("Invest in a long term canalisation project to appease your opponents and safeguard your people against floods, it will cost you $5000", "This policy has impressed your political opponents and your people! APPROVAL increases!", new Update(MONEY, TRANSLATE, moneyChangeOneThree), new Update(APPROVAL, TRANSLATE, approvalChangeOneThree), new FutureUpdate(new Update(LAND_SUBSIDENCE, TRANSLATE, landSubsidenceChangeOneThree/3), 1), new FutureUpdate(new Update(LAND_SUBSIDENCE, TRANSLATE, landSubsidenceChangeOneThree/3), 2), new FutureUpdate(new Update(LAND_SUBSIDENCE, TRANSLATE, landSubsidenceChangeOneThree/3), 3), new FutureUpdate(new Update(RIVER_CAPACITY, TRANSLATE, riverCapacityChangeOneThree), 3)),
        new Policy("Do nothing and hope for the best", "Your people are angry that you did not do anything. Your approval rating has dropped further.", new Update(APPROVAL, TRANSLATE, -5))
    );

    // Scenario 2: Social Unrest

    // Default fall value
    public static int defaultChangeTwo = -10;

    // Variables for policy 1:
    public static int moneyChangeTwoOne = -1000; 
    public static int floodProtectionTwoOne = 2;
    public static int approvalChangeTwoOne = 5;

    // Variables for policy 2:
    public static int moneyChangeTwoTwo = -1000;
    public static int approvalChangeTwoTwo = -10;

    // Variables for policy 3:
    public static int moneyChangeTwoThree = -5000;
    public static int approvalChangeTwoThree = -10;
    public static int greeneryChangeTwoThree = 20;

    public static final Scenario SCENARIO_TWO = new Scenario(
        "The citizens are angry at your government for the insufficient flood infrastructure, and feel that they are not adequately protected. They are gearing up for a protest against you. This causes your approval rating to decrease by 10.\n",
    
        new Update(APPROVAL, TRANSLATE, defaultChangeTwo),
        new Policy("Build better drainage infrastucture to deal with stormwater runoff, it will cost you $1000", "As a result of your investment, APPROVAL and FLOOD PROTECTION increased!", new Update(FLOOD_PROTECTION_INFRASTRUCTURE, TRANSLATE, floodProtectionTwoOne), new Update(MONEY, TRANSLATE, moneyChangeTwoOne), new Update(APPROVAL, TRANSLATE, approvalChangeTwoOne)),
        new Policy("Pay the local media to inform the public about the policies and flood infrastructure that are in place. It will cost you $1000", "The public is already aware of these policies and feel that it is insufficient. Now they are convinced that you do not understand the situation on the ground. APPROVAL decreases.", new Update(APPROVAL, TRANSLATE, approvalChangeTwoTwo), new Update(MONEY, TRANSLATE, moneyChangeTwoTwo)),
        new Policy("Ignore the current problem and carry out naturalisation in your city to build long term flood infrastructure protection. It will cost you $5000", "Your people are still living with the fear of flood. APPROVAL decreases.", new Update(MONEY, TRANSLATE, moneyChangeTwoThree), new Update(APPROVAL, TRANSLATE, approvalChangeTwoThree), new FutureUpdate(new Update(GREENERY_LEVEL, TRANSLATE, greeneryChangeTwoThree), 4)),
        new Policy("Do nothing", "Your people are not happy with you for ignoring them. APPROVAL decreases.", new Update(APPROVAL, TRANSLATE, -10))
    );

    // Scenario 3: Economic Boom

    // Default Value
    public static int defaultChangeThree = 5000;

    // Variables for policy 1:
    public static int approvalChangeThreeOne = 5;
    public static int moneyChangeThreeOne = -500;

    // Variables for policy 2:
    public static int approvalChangeThreeTwo = 5;
    public static int moneyChangeThreeTwo = -1500;

    // Variables for policy 3:
    public static int approvalChangeThreeThree = 5;
    public static int moneyChangeThreeThree = -3000;
    public static int floodProtectionThreeThree = 10;

    public static final Scenario SCENARIO_THREE = new Scenario(
        "Your country experiences an economic boom! You have collected more taxes this turn! MONEY increases by $5000.\n",
        new Update(MONEY, TRANSLATE, defaultChangeThree),
        new Policy("Spend it on your political party as they deserve it. It will cost you $500", "Your members become more motivated and engages their communities more. APPROVAL increases.", new Update(APPROVAL, TRANSLATE, approvalChangeThreeOne), new Update(MONEY, TRANSLATE, moneyChangeThreeOne)),
        new Policy("Provide subsidies to those who have been affected by severe floods in the past. It will cost you $1500", "Your people have a better impression of you. APPROVAL increases", new Update(APPROVAL, TRANSLATE, approvalChangeThreeTwo), new Update(MONEY, TRANSLATE, moneyChangeThreeTwo)),
        new Policy("Build a detention basin to help with flood protection but the effects will only take place 3 turns later. It will cost $3000", "Your people are happy that you have built a detention basin. APPROVAL increases.", new Update(MONEY, TRANSLATE, moneyChangeThreeThree), new Update(APPROVAL, TRANSLATE, approvalChangeThreeThree), new FutureUpdate(new Update(FLOOD_PROTECTION_INFRASTRUCTURE, TRANSLATE, floodProtectionThreeThree), 3)),
        new Policy("Do nothing", "Nothing happens")
    );

    // Scenario 4: Economic Recession

    // Default Value
    public static int defaultChangeFour = -2000;

    // Variables for policy 1:
    public static int approvalChangeFourOne = 5; 
    public static int moneyChangeFourOne = -1000;

    // Variables for policy 2:
    public static int approvalChangeFourTwo = 5;
    public static int moneyChangeFourTwo = -1500;

    // Variables for policy 3:
    public static int approvalChangeFourThree = -5;
    public static int moneyChangeFourThree = -2000;
    public static int greeneryChangeFourThree = 3;

    public static final Scenario SCENARIO_FOUR = new Scenario(
        "Your country experiences a recession. You have to use some of your money to bail your people out. MONEY decreases by $2000.\n",
        new Update(MONEY, TRANSLATE, defaultChangeFour),
        new Policy("Provide subsidies for your people to tide them through the recession. It will cost you $1000", "Your people are glad that you have their backs. APPROVAL increases.", new Update(APPROVAL, TRANSLATE, approvalChangeFourOne), new Update(MONEY, TRANSLATE, moneyChangeFourOne)),
        new Policy("Borrow money from the IMF to provide subsidies for your people. It will cost you $1500 over 3 turns instead", "Your people are glad that you have their backs. APPROVAL increases.", new Update(APPROVAL, TRANSLATE, approvalChangeFourTwo), new FutureUpdate(new Update(MONEY, TRANSLATE, moneyChangeFourTwo/3), 1), new FutureUpdate(new Update(MONEY, TRANSLATE, moneyChangeFourTwo/3), 2), new FutureUpdate(new Update(MONEY, TRANSLATE, moneyChangeFourTwo/3), 3)),
        new Policy("Remain committed to your plans to protect your people from flooding. Invest in naturalization projects whose effects will only be seen after 3 turns. It will cost you $2000", "Your people are angry that you do not care about them during the recession. APPROVAL falls.", new Update(APPROVAL, TRANSLATE, approvalChangeFourThree), new Update(MONEY, TRANSLATE, moneyChangeFourThree), new FutureUpdate(new Update(GREENERY_LEVEL, TRANSLATE, greeneryChangeFourThree), 3)),
        new Policy("Do nothing.", "Your people are unhappy that you are not helping them during the recession. APPROVAL falls.", new Update(APPROVAL, TRANSLATE, -5))
    );

    // Scenario 5: Conflict of interest

    // Default value:
    public static int defaultChangeFive = 0;

    // Variables for policy 1:
    public static int moneyChangeFiveOne = -1000;

    // Variables for policy 2:
    public static int approvalChangeFiveTwo = -10;
    public static int moneyChangeFiveTwo = -500;

    // Variables for policy 3:
    public static int approvalChangeFiveThree = 5;
    public static int moneyChangeFiveThree = -1000;
    public static int floodProtectionFiveThree = 2;


    public static final Scenario SCENARIO_FIVE = new Scenario(
        "Your hometown has just experienced a serious flood but that region is out of your jurisdiction. You feel a sense of loss for your family and friends back home.\n",
        new Update(MONEY, TRANSLATE, defaultChangeFive),
        new Policy("Secretly channel some money to help the people in your hometown. It will cost $1000.", "Luckily, your actions are not noticed by the auditors. Nothing happens.", new Update(MONEY, TRANSLATE, moneyChangeFiveOne)),
        new Policy("Convince an opposition party politician to help your town. It will cost you $500.", "The opposing politician pockets the money for himself and announces that you tried to bribe him. APPROVAL falls.", new Update(APPROVAL, TRANSLATE, approvalChangeFiveTwo), new Update(MONEY, TRANSLATE, moneyChangeFiveTwo)),
        new Policy("Build drainage infrastructure in your own region to ensure that such floods occur less frequently. It will cost $1000. You are disappointed that you can do nothing to help your hometown.", "As a result of your efforts, FLOOD PROTECTION and APPROVAL increases.", new Update(MONEY, TRANSLATE, moneyChangeFiveThree), new Update(APPROVAL, TRANSLATE, approvalChangeFiveThree), new Update(FLOOD_PROTECTION_INFRASTRUCTURE, TRANSLATE, floodProtectionFiveThree)),
        new Policy("Do nothing", "Nothing happens")
    );

    // Scenario 6: People living unlawfully at catchment areas

    // Default value:
    public static int defaultChangeSix = -1000;

    // Variables for policy 1:
    public static int populationChangeSixOne = -10000;
    public static int approvalChangeSixOne = -5;

    // Variables for policy 2:
    public static int moneyChangeSixTwo = -1000;
    public static int floodProtectionSixTwo = 1; 
    public static int approvalChangeSixTwo = 5;

    // Variables for policy 3:
    public static int moneyChangeSixThree = -2000;
    public static int approvalChangeSixThree = 5;

    public static final Scenario SCENARIO_SIX = new Scenario(
        "In a recent flood, many illegal squatters residing near the rivers (that previously refused to be relocated) have died. Population decreases by 1000.\n",
        new Update(POPULATION, TRANSLATE, defaultChangeSix),
        new Policy("To prevent such events from happening again, pass a law that makes it illegal to live near the rivers and remove these people.", "As a result of your actions, those people have moved out of Jakarta. Addtionally, your actions are noticed by your people who are angry that you did such things. POPULATION and APPROVAL decrases.", new Update(POPULATION, TRANSLATE, populationChangeSixOne), new Update(APPROVAL, TRANSLATE, approvalChangeSixOne)),
        new Policy("To protect these people from future floods, build flood barriers for them. This will cost you $1000.", "APPROVAL and FLOOD PROTECTION increases.", new Update(MONEY, TRANSLATE, moneyChangeSixTwo), new Update(FLOOD_PROTECTION_INFRASTRUCTURE, TRANSLATE, floodProtectionSixTwo), new Update(APPROVAL, TRANSLATE, approvalChangeSixTwo)),
        new Policy("Educate the population of the dangers of residing near the rivers in Jakarta and what they can do to allevaite the effects of floods. It will cost you $2000.", "Your people are glad that you tried to educate them about the dangers of floods. APPROVAL increases.", new Update(MONEY, TRANSLATE, moneyChangeSixThree), new Update(APPROVAL, TRANSLATE, approvalChangeSixThree)),
        new Policy("Do nothing", "Another flood occurs. More people are dead and your people are outraged. POPULATION and APPROVAL falls.", new Update(APPROVAL, TRANSLATE, -10), new Update(POPULATION, TRANSLATE, -2000))
    );

    // Scenario 7: MNC wants to come over and invest

    // Default Value:
    public static int defaultChangeSeven = 0;

    // Variables for policy 1:
    public static int moneyChangeSevenOne = 1000;
    public static int approvalChangeSevenOne = 8;
    public static int landSubsidenceChangeSevenOne = 5;

    // Variables for policy 2:
    public static int moneyChangeSevenTwo = 800;
    public static int approvalChangeSevenTwo = 8;
    public static int landSubsidenceChangeSevenTwo = 3;

    // Variables for policy 3:
    public static int approvalChangeSevenThree = -5;

    public static final Scenario SCENARIO_SEVEN = new Scenario(
        "A multinational company is looking to set up their base of operations in Jakarta. Although it will encourage economic growth and create jobs, they will be building many concrete structures in Jakarta.\n",
        new Update(MONEY, TRANSLATE, defaultChangeSeven),
        new Policy("Agree fully to let the company build whatever they want in Jakarta.", "Your people are happy that they have more jobs and there is an economic boom for the next 3 turns. However, land subsidence occurs for the next 5 turns. APPROVAL increase. MONEY increases for the next 3 turns. Land Subsidence increases for the next 5 turns", new Update(APPROVAL, TRANSLATE, approvalChangeSevenOne), new FutureUpdate(new Update(MONEY, TRANSLATE, moneyChangeSevenOne), 1), new FutureUpdate(new Update(MONEY, TRANSLATE, moneyChangeSevenOne), 2), new FutureUpdate(new Update(MONEY, TRANSLATE, moneyChangeSevenOne), 3), new FutureUpdate(new Update(LAND_SUBSIDENCE, TRANSLATE, landSubsidenceChangeSevenOne), 1), new FutureUpdate(new Update(LAND_SUBSIDENCE, TRANSLATE, landSubsidenceChangeSevenOne), 2), new FutureUpdate(new Update(LAND_SUBSIDENCE, TRANSLATE, landSubsidenceChangeSevenOne), 3), new FutureUpdate(new Update(LAND_SUBSIDENCE, TRANSLATE, landSubsidenceChangeSevenOne), 4), new FutureUpdate(new Update(LAND_SUBSIDENCE, TRANSLATE, landSubsidenceChangeSevenOne), 5)),
        new Policy("Agree to let the company operate in Jakarta but they will operate under a stricter guideline such as restricting groundwater extraction.", "Your people are happy that they have more jobs and there is an econmic boom over the next 2 turns. However, land subsidence occurs over the next 3 turns.\n APPROVAL, MONEY and Land Subsidence increase.\nMONEY increases over the next 2 turns", new Update(APPROVAL, TRANSLATE, approvalChangeSevenTwo), new FutureUpdate(new Update(MONEY, TRANSLATE, moneyChangeSevenTwo), 1), new FutureUpdate(new Update(MONEY, TRANSLATE, moneyChangeSevenTwo), 2), new FutureUpdate(new Update(LAND_SUBSIDENCE, TRANSLATE, landSubsidenceChangeSevenTwo), 1), new FutureUpdate(new Update(LAND_SUBSIDENCE, TRANSLATE, landSubsidenceChangeSevenTwo), 2), new FutureUpdate(new Update(LAND_SUBSIDENCE, TRANSLATE, landSubsidenceChangeSevenTwo), 3)),
        new Policy("Do not allow the company to operate in Jakarta as the cost outweighs the benefits", "Your people are unhappy as they think that this is a good opportunity. APPROVAL decreases.", new Update(APPROVAL, TRANSLATE, approvalChangeSevenThree)),
        new Policy("Do nothing", "Nothing happens.")
    );

    // Scenario 8: Land Subsidies

    // Default Value:
    public static int defaultChangeEight = -20;

    // Variables for policy 2:
    public static int greeneryChangeEightTwo = 10;
    public static int moneyChangeEightTwo = -4000;
    public static int approvalChangeEightTwo = 5;

    // Variables for policy 3:
    public static int moneyChangeEightThree = -5000;

    public static final Scenario SCENARIO_EIGHT = new Scenario(
        "As buidling in Jakarta gets older, buildings are unable to withstand floods as well as the past. As a result, FLOOD PROTECTION decreases.\n",
        new Update(FLOOD_PROTECTION_INFRASTRUCTURE, TRANSLATE, defaultChangeEight),
        new Policy("Restrict the construction of new urban buidlings until the old ones are able to withstand floods.", "Nothing happens"),
        new Policy("Invest in green spaces around Jakarta so that natural flood protection increases. However, the effects of this policy will only come in after 3 turns. This will cost $4000", "As a result, Greenery Level increases, APPROVAL increases as the city becomes prettier.", new Update(MONEY, TRANSLATE, moneyChangeEightTwo), new FutureUpdate(new Update(APPROVAL, TRANSLATE, approvalChangeEightTwo), 3), new FutureUpdate(new Update(GREENERY_LEVEL, TRANSLATE, greeneryChangeEightTwo), 3)),
        new Policy("Develop areas around the city to free up space for more naturalisation projects. This will cost you $5000.", "MONEY decreases.", new Update(MONEY, TRANSLATE, moneyChangeEightThree)),
        new Policy("Do nothing.", "Another flood hits soon after this, many people died, POPULATION decreases.", new Update(POPULATION, TRANSLATE, -2000))
    );

    // Scenario 9: EMPTY

    // Default value:
    public static int defaultChangeNine = 0;

    // Variables for policy 1:
    public static int riverCapacityChangeNineOne = 5;
    public static int moneyChangeNineOne = -500;
    public static int riverCapacityChangeNineOneOne = -2;
    public static int riverCapacityChangeNineOneTwo = -3;
    public static int approvalChangeNineOne = 5;

    // Variables for policy 2:
    public static int moneyChangeNineTwo = -3000;
    public static int riverCapacityChangeNineTwo = 10;
    public static int approvalChangeNineTwo = 5;
    public static int landSubsidenceChangeNineTwo = 10;

    // Variables for policy 3:
    public static int moneyChangeNineThree = -3000;
    public static int approvalChangeNineThree = -10;
    public static int greeneryChangeNineThree = 20;

    public static final Scenario SCENARIO_NINE = new Scenario(
        "There are no events that require your attention. You are able to take a breather and re-evaluate your flood protection policies.\n",
        new Update(MONEY, TRANSLATE, defaultChangeNine),
        new Policy("Continue dredging to increase river capcity. This will cost you $500.", "Your people are glad that the risk of floods are lower. APPROVAL increases.", new Update(MONEY, TRANSLATE, moneyChangeNineOne), new Update(APPROVAL, TRANSLATE, approvalChangeNineOne), new Update(RIVER_CAPACITY, TRANSLATE, riverCapacityChangeNineOne), new FutureUpdate(new Update(RIVER_CAPACITY, TRANSLATE, riverCapacityChangeNineOneOne), 1), new FutureUpdate(new Update(RIVER_CAPACITY, TRANSLATE, riverCapacityChangeNineOneTwo), 2)),
        new Policy("Continue investing in NORMALISATION policies. The effects will only be seen 3 turns later. This will cost you $3000.", "Your people are glad that the risk of floods are lower. APPROVAL increases.", new Update(APPROVAL, TRANSLATE, approvalChangeNineTwo), new Update(MONEY, TRANSLATE, moneyChangeNineTwo), new FutureUpdate(new Update(RIVER_CAPACITY, TRANSLATE, riverCapacityChangeNineTwo), 3), new FutureUpdate(new Update(LAND_SUBSIDENCE, TRANSLATE, landSubsidenceChangeNineTwo), 3)),
        new Policy("Contiunue investing in NATURALISATION policies. The effects will only be seen 3 turns later. This will cost you $3000.", "Your people do not think that this will protect them from floods. APPROVAL decreases.", new Update(MONEY, TRANSLATE, moneyChangeNineThree), new Update(APPROVAL, TRANSLATE, approvalChangeNineThree), new FutureUpdate(new Update(GREENERY_LEVEL, TRANSLATE, greeneryChangeNineThree), 3)),
        new Policy("Do nothing.", "Nothing occurs")
    );

    // Scenario 10: Sense of security

    // Default Value:
    public static int defaultChangeTen = 0;

    // Variables for policy 1:
    public static int moneyChangeTenOne = -1000;
    public static int approvalChangeTenOne = 5;
    public static int floodProtectionTenOne = 1;

    // Variables for policy 2:
    public static int approvalChangeTenTwo = 2;

    // Variables for policy 3:
    public static int moneyChangeTenThree = -1000;
    public static int riverCapacityChangeTenThree = 5;
    public static int approvalChangeTenThree = 5;
    public static int riverCapacityChangeTenThreeOne = -2;
    public static int riverCapacityChangeTenThreeTwo = -3;

    public static final Scenario SCENARIO_TEN = new Scenario(
        "Severe flood has broken out in the neighbouring region, your people are worried that they will be next.\n",
        new Update(MONEY, TRANSLATE, defaultChangeTen),
        new Policy("Build flood barriers to improve FLOOD INFRASTRUCTURE. This will cost you $1000.", "Your people are happy as they now feel safer from floods. APPROVAL increases.", new Update(FLOOD_PROTECTION_INFRASTRUCTURE, TRANSLATE, floodProtectionTenOne), new Update(MONEY, TRANSLATE, moneyChangeTenOne), new Update(APPROVAL, TRANSLATE, approvalChangeTenOne)),
        new Policy("Assure your people that they are safe here and the probability of floods occuring is low.", "Your people feel reassured by your comments. APPROVAL increases.", new Update(APPROVAL, TRANSLATE, approvalChangeTenTwo)),
        new Policy("Engage in dredging to increase River Capacity. This will cost you $1000.", "Your people feel safer from floods now. APPROVAL increases.", new Update(MONEY, TRANSLATE, moneyChangeTenThree), new Update(APPROVAL, TRANSLATE, approvalChangeTenThree), new Update(RIVER_CAPACITY, TRANSLATE, riverCapacityChangeTenThree)),
        new Policy("Do nothing.", "Your people are now more afraid of floods and their view of the government has gotten worse. APPROVAL decreases. ", new Update(APPROVAL, TRANSLATE, -10), new FutureUpdate(new Update(RIVER_CAPACITY, TRANSLATE, riverCapacityChangeTenThreeOne), 1), new FutureUpdate(new Update(RIVER_CAPACITY, TRANSLATE, riverCapacityChangeTenThreeTwo), 2))
    );

    // Scenario 11: Sea Level Rise

    // Default value:
    public static int defaultChangeElevenOne = -2000;
    public static int defaultChangeElevenTwo = -20;

    // Variables for policy 1:
    public static int approvalChangeElevenOne = 5;
    public static int moneyChangeElevenOne = -2000;

    // Variables for policy 2:
    public static int approvalChangeElevenTwo = 5;
    public static int moneyChangeElevenTwo = -2000;
    public static int floodProtectionElevenTwo = 5;

    // Variables for policy 3:
    public static int approvalChangeElevenThree = 5;
    public static int floodProtectionElevenThree = 10;
    public static int moneyChangeElevenThree = -7000;

    public static final Scenario SCENARIO_ELEVEN = new Scenario(
        "Due to a rise in sea level, low-lying areas have flooded more severely and POPULATION decreases by 2000. Additionally, FLOOD PROTECTION decreases as infrastructures are now less effective. FLOOD PROTECTION decreases by 20.\n",
        new Update(POPULATION, TRANSLATE, defaultChangeElevenOne),
        new Policy("Relocate those living in areas that have major risks of flooding. This will cost you $2000.", "Your swift action has impressed your people and APPROVAL increaases.", new Update(APPROVAL, TRANSLATE, approvalChangeElevenOne), new Update(MONEY, TRANSLATE, moneyChangeElevenOne), new Update(FLOOD_PROTECTION_INFRASTRUCTURE, TRANSLATE, defaultChangeElevenTwo)),
        new Policy("Build taller seawalls to protect those living in areas that have major risks of flooding. This will cost you $2000.", "Your swift action has impressed your people and APPROVAL increases.", new Update(APPROVAL, TRANSLATE, approvalChangeElevenTwo), new Update(MONEY, TRANSLATE, moneyChangeElevenTwo), new Update(FLOOD_PROTECTION_INFRASTRUCTURE, TRANSLATE, defaultChangeElevenTwo), new Update(FLOOD_PROTECTION_INFRASTRUCTURE, TRANSLATE, floodProtectionElevenTwo)),
        new Policy("Build a Jakarta Barrage to act as a dam. This will cost you $7000.", "APPROVAL and FLOOD PROTECTION increases.", new Update(MONEY, TRANSLATE, moneyChangeElevenThree), new Update(APPROVAL, TRANSLATE, approvalChangeElevenThree), new Update(FLOOD_PROTECTION_INFRASTRUCTURE, TRANSLATE, floodProtectionElevenThree)),
        new Policy("Do nothing", "Your people lose faith in the government to protect them from floods. APPROVAL decreases.", new Update(APPROVAL, TRANSLATE, -10))
    );

    public static final List<Scenario> CHRONOLOGICAL_SCENARIO_LIST = new ArrayList<>(List.of(SCENARIO_ONE, SCENARIO_TWO, SCENARIO_THREE, SCENARIO_FOUR,
                                                                                SCENARIO_FIVE, SCENARIO_SIX, SCENARIO_SEVEN, SCENARIO_EIGHT, 
                                                                                SCENARIO_NINE, SCENARIO_TEN, SCENARIO_ELEVEN));

    public static final List<Scenario> SCENARIO_LIST = Logic.shuffle(CHRONOLOGICAL_SCENARIO_LIST);
}