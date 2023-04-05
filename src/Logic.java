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
        round = 0;
    }

    public void start(Scheduler scheduler) {
        for (Scenario scenario : scenarios) {
            announceStart();
            scheduler.houseKeeping();
            System.out.println(scenario);
            while (scanner.hasNextLine()) {
                String optionSelected = scanner.nextLine().toUpperCase();
                if (isInvalidSelection(optionSelected)) {
                    System.out.println("Please enter an option that is either A, B, C, or D.");
                    continue;
                } else {
                    System.out.println(String.format("You have selected: %s", scenario.getPolicy(convertSelection(optionSelected))));
                    execute(scenario.getPolicy(convertSelection(optionSelected)).getUpdates(), scheduler);
                    System.out.println(scenario.getPolicy(convertSelection(optionSelected)).getEffect());
                    break;
                }
            }
            announceEnd();
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
                int amount = update.getAmount();

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

    private void update(Value value, String operation, int amount) {
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
        return optionSelected.length() > 1 || optionSelected.charAt(0) < 65 || optionSelected.charAt(0) > 67; 
    }

    private int convertSelection(String optionSelected) {
        char choice = optionSelected.charAt(0);
        return choice % 'A';
    }   

    private void announceStart() {
        System.out.printf("Welcome to round %d!\n", round);
        System.out.println();
        displayValues();
        System.out.println();
    }   

    private void announceEnd() {
        System.out.printf("We have come to the end of round %d!\n", round);
        System.out.println();
        displayValues();
        System.out.println();
        round = round + 1;
    }   

    private void displayValues() {
        System.out.println("Here are the stocks and variables you need to manage.");
        for (int i = 0; i < stocks.size(); i++) {
            System.out.println(String.format("%s: %s", Utility.VALUES.get(i), stocks.get(i)));
        }
        for (int i = stocks.size(); i < Utility.VALUES.size(); i++) {
            System.out.println(String.format("%s: %s", Utility.VALUES.get(i), variables.get(i - stocks.size())));
        }
    }
}