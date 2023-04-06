# HEAD ABOVE WATER

This is a simple command-line interface game that aims to model the context and scenario of flood prevention policymaking in Jakarta.

Inspired by games like *Papers Please* and *Spent*, our game provides a scenario to the player at each round, and the player has to choose an appropriate action to respond with.

As a policymaker, the player has many stakeholders to cater to and several metrics (called **stocks**) to evaluate their performance by. Choosing a policy to enact at each round will incur some cost (and some reward) to these metrics. If any of these stocks fall below a certain threshold, the player loses.

The goal is to make it to the end of the game, while maintaining a reasonable level of the stocks in question.

We hope that playing this game will provide an insight into the considerations that a policymaker might evaluate when implementing flood prevention policies. Through the game, we also hope the user can explore and understand how different decisions routes might lead to different values for the stocks.

## Features include:

1. Short-term policy (with immediate impacts) vs long-term policy (with delayed impacts)
2. Randomly simulated floods which occur with varying probabilities (and magnitudes)
3. Stocks that emulate the factors which a policymaker might need to juggle 
4. Variables that affect the severity of damage incurred on the stocks (using some magic calculations... don't read the code hehe)
5. Over 100,000 possible permutations of actions per game!
6. Shuffled scenarios
7. Simple gameplay (just enter an option and lock it in!)

## Instructions to run game:

1. Ensure that you have `Java` installed. You can verify by running `java --version` in your terminal.
2. Download the zip file by clicking on the green `"<> Code"` button above and selecting `"Download ZIP"`.
3. Unzip the file by right clicking on the zip file in your library window.
4. Open a terminal window and navigate to the file location.
5. Type `cd src` into the terminal.
6. Compile the files by running `javac *.java`.
7. Start the game by running `java Main`.