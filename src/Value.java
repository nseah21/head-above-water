abstract class Value {
    protected double value;

    public Value(int value) {
        this.value = value;
    }

    public void scale(double multiplier) {
        this.value = this.value * multiplier;
    }

    public void translate(double offset) {
        this.value = this.value + offset;
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}