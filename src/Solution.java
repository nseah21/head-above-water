import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Policy {
    private String description;
    private String effect;
    private List<Update> updates;

    public Policy
(String description, Update... updates) {
        this.description = description;
        this.updates = new ArrayList<>(Arrays.asList(updates));
    }

    @Override
    public String toString() {
        return this.description;
    }

    public String getEffect() {
        return this.effect;
    }

    public List<Update> getUpdates() {
        return this.updates;
    }
}