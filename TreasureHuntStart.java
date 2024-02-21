/*
 *        Class: IT-516 - Data Structures & Algorithms
 *   Instructor: Sean Harrington
 *         Date: DD MM YYYY
 *      Student: GD02
 *   Assignment: Treasure Hunt Game
 *
 *   Compile: javac-algs4 TreasureHuntStart.java
 *
 *       Run: java-algs4 TreasureHuntStart 4 [four player game]
 */

import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Random;

public class TreasureHuntStart {
    public static void main(String[] args) {
        int numPlayers = Integer.parseInt(args[0]);
        StdOut.println("Welcome to The Treasure Hunt Game!");
        if (numPlayers >= 1 && numPlayers < 5) {
            StdOut.println("This will be a " + numPlayers + " player game.");
            StdOut.println("The game begins now:");

            Integer[] playerSpace = new Integer[numPlayers];                           // Array to hold player's current space
            int dieRolls = 0;                                                          // Count of all times the die is rolled
            int[] playerRolls = new int[numPlayers];                                    // Make an array to hold count of player's rolls
            int[] commonDieRolls = new int[6];                                          // Make an array to hold most common die rolls
            int[] treasureFound = new int[numPlayers];                                   // Make an array to hold number of treasure a player finds
            int[] trapEncountered = new int[numPlayers];                              // Make an array to hold number of traps a player encounters


            for (int j = 0; j < numPlayers; j++) {                                     // Initialize all the values in all arrays to 0
                playerSpace[j] = 0;
                playerRolls[j] = 0;
                treasureFound[j] = 0;
                trapEncountered[j] = 0;
            }


            for (int j = 0; j < 24; j++) {
                int x = 1 + 1;                                                         // Do something else here to count/increment die rolls
            }

            In in = new In("TreasureAndTrap.txt");                                           // This can be changed to a different, local file with Digraph data in it
            Digraph spacesDigraph = new Digraph(in);
            int winningSpace = spacesDigraph.V() - 1;
            int[][] treasureFoundByPlayer = new int[numPlayers][winningSpace];           // initialize a 2D array to keep track of the number of times each treasure is found by each player
            int[][] trapsEncounteredByPlayer = new int[numPlayers][winningSpace]; // initialize a 2D array to keep track of the number of times each trap is encountered by each player
            // Main Game Loop
            for (int i = 0; i < 1000000; i++) {                                        // Arbitrary big number of turns. We use "break" command at bottom to exit.
                int player = i % numPlayers;                                           // Mathematically determines which player's turn it is by remainder
                Random r = new Random();                                               // Create a random number holder
                int roll = r.nextInt((6)) + 1;                                         // Create an integer to hold the random number & randomize
                dieRolls++;                                                            // Increment times die has been rolled
                playerRolls[player]++;                                                 // Increment times player has rolled the die
                //commonDieRolls[roll * numPlayers - 1]++;                               // Increment this die roll in the array of die rolls per player
                StdOut.println("Player " + (player + 1) + " rolls a " + roll);
                playerSpace[player] = playerSpace[player] + roll;                      // "Move" the player forward by the die roll
                StdOut.println("         Moves to space " + playerSpace[player]);
                if (playerSpace[player] < winningSpace) {
                    int numJumps = spacesDigraph.outdegree(playerSpace[player]);           // Check the digraph to see if there are any treasures or traps
                    if (numJumps != 0) {            // and if there are (and player hasn't already moved past 100)
                        for (Integer bigMove : spacesDigraph.adj(playerSpace[player])) {   // get ready to move them.
                            if (playerSpace[player] < bigMove) {                           // If it's a treasure (player space is less than digraph space)
                                playerSpace[player] = bigMove;                             // move them forward.
                                StdOut.println("         Gets a TREASURE! Move to space " + bigMove);
                                treasureFound[player]++;                                     //count player's climb
                                treasureFoundByPlayer[player][bigMove]++; // increment the count for that player and that treasure

                            } else {                                                       // Otherwise, it's a trap (player space is more than digraph space)
                                playerSpace[player] = bigMove;                             // so move them back.
                                StdOut.println("         Hits a TRAP! Go back to space " + bigMove);
                                trapEncountered[player]++;                                // count player's traps encountered
                                trapsEncounteredByPlayer[player][bigMove]++; // increment the count for that player and that trap encountered
                            }
                        }
                    }
                }
                if (playerSpace[player] >= winningSpace) {                             // If player's new space is greater than or equal to the win space
                    StdOut.println("Player " + (player + 1) + " wins!");               // display end of game message
                    break;                                                             // and exit the loop.
                }

            }
            
            StdOut.println();
            StdOut.println("End of game stats:");
            StdOut.println();
            StdOut.println("Total die rolls for the game is " + dieRolls);
            for (int z = 0; z < numPlayers; z++) {                                     // Loop through die roll stats
                StdOut.println("Total die rolls for player " + (z + 1) + " is " + playerRolls[z]);   // variable for player rolls
            }
            Integer[] commonDieRollsResults = new Integer[6];                          // Create "6-sided" array for each die value
            for (int w = 0; w < 6; w++) {                                              // Loop through common die roll results
                commonDieRollsResults[w] = 0;                                          // You'll need to add all your player common die rolls here, rather than 0
            }
            int max = commonDieRollsResults[0];                                        // Create an integer to hold most-rolled die value
            int index = 0;

            for (int p = 1; p < 6; p++) {                                              // Find max value by looping through results
                if (max < commonDieRollsResults[p]) {
                    max = commonDieRollsResults[p];
                    index = p;
                }
            }
            StdOut.println();
            StdOut.println("Most common die roll for the game is " + (index + 1));
            Integer[] commonDieRollsResults1 = new Integer[6];                         // Create a new die rolls results array for player 1
            System.arraycopy(commonDieRollsResults, 0, commonDieRollsResults1, 0, 6);  // Copy your array that holds common die rolls, rather than
            int max1 = commonDieRollsResults1[0];
            int index1 = 0;

            for (int p = 1; p < 6; p++) {                                              // Loop through to find it
                if (max1 < commonDieRollsResults1[p]) {
                    max1 = commonDieRollsResults1[p];
                    index1 = p;
                }
            }
            StdOut.println("Most common die roll for player 1 is " + (index1 + 1));
            if (numPlayers > 1) {                                                      // Do for each player
                StdOut.println("Most common die roll for player 2 is " + 0);           // Do some calculations here to replace 0
            }// Do some calculations here to replace 0
            if (numPlayers > 2) {
                StdOut.println("Most common die roll for player 3 is " + 0);           // Do some calculations here to replace 0
            }
            if (numPlayers > 3) {
                StdOut.println("Most common die roll for player 4 is " + 0);           // Do some calculations here to replace 0
            }
            StdOut.println();
            int gameRungs = 0;
            for (int l = 0; l < numPlayers; l++) {                                      // Sum game rungs climbed
                gameRungs = gameRungs + treasureFound[l];                                              // Do a calculation here to replace 1
            }
            StdOut.println("Total treasures found for the game is " + gameRungs);
            for (int l = 0; l < numPlayers; l++) {
                StdOut.println("Total treasures found for player " + (l + 1) + " is " + treasureFound[l]);  // Display total treasure found
            }
            int mostFoundTreasure = 0;
            int mostFoundTreasureCount = 0;
            for (int i = 0; i < numPlayers; i++) {
                for (int j = 0; j < winningSpace; j++) {
                    if (treasureFoundByPlayer[i][j] > mostFoundTreasureCount) {
                        mostFoundTreasureCount = treasureFoundByPlayer[i][j];
                        mostFoundTreasure = j;
                    }
                }
            }
            StdOut.println("The most found treasure is Treasure " + mostFoundTreasure + " with " + mostFoundTreasureCount + " time(s) found.");
            StdOut.println();
            int gameTraps = 0;                                                         // Sum game traps encountered
            for (int l = 0; l < numPlayers; l++) {
                gameTraps = gameTraps + trapEncountered[l];                                            //calculate traps encountered
            }
            StdOut.println("Total trap encountered for the game is " + gameTraps);
            for (int l = 0; l < numPlayers; l++) {
                StdOut.println("Total trap encountered for player " + (l + 1) + " is " + trapEncountered[l]);  // display result
            }
            int mostEncounteredTrap = 0;
            int mostEncounteredTrapCount = 0;
            for (int i = 0; i < numPlayers; i++) {
                for (int j = 0; j < winningSpace; j++) {
                    if (trapsEncounteredByPlayer[i][j] > mostEncounteredTrapCount) {
                        mostEncounteredTrapCount = trapsEncounteredByPlayer[i][j];
                        mostEncounteredTrap = j;
                    }
                }
            }
            StdOut.println("The most encountered trap is Trap " + mostEncounteredTrap + " with " + mostEncounteredTrapCount + " time(s).");
            StdOut.println();
        } else {
            StdOut.println("Only 1-4 players for this game!");
        }
    }
}
