/**
 * Represents an update to a stock or variable.
 * 
 * The execute method in the Logic class should take in an array of updates.
 */
class Update {
    private String type;
    private String operation;
    private int amount;

    public Update(String type, String operation, int amount) {
        this.type = type;
        this.operation = operation;
        this.amount = amount;
    }

    public String getType() {
        return this.type;
    }

    public String getOperation() {
        return this.operation;
    }

    public int getAmount() {
        return this.amount;
    }
}