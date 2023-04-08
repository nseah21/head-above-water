import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;

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
        moneyStock = new Stock(8000, 0);
        approvalStock = new Stock(60, 0);
        floodProtectionInfrastructureStock = new Stock(60, 0);
        populationStock = new Stock(75000, 60000);
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
        for (int i = 0; i < Utility.LAST_ROUND; i++) {
            Scenario scenario = scenarios.get(i);
            boolean firstTime = true;
            if (checkLoseCondition()) {
                UI.printLoseLogo();
                UI.displayValues(stocks, variables);
                UI.announceLose();
                System.exit(0);
            } 
            UI.announceRoundStart(round);
            boolean lingeringEffects = scheduler.doHouseKeeping();
            pressEnterToContinue();
            if (i > 0) {
                if (simulateFlood() || lingeringEffects) {
                    sleep(500);
                    System.out.println("Here are the *updated* stocks and variables:\n");
                    sleep(500);
                    UI.displayValues(stocks, variables);
                    pressEnterToContinue();
                }
            }
            if (checkLoseCondition()) {
                UI.printLoseLogo();
                UI.displayValues(stocks, variables);
                UI.announceLose();
                System.exit(0);
            } 
            if (firstTime) {
                UI.announceScenarioStart();
            } else {
                UI.announceScenarioAgain();
            }
            UI.printScenario(scenario);
            execute(List.of(scenario.getScenarioEffect()), scheduler); 
            while (scanner.hasNextLine()) {
                String optionSelected = scanner.nextLine().toUpperCase();
                if (isInvalidSelection(optionSelected)) {
                    System.out.println("Please enter an option that is either A, B, C, or D.");
                    firstTime = false;
                    sleep(800);
                    continue;
                } else {
                    System.out.println();
                    sleep(1200);
                    System.out.println(String.format("You have selected: %s\n", scenario.getPolicy(convertSelection(optionSelected))));
                    sleep(1200);
                    UI.announceEffect();
                    System.out.println("\nThe effect is as follows:\n");
                    sleep(1300);
                    execute(scenario.getPolicy(convertSelection(optionSelected)).getUpdates(), scheduler);
                    
                    System.out.println("*" + scenario.getPolicy(convertSelection(optionSelected)).getEffect() + "*"); // abstract to UI class
                    System.out.println();
                    sleep(1200);
                    pressEnterToContinue();
                    break;
                }
            }
            UI.announceRoundEnd(round++);
            UI.displayValues(stocks, variables);
            pressEnterToContinue();
        }
        if (checkLoseCondition()) {
            UI.printLoseLogo();
            UI.displayValues(stocks, variables);
            UI.announceLose(); 
            System.exit(0);
        } else {
            UI.printWinLogo();
            UI.displayValues(stocks, variables);
            UI.announceWin(); 
            System.exit(0);
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

    private boolean checkLoseCondition() {
        for (Stock stock : stocks) {
            if (!stock.isValid()) {
                // LOSE
                return true;
            }
        }
        return false;
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

    // Taken from https://stackoverflow.com/questions/1519736/random-shuffling-of-an-array
    public static List<Scenario> shuffle(List<Scenario> scenarios) {
        Random rnd = ThreadLocalRandom.current();
        Scenario[] ar = new Scenario[scenarios.size()];
        scenarios.toArray(ar);
        for (int i = ar.length - 1; i > 0; i--)
        {
          int index = rnd.nextInt(i + 1);
          // Simple swap
          Scenario a = ar[index];
          ar[index] = ar[i];
          ar[i] = a;
        }
        return List.of(ar);
    }

    private boolean simulateFlood() {
        sleep(500);
        Random random = new Random();
        double threshold = random.nextDouble();
        // Multipliers cannot be 0 since they will be compounded
        // For floodProtectionMultiplier and riverCapacityMultiplier, the effectiveness is halved as to prevent users from thinking that infrastructure solutions are the best solution
        double floodProtectionMultiplier = Math.max(0.1, 1 - (floodProtectionInfrastructureStock.getValue() / 200));
        double greeneryLevelMultiplier = Math.max(0.1, 1 - (greeneryLevelVariable.getValue() / 100));
        double riverCapacityMultiplier = Math.max(0.1, 1 - (riverCapacityVariable.getValue() / 200));
        double landSubsidenceMultiplier = Math.max(1, 1 + landSubsidenceVariable.getValue() / 100);

        // Multiplier to flood probability
        double floodProbabilitymultiplier = greeneryLevelMultiplier * riverCapacityMultiplier * landSubsidenceMultiplier;
        // Threshold which is the probability of flooding changes when greeneryLevel, riverCapacity or landSubsidence changes
        threshold *= floodProbabilitymultiplier;

        // Since threshold already includes the multiplier effect from 3 factors, dont have to include them again 
        // floodProtection multiplier will decrease the effect of floods
        double moneyDamage = -1800 * threshold * floodProtectionMultiplier;
        double populationDamage = -2200 * threshold * floodProtectionMultiplier;
        double approvalDamage = -25 * threshold * floodProtectionMultiplier;
        double infrastructureDamage = -30 * threshold * floodProtectionMultiplier;

        boolean flooded = true;

        sleep(500);
        System.out.println();

        if (threshold > 0.55) {
            System.out.println("***OH NO! A flood has occured!***\n");
            System.out.println("The severity level is... SMALL.\n");
        } else if (threshold > 0.80) {
            System.out.println("***OH NO! A flood has occured!***\n");
            System.out.println("The severity level is... MODERATE.\n");
        } else if (threshold > 0.90) {
            System.out.println("***OH NO! A flood has occured!***\n");
            System.out.println("The severity level is... SEVERE.\n");
        } else if (threshold > 0.95) {
            System.out.println("***OH NO! A flood has occured!***\n");
            System.out.println("The severity level is... DEVASTATING.\n");
        } else {
            flooded = false;
        }

        if (flooded) {

            moneyStock.translate(moneyDamage);
            populationStock.translate(populationDamage);
            approvalStock.translate(approvalDamage);
            floodProtectionInfrastructureStock.translate(infrastructureDamage);

            sleep(500);
            System.out.println();
            System.out.println("Your stocks have suffered some damage...\n");
            System.out.println();
            sleep(500);
            System.out.printf("%-17s: %.2f\n", "MONEY", moneyDamage);
            sleep(500);
            System.out.printf("%-17s: %.2f\n", "APPROVAL", approvalDamage);
            sleep(500);
            System.out.printf("%-17s: %.2f\n", "FLOOD PROTECTION", infrastructureDamage);
            sleep(500);
            System.out.printf("%-17s: %.2f\n", "POPULATION", populationDamage);
            sleep(500);
            System.out.println("\nAfter the disaster has passed...\n");
            sleep(500);
        }

        if (flooded) {
            pressEnterToContinue();
        }

        return flooded;
    }
}