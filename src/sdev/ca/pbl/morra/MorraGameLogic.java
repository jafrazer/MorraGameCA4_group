package sdev.ca.pbl.morra;

import java.util.Scanner;

/**
 * This class contains the game logic for Morra.
 */
public class MorraGameLogic {

  /**
   * Default constructor for MorraGameLogic.
   * 
   * @author johnfrazer - x16138015
   */
  public MorraGameLogic() {
    // This constructor is intentionally empty.
  }

  /**
   * This method is for the player to select their player type, Odds or Evens.
   * 
   * @param keyboardIn
   *          The scanner object for accepting user input.
   * 
   * @return Player has selected odds indicator.
   * 
   * @author
   */
  public boolean humanPlayerTypeSelectionMenu(Scanner keyboardIn) {
    boolean selectedOdds = true;

    // TODO: display a text menu here to ask the user if they would like to be
    // the Odds or Evens player.
    // NOTE: you have a Scanner object called keyboardIn to work with.

    return selectedOdds;
  }

  /**
   * In this method, the player and cpu users are set as Odds or Evens, based on
   * the player's selection.
   * 
   * @param human
   *          The human player object.
   * @param cpu
   *          The CPU player object.
   * @param playerSelectedOdds
   *          A boolean value noting if the human player has selected to be Odds
   *          or not.
   * 
   * @author
   */
  public void setPlayerTypes(MorraPlayer human, MorraCPUPlayer cpu, boolean playerSelectedOdds) {
    // TODO: set each player as Odds or Evens, based on the player's selection.
    // NOTE: use human.SOMEMETHOD() and cpu.SOMEMETHOD()
  }

  /**
   * This method gets the number of fingers the player wants to "hold out".
   * 
   * @param keyboardIn
   *          The scanner object for accepting user input.
   * 
   * @return The number of fingers "held out".
   * 
   * @author
   */
  public int getPlayerFingersHeldOut(Scanner keyboardIn) {
    int playerFingers = 0;

    // TODO: ask the player for how many fingers they want to hold out
    // NOTE: you have a Scanner object called keyboardIn to work with.

    return playerFingers;
  }

  /**
   * This method calculates updates to the players scores in a game round,
   * displays which player has won, and some information on why.
   * 
   * The winner of the round is decided based on the sum of ﬁngers shown by both
   * players, namely if the sum is an even number then the “Evens” player wins,
   * otherwise if the sum is an odd number then the “Odds” player wins. The
   * winner of the round receives two points.
   * 
   * In addition, the player whose number of fingers is closer to the sum,
   * receives one extra point.
   * 
   * @param human
   *          The human player object.
   * @param cpu
   *          The CPU player object.
   * 
   * @author
   */
  public void calculateScoreChanges(MorraPlayer human, MorraCPUPlayer cpu) {

    // Calculate who wins the points for being Odds or Evens.

    // NOTE: that you have the human and cpu objects here to use.

    // TODO: write the code needed to to calculate the winner of the round, and
    // award them their points. Also try to print out some information here so
    // the player knows why the winner was the winner.

    // Calculate who wins the bonus point for being closer to the total.

    // TODO: Award a bonus point to whichever player's number of fingers held
    // out is closer to the total.
  }

  /**
   * Store the player "fingers held out" information into the player object.
   * 
   * @param human
   *          The human player object.
   * @param cpu
   *          The CPU player object.
   * @param roundNumber
   *          The round number to update
   */
  public void updateRoundHistory(MorraPlayer human, MorraCPUPlayer cpu, int roundNumber) {
    human.updateFingerHistory(roundNumber);
    cpu.updateFingerHistory(roundNumber);
  }

  /**
   * Output the game winner and game history.
   * 
   * @param human
   *          The human player object.
   * @param cpu
   *          The CPU player object.
   * 
   * @author johnfrazer - x16138015
   */
  public void endRoundOutput(MorraPlayer human, MorraCPUPlayer cpu) {
    displayGameWinner(human.checkScore(), cpu.checkScore());
    displaySingleGameHistory(human, cpu);
  }

  /**
   * This method compares the player's score to the cpu player's score, and
   * displays the game winner.
   * 
   * @param humanScore
   * @param cpuScore
   * 
   * @author
   */
  private void displayGameWinner(int humanScore, int cpuScore) {
    // The winner of the game is the ﬁrst player who accumulates six points.

    // TODO: display a message to show who won the game
    // NOTE: you have a Scanner object called keyboardIn to work with.
  }

  /**
   * Display the numbers of ﬁngers shown by both the user and the computer per
   * round.
   * 
   * @param human
   *          The human player object.
   * @param cpu
   *          The CPU player object.
   * 
   * @author johnfrazer - x16138015
   */
  private void displaySingleGameHistory(MorraPlayer human, MorraCPUPlayer cpu) {

    System.out.print("Player fingers: ");
    human.printFingerHistory();
    System.out.println(""); // extra line for console formatting

    System.out.print("CPU fingers: ");
    cpu.printFingerHistory();
    System.out.println(""); // extra line for console formatting

  }

  /**
   * Ask the user if they would like to play another game.
   * 
   * @param keyboardIn
   *          The scanner object for accepting user input.
   * 
   * @return Player decision to play another game.
   * 
   * @author
   */
  public boolean playAnotherGame(Scanner keyboardIn) {
    boolean playAgain = false;
    boolean playAgainLoopCondition = false;

    // TODO: Ask the player if they would like to play again.

    return playAgain;
  }

  /**
   * For each game, show:
   * 
   * - the number of rounds won and lost by the human player
   * 
   * - how many even and odd numbers have been chosen by each player
   * 
   * - the extra points received by the player per game
   * 
   * 
   * @author
   */
  public void displayGameEndStats() {

    // All the history elements of the game should be coded using Arrays.
    // TODO
  }

}
