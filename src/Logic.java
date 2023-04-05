import java.util.Scanner;

class Logic {
    private Scanner scanner = new Scanner(System.in);
    
    public static Stock moneyStock; 
    public static Stock approvalStock; 
    public static Stock floodProtectionInfrastructureStock;
    public static Stock populationStock;
    
    public static Variable greeneryLevelVariable; 
    public static Variable riverCapacityVariable; 
    public static Variable landSubsidenceVariable;
    
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
}