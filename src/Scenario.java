class Scenario {
    private String description;
    private Policy first;
    private Policy second;
    private Policy third;
    private Policy fourth;

    public Scenario(String description, Policy first, Policy second, Policy third, Policy fourth) {
        this.description = description;
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
    }
}