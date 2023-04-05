abstract class Value {
    protected int value;

    public Value(int value) {
        this.value = value;
    }

    public void scale(int multiplier) {
        this.value = this.value * multiplier;
    }

    public void translate(int offset) {
        this.value = this.value + offset;
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }
}