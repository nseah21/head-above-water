class Main {
    public static void main(String[] args) {
        Logic logic = new Logic();
        Scheduler scheduler = new Scheduler(logic);
        logic.init();
        logic.start(scheduler);
    }
}