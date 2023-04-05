class Variable {
    private int value;

    public Variable(int value) {
        this.value = value;
    }

    public void scale(int multiplier) {
        this.value = this.value * multiplier;
    }

    public void translate(int offset) {
        this.value = this.value + offset;
    }
}