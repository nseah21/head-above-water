import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Logic {
    private Scanner scanner = new Scanner(System.in);
    
    private Stock moneyStock; 
    private Stock approvalStock; 
    private Stock floodProtectionInfrastructureStock;
    private Stock populationStock;
    
    private Variable greeneryLevelVariable; 
    private Variable riverCapacityVariable; 
    private Variable landSubsidenceVariable; 

    private List<Stock> stocks;
    private List<Variable> variables;
    private List<Scenario> scenarios;

    private int round;
    
    public void init() {
        moneyStock = new Stock(10000, 0);
        approvalStock = new Stock(100, 0);
        floodProtectionInfrastructureStock = new Stock(100, 0);
        populationStock = new Stock(100000, 95000);
        greeneryLevelVariable = new Variable(0);
        riverCapacityVariable = new Variable(0);
        landSubsidenceVariable = new Variable(0);
        stocks = new ArrayList<>(List.of(moneyStock, approvalStock, floodProtectionInfrastructureStock, populationStock));
        variables = new ArrayList<>(List.of(greeneryLevelVariable, riverCapacityVariable, landSubsidenceVariable));
        scenarios = Utility.SCENARIO_LIST;
        round = 1;
    }

    public void start(Scheduler scheduler) {
        UI.printLogo();
        UI.announceWelcome();
        UI.announceRules();
        UI.startMansplaining();
        UI.introduceStocks();
        UI.displayValues(stocks, variables);
        pressEnterToContinue();
        for (Scenario scenario : scenarios) {
            boolean firstTime = true;
            UI.announceRoundStart(round);
            scheduler.doHouseKeeping();
            pressEnterToContinue();
            if (firstTime) {
                UI.announceScenarioStart();
            } else {
                UI.announceScenarioAgain();
            }
            UI.printScenario(scenario);
            while (scanner.hasNextLine()) {
                String optionSelected = scanner.nextLine().toUpperCase();
                if (isInvalidSelection(optionSelected)) {
                    System.out.println("Please enter an option that is either A, B, C, or D.");
                    firstTime = false;
                    sleep(800);
                    continue;
                } else {
                    System.out.println();
                    sleep(2200);
                    System.out.println(String.format("You have selected: %s\n", scenario.getPolicy(convertSelection(optionSelected))));
                    sleep(2200);
                    UI.announceEffect();
                    System.out.println("\nThe effect is as follows:\n");
                    sleep(1500);
                    execute(scenario.getPolicy(convertSelection(optionSelected)).getUpdates(), scheduler);
                    System.out.println("========================================================");
                    System.out.println(scenario.getPolicy(convertSelection(optionSelected)).getEffect()); // abstract to UI class
                    System.out.println("========================================================\n");
                    sleep(3000);
                    pressEnterToContinue();
                    break;
                }
            }
            UI.announceRoundEnd(round++);
            UI.displayValues(stocks, variables);
            pressEnterToContinue();
        }
    }

    public void execute(List<GeneralUpdate> updates, Scheduler scheduler) {
        for (GeneralUpdate generalUpdate : updates) {
            if (generalUpdate instanceof FutureUpdate) {
                scheduler.addToQueue((FutureUpdate) generalUpdate);
            } else {
                Update update = (Update) generalUpdate;
                String type = update.getType();
                String operation = update.getOperation();
                double amount = update.getAmount();

                switch (type) {
                    case Utility.MONEY:
                        update(moneyStock, operation, amount);
                        break;
                    case Utility.APPROVAL:
                        update(approvalStock, operation, amount);
                        break;
                    case Utility.FLOOD_PROTECTION_INFRASTRUCTURE:
                        update(floodProtectionInfrastructureStock, operation, amount);
                        break;
                    case Utility.POPULATION:
                        update(populationStock, operation, amount);
                        break;
                    case Utility.GREENERY_LEVEL:
                        update(greeneryLevelVariable, operation, amount);
                        break;
                    case Utility.RIVER_CAPACITY:
                        update(riverCapacityVariable, operation, amount);
                        break;
                    case Utility.LAND_SUBSIDENCE:
                        update(landSubsidenceVariable, operation, amount);
                        break;
                    default:
                        break;
                }

            }
        }
    }

    private void update(Value value, String operation, double amount) {
        if (operation == Utility.SCALE) {
            value.scale(amount);
        } else if (operation == Utility.TRANSLATE) {
            value.translate(amount);
        } else {
            // No update occurred.
        }
    }

    private void checkLoseCondition() {
        for (Stock stock : stocks) {
            if (!stock.isValid()) {
                // LOSE
            }
        }
    }

    private boolean isInvalidSelection(String optionSelected) {
        return optionSelected.length() != 1 || optionSelected.charAt(0) < 65 || optionSelected.charAt(0) > 68; 
    }

    private int convertSelection(String optionSelected) {
        char choice = optionSelected.charAt(0);
        return choice % 'A';
    }   

    private void pressEnterToContinue() {
        System.out.println("---------------------------");
        System.out.println(">>> Press enter to continue");
        System.out.println("---------------------------");
        scanner.nextLine();
    }

    public static void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            System.out.println("Thread was interrupted...");
        }
    }
}