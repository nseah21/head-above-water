class FutureUpdate extends GeneralUpdate implements Comparable<FutureUpdate>  {
    private Update update;
    private int countdown;

    public FutureUpdate(Update update, int countdown) {
        this.update = update;
        this.countdown = countdown;        
    }

    @Override
    public String toString() {
        return this.update.toString();
    }

    @Override
    public int compareTo(FutureUpdate futureUpdate) {
        return this.countdown - futureUpdate.countdown;
    }

    public Update getUpdate() {
        return this.update;
    }

    public int getCountdown() {
        return this.countdown;
    }

    public void decreaseCountdown() {
        this.countdown = this.countdown - 1;
    }
}