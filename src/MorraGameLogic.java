import java.util.Scanner;

/**
 * This class contains the game logic for Morra.
 */
public class MorraGameLogic {

  /**
   * Default constructor for MorraGameLogic.
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
   * @author johnfrazer - x16138015
   */
  public void calculateScoreChanges(MorraPlayer human, MorraCPUPlayer cpu) {

    // Calculate who wins the points for being Odds or Evens.
    int totalFingersShown = human.getFingers() + cpu.getFingers();

    if (totalFingersShown % 2 == 0) {
      // result is EVEN; evens player wins
      if (!human.isPlayerOdds()) {
        human.roundWinnerPointsUpdate();
        human.updateWonRoundCount();
        System.out.println("You win this round! (" + totalFingersShown + " is even)");
      } else if (!cpu.isPlayerOdds()) {
        cpu.roundWinnerPointsUpdate();
        human.updateLostRoundCount();
        System.out.println("CPU wins this round! (" + totalFingersShown + " is even)");
      }
    } else if (totalFingersShown % 2 == 1) {
      // result is ODD; odds player wins
      if (human.isPlayerOdds()) {
        human.roundWinnerPointsUpdate();
        human.updateWonRoundCount();
        System.out.println("You win this round! (" + totalFingersShown + " is odd)");
      } else if (cpu.isPlayerOdds()) {
        cpu.roundWinnerPointsUpdate();
        human.updateLostRoundCount();
        System.out.println("CPU wins this round! (" + totalFingersShown + " is odd)");
      }
    }

    // Calculate who wins the bonus point for being closer to the total.
    int playerFingersTotalDiff = totalFingersShown - human.getFingers();
    int cpuFingersTotalDiff = totalFingersShown - cpu.getFingers();

    if (playerFingersTotalDiff < cpuFingersTotalDiff) {
      human.closerToTheSumBonusPointUpdate();
      System.out.println("Your guess (" + human.getFingers() + ") was closer to the total (" + totalFingersShown
          + ") than CPU's guess (" + cpu.getFingers() + "), so you win the bonus point!");
    } else {
      cpu.closerToTheSumBonusPointUpdate();
      System.out.println("CPU guess (" + cpu.getFingers() + ") was closer to the total (" + totalFingersShown
          + ") than your guess (" + human.getFingers() + "), so CPU wins the bonus point!");
    }
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
   * For each game, show: <br>
   * - the number of rounds won and lost by the human player <br>
   * - how many even and odd numbers have been chosen by each player <br>
   * - the extra points received by the player per game <br>
   * 
   * @param human
   *          The human player object.
   * @param cpu
   *          The CPU player object.
   * 
   * @author johnfrazer - x16138015
   */
  public void displayGameEndStats(MorraPlayer human, MorraCPUPlayer cpu) {

    System.out.println("Thanks for playing!");

    System.out.println("Player rounds won: " + human.getRoundsWonCount());
    System.out.println("Player rounds lost: " + human.getRoundsLostCount());

    System.out.println("Number of evens fingers: " + human.getEvenNumberCount());
    System.out.println("Number of odd fingers: " + human.getOddNumberCount());

    System.out.println("Bonus points won: " + human.getExtraPointsWon());

  }

}