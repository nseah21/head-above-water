import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Scheduler {
    private PriorityQueue<FutureUpdate> queue;
    private Logic logic;

    public Scheduler(Logic logic) {
        this.queue = new PriorityQueue<>();
        this.logic = logic;
    }

    public boolean doHouseKeeping() {
        tick();
        return execute();
    }

    public void addToQueue(FutureUpdate futureUpdate) {
        queue.add(futureUpdate);
    }

    private void tick() {
        queue.forEach(FutureUpdate::decreaseCountdown);
    }

    private boolean execute() {
        List<GeneralUpdate> updates = new ArrayList<>();
        while (!queue.isEmpty() && queue.peek().getCountdown() == 0) {
            updates.add(queue.poll().getUpdate());
        }
        logic.execute(updates, this);
        if (!updates.isEmpty()) {
            Logic.sleep(800);
            System.out.println("\nSome of your past policies have lingering effects... Let's see what they are:\n");
            Logic.sleep(1000);
        } else {
            Logic.sleep(800);
            System.out.println("\nThere doesn't seem to be lingering effects from any previous policies... so let's continue!\n");
            Logic.sleep(1000);
        }
        for (GeneralUpdate update : updates) {
            Update u = (Update) update;
            System.out.println("*" + u.toString() + "*");
            Logic.sleep(800);
        }
        System.out.println();
        return !updates.isEmpty();
    }
}