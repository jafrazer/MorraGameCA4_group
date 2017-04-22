import java.util.Scanner;

/**
 * 'Morra' is a hand game that has many variations and can be played by two or
 * more players.
 * 
 * In this variation of the game, one player is going to be the 'Odds' player
 * and the other player 'Evens'. In each round of the game, the players will
 * simultaneously 'hold out' between 1 and 10 fingers. The winner of the round
 * is decided based on the sum of fingers shown by both players. If the sum is an
 * even number, then the 'Evens' player wins; otherwise, if the sum is an odd
 * number, then the 'Odds' player wins. The winner of the round receives two
 * points.
 * 
 * In addition, the player whose number of fingers is closer to the sum,
 * receives one extra point.
 */
public class MorraApp {

  /**
   * Main method for the Morra Game Application.
   * 
   * @author johnfrazer - x16138015
   */
  public static void main(String[] args) {
    // Instantiate Scanner object to accept user input.
    Scanner keyboardIn = new Scanner(System.in);

    // Instantiate the MorraGameLogic object.
    MorraGameLogic morraLogic = new MorraGameLogic();

    // Instantiate the player objects.
    MorraPlayer human = new MorraPlayer();
    MorraCPUPlayer cpu = new MorraCPUPlayer();

    // Initialise loop condition for PLAY GAME loop; if the player wants to play
    // another game.
    boolean playAgain = true;

    do {

      // Prompt user if they wish to be Odds or Evens.
      boolean humanSelectedOdds = morraLogic.humanPlayerTypeSelectionMenu(keyboardIn);

      // Set the player and cpu types based on the user selection.
      morraLogic.setPlayerTypes(human, cpu, humanSelectedOdds);
      
      /* PLAY GAME */
      int roundCounter = 0;

      do {
        /* START ROUND */
        // User selection of number of fingers (1-10).
        human.setFingers(morraLogic.getPlayerFingersHeldOut(keyboardIn));

        // Computer selection of number of fingers (pseudo-random, 1-10).
        cpu.setFingers();

        // Displays the computer’s choice.
        System.out.println("CPU Fingers: " + cpu.getFingers());

        // Score calculation and display round winner.
        morraLogic.calculateScoreChanges(human, cpu);

        // Display the current score.
        System.out
            .println("Current Score is: \n\tPlayer: " + human.checkScore() + " \n\tCPU: " + cpu.checkScore() + "\n");

        // Store the fingers data for the round
        morraLogic.updateRoundHistory(human, cpu, roundCounter);

        // increment the round counter so that we can correctly store the player
        // fingers held out array.
        roundCounter++;

        /* END ROUND */
      } while (human.checkScore() < 6 && cpu.checkScore() < 6);

      // At the end of the game, display the winner and the round history.
      morraLogic.endRoundOutput(human, cpu);

      /* END GAME */
      // reset the player and cpu scores to zero for new game rounds.
      human.resetScore();
      cpu.resetScore();

      // ask the player if they would like to play another game.
      playAgain = morraLogic.playAnotherGame(keyboardIn);
    } while (playAgain);

    // At the end of all games, display a history of games played.
    morraLogic.displayGameEndStats(human, cpu);

    // Close the scanner object.
    keyboardIn.close();
  }

}
