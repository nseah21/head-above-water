import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Scheduler {
    private PriorityQueue<FutureUpdate> queue;
    private Logic logic;

    public Scheduler(Logic logic) {
        this.queue = new PriorityQueue<>();
        this.logic = new Logic();
    }

    public void houseKeeping() {
        tick();
        execute();
    }

    private void tick() {
        queue.forEach(FutureUpdate::decreaseCountdown);
    }

    private void execute() {
        List<Update> updates = new ArrayList<>();
        while (queue.peek().getCountdown() == 0) {
            updates.add(queue.poll().getUpdate());
        }
        logic.execute(updates);
    }
}