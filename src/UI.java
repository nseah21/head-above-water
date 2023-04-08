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

    public static final String YOU_LOSE = 
        "+------------------------------------------+\n" +
        " :::   :::  ::::::::  :::    :::            \n" +
        " :+:   :+: :+:    :+: :+:    :+:            \n" +
        "  +:+ +:+  +:+    +:+ +:+    +:+            \n" +
        "   +#++:   +#+    +:+ +#+    +:+            \n" +
        "    +#+    +#+    +#+ +#+    +#+            \n" +
        "    #+#    #+#    #+# #+#    #+#            \n" +
        "    ###     ########   ########             \n" +
        " :::        ::::::::   ::::::::  :::::::::: \n" +
        " :+:       :+:    :+: :+:    :+: :+:        \n" +
        " +:+       +:+    +:+ +:+        +:+        \n" +
        " +#+       +#+    +:+ +#++:++#++ +#++:++#   \n" +
        " +#+       +#+    +#+        +#+ +#+        \n" +
        " #+#       #+#    #+# #+#    #+# #+#        \n" +
        " ########## ########   ########  ########## \n" +
        "+------------------------------------------+\n";

    public static final String YOU_WIN = 
        "+------------------------------------------+\n" +
        " :::   :::  ::::::::  :::    :::            \n" +
        " :+:   :+: :+:    :+: :+:    :+:            \n" +
        "  +:+ +:+  +:+    +:+ +:+    +:+            \n" +
        "   +#++:   +#+    +:+ +#+    +:+            \n" +
        "    +#+    +#+    +#+ +#+    +#+            \n" +
        "    #+#    #+#    #+# #+#    #+#            \n" +
        "    ###     ########   ########             \n" +
        " :::       ::: ::::::::::: ::::    :::      \n" +
        " :+:       :+:     :+:     :+:+:   :+:      \n" +
        " +:+       +:+     +:+     :+:+:+  +:+      \n" +
        " +#+  +:+  +#+     +#+     +#+ +:+ +#+      \n" +
        " +#+ +#+#+ +#+     +#+     +#+  +#+#+#      \n" +
        "  #+#+# #+#+#      #+#     #+#   #+#+#      \n" +
        "   ###   ###   ########### ###    ####      \n" +
        "+------------------------------------------+\n";

    public static final String WELCOME_USER = "Hi there! Congratulations on being elected as a policymaker in Jakarta!\nYou have been tasked to manage the issue of flooding... but hey! It can't be that hard... right?\nJust widen the rivers and you'll keep your head above water!\n";
    public static final String RULES = "Now for the nitty gritty... managing flood policies is no trivial task!\nYou will have to juggle between many stakeholders in order to survive your term...\nDisappoint or deplete any of your stocks and YOU'RE OUT! Got it?\n";
    public static final String MANSPLAINING_STOCKS = "What are stocks, you ask?\nWell, those are the metrics you will be using to evaluate your performance.\nIf any of your stocks fall below 0, you LOSE THE GAME.\n(Population, however, needs to be maintained above 80% of the initial value... It can also strangely take decimal point values... :O)";
    public static final String MANSPLAINING_VARIABLES = "Variables, on the other hand, will affect your stocks in some (hidden) way when a flood occurs...\nDo not ignore them as the effects will not be trivial!\nThink about how your stocks are changing with respect to the variables as you play through the game!";
    public static final String ROUND_START = "\nIt is now round %d!\n"; 
    public static final String ROUND_END = "Round %d has now come to an end... let's see what your stocks look like now!\n\n";
    public static final String SCENARIO_START = "Here is your scenario for the round:\n";
    public static final String SCENARIO_START_AGAIN = "Here is your scenario for the round... again...:\n";
    public static final String INTRODUCE_STOCKS = "Here are the stocks and variables you will need to manage...\nNote that stocks are in CAPITAL LETTERS, while variables are in Title Case.\n";
    public static final String PRINT_FINAL_STOCKS = "Here are your stocks and variables after the game:\n";
    public static final String ANNOUNCE_WIN = "Congratulations!\nYou have successfully survived your term as a politician!\nWe hope that this game has helped you gain an insight into the factors affecting the issue in flooding in Jakarta.\nWe also hope that you consider how the policies you have used here might be transferrable to other contexts.\nTHANK YOU FOR PLAYING!";
    public static final String ANNOUNCE_LOSE = "Unfortunately, some of your policies have resulted in one or more of your stocks being depleted.\nPerhaps some of your policies had effects that you failed to consider.\nDon't worry though, you can always try again!\nTHANK YOU FOR PLAYING!";

    public static void staggerPrint(String message) {
        for (String s : message.split("\n")) {
            Logic.sleep(200);
            System.out.println(s);          
        }
        Logic.sleep(300);
    } 

    public static void staggerPrintForRules(String message) {
        for (String s : message.split("\n")) {
            Logic.sleep(1200);
            System.out.println(s);          
        }
        Logic.sleep(2500);
    } 

    public static void staggerPrintWithNoFinalLag(String message) {
        for (String s : message.split("\n")) {
            Logic.sleep(1200);
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

    public static void printWinLogo() {
        staggerPrintButFaster(YOU_WIN);
        System.out.println();
        staggerPrint(PRINT_FINAL_STOCKS);
    }

    public static void announceWin() {
        System.out.println();
        staggerPrintForRules(ANNOUNCE_WIN);
        System.out.println();
    }

    public static void printLoseLogo() {
        staggerPrintButFaster(YOU_LOSE);
        System.out.println();
        staggerPrint(PRINT_FINAL_STOCKS);
    }

    public static void announceLose() {
        System.out.println();
        staggerPrintForRules(ANNOUNCE_LOSE);
        System.out.println();
    }    

    public static void announceWelcome() {
        staggerPrintForRules(WELCOME_USER);
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
        staggerPrintForRules(RULES);
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
        staggerPrintForRules(INTRODUCE_STOCKS);
        System.out.println();
    }

    public static void displayValues(List<Stock> stocks, List<Variable> variables) {
        Logic.sleep(270);
        System.out.println("+----------------------------------------------------------+");
        Logic.sleep(270);
        System.out.println(String.format("| %-18s | %-16s | %-16s |", "STOCK/Variable", "Current Value", "Initial Value"));
        Logic.sleep(270);
        System.out.println("+----------------------------------------------------------+");
        Logic.sleep(270);
        for (int i = 0; i < stocks.size(); i++) {
            System.out.println(String.format("| %-18s | %-16s | %-16.2f |", Utility.VALUES.get(i), stocks.get(i), Utility.INITIAL_STOCKS.get(i)));
            Logic.sleep(270);
        }
        for (int i = stocks.size(); i < Utility.VALUES.size(); i++) {
            System.out.println(String.format("| %-18s | %-16s | %-16.2f |", Utility.VALUES.get(i), variables.get(i - stocks.size()), Utility.INITIAL_VARIABLES.get(i - stocks.size())));
            Logic.sleep(270);
        }
        System.out.println("+----------------------------------------------------------+");
        Logic.sleep(270);
        System.out.println();
    }

    public static void startMansplaining() {
        staggerPrintForRules(MANSPLAINING_STOCKS);
        System.out.println();
        staggerPrintForRules(MANSPLAINING_VARIABLES);
        System.out.println();
    }
}