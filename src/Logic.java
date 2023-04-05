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
    
    public void init() {
        moneyStock = new Stock(10000, 0);
        approvalStock = new Stock(100, 0);
        floodProtectionInfrastructureStock = new Stock(100, 0);
        populationStock = new Stock(100000, 95000);
        greeneryLevelVariable = new Variable(0);
        riverCapacityVariable = new Variable(0);
        landSubsidenceVariable = new Variable(0);
    }

    public void start() {

    }

    public void execute(List<Update> updates) {
        for (Update update : updates) {
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

    private void update(Value value, String operation, int amount) {
        if (operation == Utility.SCALE) {
            value.scale(amount);
        } else if (operation == Utility.TRANSLATE) {
            value.translate(amount);
        } else {
            // No update occurred.
        }
    }
}