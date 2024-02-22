# Treasure Hunt Game

Welcome to the Treasure Hunt Game! This Java program simulates a multiplayer treasure hunt game on a graph structure.

## Getting Started

### Prerequisites

Make sure you have [Java](https://www.java.com/en/download/) installed on your machine.

### Compilation

Compile the program using the following command:

javac-algs4 TreasureHuntStart.java

java-algs4 TreasureHuntStart <numPlayers>
Replace <numPlayers> with the desired number of players (e.g., java-algs4 TreasureHuntStart 4).

## Game Setup
### Number of Players:

The game begins by specifying the number of players (1 to 4) when executing the program.
### Digraph Configuration:

The game environment is represented as a directed graph (digraph).
The configuration of spaces, treasures, and traps is defined in the TreasureAndTrap.txt file.
### Player Turns
### Die Rolls:

Players take turns rolling a six-sided die to determine their movement on the graph.
The die roll represents the number of spaces a player moves forward.
### Graph Movement:

Each player starts at space 0 and moves forward based on the die roll.
The program checks the directed graph to see if there are any treasures or traps on the player's new space.
### Treasures and Traps
### Treasures:

If a player lands on a space containing a treasure (a higher-numbered space in the graph), they collect the treasure.
The player's position is updated to the space containing the treasure.
### Traps:

If a player lands on a space containing a trap (a lower-numbered space in the graph), they encounter a trap.
The player's position is updated to the space containing the trap, moving them backward.
### Statistics:

The game keeps track of the total number of treasures found and traps encountered by each player.
Winning the Game
### Game End:

The game continues until a player reaches or exceeds the winning space, which is the last space in the directed graph.
The first player to reach the winning space is declared the winner, and the game ends.
### Endgame Statistics:

After the game concludes, the program provides detailed statistics, including total die rolls, common die rolls, treasures found, and traps encountered by each player.
## Customization
### Graph Configuration (Customization):
Players can customize the game environment by modifying the TreasureAndTrap.txt file.
The file defines the connections between spaces, the placement of treasures, and the locations of traps.
Running the Game
Execution:

Compile and execute the program using Java.
Specify the desired number of players when starting the game.
Analysis and Improvement:

Players and developers can analyze the endgame statistics to understand gameplay patterns and make improvements for future sessions.
### Repository Structure

TreasureHuntStart.java: Main Java source code.
TreasureAndTrap.txt: Digraph data file.
README.md: Project documentation.

