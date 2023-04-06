class Stock extends Value {
    private int threshold;

    public Stock(int value, int threshold) {
        super(value);
        this.threshold = threshold;
    }

    public boolean isValid() {
        return this.value > this.threshold;
    }
}