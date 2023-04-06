import java.util.List;

class UI {
    public static final String LOGO = 
        "+---------------------------------------------------------+\n" +        
        "                                                           \n" +
        " :::    ::: ::::::::::     :::     :::::::::               \n" +
        " :+:    :+: :+:          :+: :+:   :+:    :+:              \n" +
        " +:+    +:+ +:+         +:+   +:+  +:+    +:+              \n" +
        " +#++:++#++ +#++:++#   +#++:++#++: +#+    +:+              \n" +
        " +#+    +#+ +#+        +#+     +#+ +#+    +#+              \n" +
        " #+#    #+# #+#        #+#     #+# #+#    #+#              \n" +
        " ###    ### ########## ###     ### #########               \n" +
        "                                                           \n" +
        "     :::     :::::::::   ::::::::  :::     ::: ::::::::::  \n" +
        "   :+: :+:   :+:    :+: :+:    :+: :+:     :+: :+:         \n" +
        "  +:+   +:+  +:+    +:+ +:+    +:+ +:+     +:+ +:+         \n" +
        " +#++:++#++: +#++:++#+  +#+    +:+ +#+     +:+ +#++:++#    \n" +
        " +#+     +#+ +#+    +#+ +#+    +#+  +#+   +#+  +#+         \n" +
        " #+#     #+# #+#    #+# #+#    #+#   #+#+#+#   #+#         \n" +
        " ###     ### #########   ########      ###     ##########  \n" +
        "                                                           \n" +
        " :::       :::     ::: ::::::::::: :::::::::: :::::::::    \n" +
        " :+:       :+:   :+: :+:   :+:     :+:        :+:    :+:   \n" +
        " +:+       +:+  +:+   +:+  +:+     +:+        +:+    +:+   \n" +
        " +#+  +:+  +#+ +#++:++#++: +#+     +#++:++#   +#++:++#:    \n" +
        " +#+ +#+#+ +#+ +#+     +#+ +#+     +#+        +#+    +#+   \n" +
        "  #+#+# #+#+#  #+#     #+# #+#     #+#        #+#    #+#   \n" +
        "   ###   ###   ###     ### ###     ########## ###    ###   \n" +
        "                                                           \n" +
        "+---------------------------------------------------------+\n";                                              

    public static final String WELCOME_USER = "Hi there! Congratulations on being elected as a policymaker in Jakarta!\nYou have been tasked to manage the issue of flooding... but hey! It can't be that hard... right?\nJust widen the rivers and you'll keep your head above water!\n";
    public static final String RULES = "Now for the nitty gritty... managing flood policies is no trivial task!\nYou will have to juggle between many stakeholders in order to survive your term...\nDisappoint or deplete any of your stocks and YOU'RE OUT! Got it?\n";
    public static final String MANSPLAINING_STOCKS = "What are stocks, you ask?\nWell, those are the metrics you will be using to evaluate your performance.\nIf any of your stocks fall below 0, you LOSE THE GAME.\n(Population, however, needs to be maintained above 80% of the initial value...)";
    public static final String MANSPLAINING_VARIABLES = "Variables, on the other hand, will affect your stock in some (hidden) way...\nDo think about how your stocks are changing with respect to the variables as you play through the game!";
    public static final String ROUND_START = "\nIt is now round %d!\n"; 
    public static final String ROUND_END = "Round %d has now come to an end... let's see what your stocks look like now!\n\n";
    public static final String SCENARIO_START = "Here is your scenario for the round:\n";
    public static final String SCENARIO_START_AGAIN = "Here is your scenario for the round... again...:\n";
    public static final String INTRODUCE_STOCKS = "Here are the stocks and variables you will need to manage...\nNote that stocks are in CAPITAL LETTERS, while variables are in lower case.\n";

    public static void staggerPrint(String message) {
        for (String s : message.split("\n")) {
            Logic.sleep(1500);
            System.out.println(s);          
        }
        Logic.sleep(3000);
    } 

    public static void staggerPrintWithNoFinalLag(String message) {
        for (String s : message.split("\n")) {
            Logic.sleep(1500);
            System.out.println(s);          
        }
    } 

    public static void staggerPrintButFaster(String message) {
        for (String s : message.split("\n")) {
            Logic.sleep(300);
            System.out.println(s);          
        }
        Logic.sleep(500);
    } 

    public static void printLogo() {
        staggerPrintButFaster(LOGO);
        System.out.println();
    }

    public static void announceWelcome() {
        staggerPrint(WELCOME_USER);
        System.out.println();
    }

    public static void announceScenarioStart() {
        System.out.println(SCENARIO_START);
        Logic.sleep(800);
    }

    public static void announceScenarioAgain() {
        System.out.println(SCENARIO_START_AGAIN);
        Logic.sleep(800);
    }

    public static void announceRoundStart(int round) {
        System.out.printf(ROUND_START, round);
        Logic.sleep(1000);
    }
    
    public static void announceRoundEnd(int round) {
        if (round == Utility.LAST_ROUND) {
            System.out.println("Unfortunately, it is the end of your last round! Let's see how well you have done...");
        } else {
            System.out.printf(ROUND_END, round);
        }
        
        Logic.sleep(1000);
    }

    public static void announceRules() {
        staggerPrint(RULES);
        System.out.println();
    }

    public static void announceEffect() {
        System.out.println("Let's see what has happened as a result of your choice...\n");
        Logic.sleep(1100);
    }

    public static void printScenario(Scenario scenario) {
        staggerPrintWithNoFinalLag(scenario.toString());
        System.out.println();
    }

    public static void introduceStocks() {
        staggerPrint(INTRODUCE_STOCKS);
        System.out.println();
    }

    public static void displayValues(List<Stock> stocks, List<Variable> variables) {
        Logic.sleep(800);
        System.out.println("+----------------------------------------------------------+");
        System.out.println(String.format("| %-18s | %-16s | %-16s |", "STOCK/Variable", "Current Value", "Initial Value"));
        System.out.println("+----------------------------------------------------------+");
        for (int i = 0; i < stocks.size(); i++) {
            System.out.println(String.format("| %-18s | %-16s | %-16.1f |", Utility.VALUES.get(i), stocks.get(i), Utility.INITIAL_STOCKS.get(i)));
            Logic.sleep(800);
        }
        for (int i = stocks.size(); i < Utility.VALUES.size(); i++) {
            System.out.println(String.format("| %-18s | %-16s | %-16.1f |", Utility.VALUES.get(i), variables.get(i - stocks.size()), Utility.INITIAL_VARIABLES.get(i - stocks.size())));
            Logic.sleep(800);
        }
        System.out.println("+----------------------------------------------------------+");
        Logic.sleep(900);
        System.out.println();
    }

    public static void startMansplaining() {
        staggerPrint(MANSPLAINING_STOCKS);
        System.out.println();
        staggerPrint(MANSPLAINING_VARIABLES);
        System.out.println();
    }
}