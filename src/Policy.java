import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Policy {
    private String description;
    private String effect;
    private List<GeneralUpdate> updates;

    public Policy(String description, String effect, GeneralUpdate... updates) {
        this.description = description;
        this.effect = effect;
        this.updates = new ArrayList<>(Arrays.asList(updates));
    }

    @Override
    public String toString() {
        return this.description;
    }

    public String getEffect() {
        return this.effect;
    }

    public List<GeneralUpdate> getUpdates() {
        return this.updates;
    }
}