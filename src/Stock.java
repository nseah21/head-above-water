class Stock {
    private int value;
    private int threshold;

    public Stock(int value, int threshold) {
        this.value = value;
    }

    public void scale(int multiplier) {
        this.value = this.value * multiplier;
    }

    public void translate(int offset) {
        this.value = this.value + offset;
    }

    public boolean isValid() {
        return this.value < this.threshold;
    }
}