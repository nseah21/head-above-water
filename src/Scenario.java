import java.util.List;
import java.util.ArrayList;

class Scenario {
    private String description;
    private List<GeneralUpdate> scenarioEffect;
    private List<Policy> policies;

    public Scenario(String description, List<GeneralUpdate> scenarioEffect, Policy first, Policy second, Policy third, Policy fourth) {
        this.description = description;
        this.scenarioEffect = scenarioEffect;
        this.policies = new ArrayList<>(List.of(first, second, third, fourth));
    }

    @Override
    public String toString() {
        String result = this.description;
        for (int i = 0; i < 4; i++) {
            result = result + "\n" + (char) (i + 65) + ": " + policies.get(i);
        }
        return result + getPrompt();
    }

    private String getPrompt() {
        return "\n\n...What will you do?";
    }

    public Policy getPolicy(int n) {
        return policies.get(n);
    }

    public List<GeneralUpdate> getScenarioEffect() {
        return this.scenarioEffect;
    }
}