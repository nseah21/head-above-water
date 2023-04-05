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

    public void houseKeeping() {
        System.out.println("Doing housekeeping...");
        tick();
        execute();
    }

    public void addToQueue(FutureUpdate futureUpdate) {
        queue.add(futureUpdate);
    }

    private void tick() {
        queue.forEach(FutureUpdate::decreaseCountdown);
    }

    private void execute() {
        List<GeneralUpdate> updates = new ArrayList<>();
        while (!queue.isEmpty() && queue.peek().getCountdown() == 0) {
            updates.add(queue.poll().getUpdate());
        }
        logic.execute(updates, this);
        System.out.println(queue);
        for (GeneralUpdate update : updates) {
            Update u = (Update) update;
            System.out.println("Long-term update executed from scheduler:");
            System.out.println(u.toString());
        }
    }
}