/**
 * Represents an update to a stock or variable.
 * 
 * The execute method in the Logic class should take in an array of updates.
 */
class Update extends GeneralUpdate {
    private String type;
    private String operation;
    private double amount;

    public Update(String type, String operation, double amount) {
        this.type = type;
        this.operation = operation;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return this.type + (this.operation == Utility.TRANSLATE ? " was changed by " : " was multiplied by a factor of ") + (this.amount >= 0 ? "+" : "") + this.amount + (this.operation == Utility.TRANSLATE ? " units." : "."); 
    }

    public String getType() {
        return this.type;
    }

    public String getOperation() {
        return this.operation;
    }

    public double getAmount() {
        return this.amount;
    }
}