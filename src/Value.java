abstract class Value {
    protected double value;

    public Value(int value) {
        this.value = value;
    }

    public void scale(double multiplier) {
        this.value = this.value * multiplier;
    }

    public double getValue() {
        return this.value;
    }

    public void translate(double offset) {
        this.value = this.value + offset;
    }

    @Override
    public String toString() {
        return String.format("%.2f", this.value);
    }
}