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
   * @author Marcos Figueira - x16135041
   */
  public boolean humanPlayerTypeSelectionMenu(Scanner keyboardIn) {
    boolean selectedOdds = true;

    keyboardIn = new Scanner(System.in);
    int selection = 0;

    do{
      System.out.println("Would you like to play Odds or Even? Please select");
      System.out.println("1. Odds");
      System.out.println("2. Even");
      selection = keyboardIn.nextInt();
    } while (selection != 1 && selection != 2);
  
    if (selection == 1){
      selectedOdds = true;
    }
    else selectedOdds = false;

    return selectedOdds;
  }
///**
//  * Alternate version by: 
//  * @author johnfrazer - x16138015
//  */
//public boolean humanPlayerTypeSelectionMenu(Scanner keyboardIn) {
// boolean selectedOdds = true;
// boolean loopCondition = true;
//
// do {
//   System.out.print("Select if you are: \n\t1. Odds \n\t2. Evens\nChoose: ");
//   int playerTypeChoice = keyboardIn.nextInt();
//
//   switch (playerTypeChoice) {
//   case 1:
//     // Player has selected Odds
//     selectedOdds = true;
//     // exit the loop
//     loopCondition = false;
//     break;
//   case 2:
//     // Player has selected Evens
//     selectedOdds = false;
//     // exit the loop
//     loopCondition = false;
//     break;
//   default:
//     // Error: user input something other than 1 or 2.
//     System.out.println("Invalid selection. Try again.\n");
//     break;
//   }
//
// } while (loopCondition);
//
// return selectedOdds;
//}

///**
//  * Alternate version by: 
//  * @author ben
//  */
//public boolean humanPlayerTypeSelectionMenu(Scanner keyboardIn) {
// boolean choiceOdds = true;
// boolean loopCondition = true;
//  int choice = 0;
//  do
//  {
//    System.out.println("Do you choose Odds or Even? Please select");
//    System.out.println("1. Odds");
//    System.out.println("2. Even");
//    choice = keyboardIn.nextInt();
//  } while (choice !=1 && choice !=2);
//
//  if (choice ==1)
//  {
//    choiceOdds = true;
//  }
//   else choiceOdds = false;
//
//  return choiceOdds; 
//
//}

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
   * @author johnfrazer - x16138015
   */
  public void setPlayerTypes(MorraPlayer human, MorraCPUPlayer cpu, boolean playerSelectedOdds) {
    if (playerSelectedOdds) {
      // if the player has selected odds, set the player as odds, and the cpu as
      // evens.
      human.setAsOdds();
      cpu.setAsEvens();
    } else {
      // if the player has NOT selected odds, set the player as evens, and the
      // cpu as odds.
      human.setAsEvens();
      cpu.setAsOdds();
    }
  }
  
  /**
   * This method gets the number of fingers the player wants to "hold out".
   *
   * @param keyboardIn
   *          The scanner object for accepting user input.
   *
   * @return The number of fingers "held out".
   *
   * @author Marcos Figueira - x16135041
   */
  public int getPlayerFingersHeldOut(Scanner keyboardIn) {
    int playerFingers = 0;

    keyboardIn = new Scanner(System.in);

    do {
      System.out.println("How many fingers would you like to play?");
      playerFingers = keyboardIn.nextInt();
    } while (playerFingers < 0 || playerFingers > 10);

    return playerFingers;
  }
///**
// * Alternate version by: 
// * @author johnfrazer - x16138015
// */
//public int getPlayerFingersHeldOut(Scanner keyboardIn) {
//  int playerFingers = 0;
//
//  do {
//    System.out.print("Enter your Morra Fingers Guess (1-10): ");
//    playerFingers = keyboardIn.nextInt();
//  } while (playerFingers < 0 || playerFingers > 11);
//
//  return playerFingers;
//}
  
///**
//  * Alternate version by: 
//  * @author ben
//  */
//public int getPlayerFingersHeldOut(Scanner keyboardIn) {
//int playerFingers = 0;
//  do {
//    System.out.println("How many fingers would you like to display?");
//    playerFingers = keyboardIn.nextInt();
//  } while (playerFingers < 0 || playerFingers > 10);
//
//    return playerFingers;
//  }  

  /**
   * This method calculates updates to the players scores in a game round,
   * displays which player has won, and some information on why.
   * 
   * The winner of the round is decided based on the sum of fingers shown by both
   * players, namely if the sum is an even number then the 'Evens' player wins,
   * otherwise if the sum is an odd number then the 'Odds' player wins. The
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
        System.out.println("You win this round! (The total, " + totalFingersShown + ", is even)");
      } else if (!cpu.isPlayerOdds()) {
        cpu.roundWinnerPointsUpdate();
        human.updateLostRoundCount();
        System.out.println("CPU wins this round! (The total, " + totalFingersShown + ", is even)");
      }
    } else if (totalFingersShown % 2 == 1) {
      // result is ODD; odds player wins
      if (human.isPlayerOdds()) {
        human.roundWinnerPointsUpdate();
        human.updateWonRoundCount();
        System.out.println("You win this round! (The total, " + totalFingersShown + ", is odd)");
      } else if (cpu.isPlayerOdds()) {
        cpu.roundWinnerPointsUpdate();
        human.updateLostRoundCount();
        System.out.println("CPU wins this round! (The total, " + totalFingersShown + ", is odd)");
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
  
//  /**
//   * Alternate version by: 
//   * @author Marcos Figueira - x16135041
//   */
//  public void calculateScoreChanges(MorraPlayer human, MorraCPUPlayer cpu) {
//
//    // Calculate who wins the points for being Odds or Evens.
//
//    int totalPlayed = human.getFingers() + cpu.getFingers();
//
//    if (totalPlayed % 2 == 0){
//    if (human.isPlayerOdds() == false){
//      human.roundWinnerPointsUpdate();
//      human.updateWonRoundCount();
//      cpu.updateLostRoundCount();
//      System.out.println("Player wins this round (" + totalPlayed + " is even).");
//    }
//    else {
//      cpu.roundWinnerPointsUpdate();
//      cpu.updateWonRoundCount();
//      human.updateLostRoundCount();
//      System.out.println("CPU wins this round (Total played " + totalPlayed + " is even).");
//    }
//  }
//  else{
//    if (human.isPlayerOdds() == true){
//      human.roundWinnerPointsUpdate();
//      human.updateWonRoundCount();
//      cpu.updateLostRoundCount();
//      System.out.println("Player wins this round (Total played " + totalPlayed + " is odd).");
//    }
//    else {
//      cpu.roundWinnerPointsUpdate();
//      cpu.updateWonRoundCount();
//      human.updateLostRoundCount();
//      System.out.println("CPU wins this round (Total played " + totalPlayed + " is odd).");
//    }
//  }
//
//    // Calculate who wins the bonus point for being closer to the total.
//    if (Math.abs(totalPlayed - human.getFingers()) < Math.abs(totalPlayed - cpu.getFingers())){
//     human.closerToTheSumBonusPointUpdate();
//     System.out.println("Player wins Bonus points (" + human.getFingers() + " is closer to the total fingers played - " + totalPlayed + ").");
//   }
//   else if (Math.abs(totalPlayed - human.getFingers()) > Math.abs(totalPlayed - cpu.getFingers())){
//     cpu.closerToTheSumBonusPointUpdate();
//     System.out.println("CPU wins Bonus points (" + cpu.getFingers() + " is closer to the total fingers played - " + totalPlayed + ").");
//   }
//   else{
//     human.closerToTheSumBonusPointUpdate();
//     cpu.closerToTheSumBonusPointUpdate();
//     System.out.println("Both players win Bonus points (Both guesses are closer to the total fingers played - " + totalPlayed + ").");
//   }
//  }
  
///**
//* Alternate version by: 
//* @author ben
//*/
//public void calculateScoreChanges(MorraPlayer human, MorraCPUPlayer cpu) {
//  int totalFingersPlayed = human.getFingers() + cpu.getFingers();
//
//        //We divide by 2 the numbers of fingers and if the modulus is equal to 0 we know that it is not an odds number.
//        // Then we had the bonus point by updating the score
//        if (totalFingersPlayed  % 2 == 0){
//
//        if (human.isPlayerOdds() == false){
//          human.roundWinnerPointsUpdate();
//        }
//        else {
//          //CPU player won the bounus point so we had it to his score 
//          cpu.roundWinnerPointsUpdate();
//        }
//      }
//      else{
//        if (human.isPlayerOdds() == true){
//          // human player won the bounus point so we had it to his score 
//          human.roundWinnerPointsUpdate();
//        }
//        else {
//          cpu.roundWinnerPointsUpdate();
//        }
//      }
//
//      if (human.score > cpu.score){
//        human.updateWonRoundCount();
//        cpu.updateLostRoundCount();
//        System.out.println("Player wins this round:");
//        System.out.println("Player displayed: " + human.getFingers());
//        System.out.println("CPU displayed: " + cpu.getFingers());
//        System.out.println("Player score: " + human.score);
//        System.out.println("CPU score: " + cpu.score);
//
//      }
//      else{
//        cpu.updateWonRoundCount();
//        human.updateLostRoundCount();
//        System.out.println("CPU wins this round:");
//        System.out.println("Player displayed: " + human.getFingers());
//        System.out.println("CPU displayed: " + cpu.getFingers());
//        System.out.println("Player score: " + human.score);
//        System.out.println("CPU score: " + cpu.score);  
//        
//// Calculate who wins the points for being Odds or Evens.
// 
//// Calculate who wins the bonus point for being closer to the total.
//  if (totalPlayed - human.getFingers()) <( totalPlayed - cpu.getFingers())
//  {
//     human.closerToTheSumBonusPointUpdate();
//   }
//   else if (totalPlayed - human.getFingers()) > (totalPlayed - cpu.getFingers()){
//     cpu.closerToTheSumBonusPointUpdate();
//   }
//   else{
//     human.closerToTheSumBonusPointUpdate();
//     cpu.closerToTheSumBonusPointUpdate();
//   }  
// }

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

    // Reset the player fingers held out history
    human.resetFingerHistory();
    cpu.resetFingerHistory();
  }

  /**
   * This method compares the player's score to the cpu player's score, and
   * displays the game winner.
   * 
   * @param humanScore
   * @param cpuScore
   * 
   * @author johnfrazer - x16138015
   */
  private void displayGameWinner(int humanScore, int cpuScore) {
    // The winner of the game is the first player who accumulates six points.
    if (humanScore > cpuScore) {
      // player wins
      System.out.println("Player wins " + humanScore + "-" + cpuScore + "!!!");
    } else if (humanScore < cpuScore) {
      // cpu wins
      System.out.println("CPU wins " + cpuScore + "-" + humanScore + "!!!");
    } else {
      // tie game
      System.out.println("Game tied, " + humanScore + "-" + cpuScore + ".");
    }
  }
  
//  /**
//   * Alternate version by: 
//   * @author Marcos Figueira - x16135041
//   */
//  private void displayGameWinner(int humanScore, int cpuScore) {
//    // The winner of the game is the firrst player who accumulates six points.
//
//    if (humanScore >= 6 || cpuScore >= 6){
//
//    if (humanScore > cpuScore){
//      System.out.println("Player wins!");
//    }
//    else if (humanScore == cpuScore){
//      System.out.println("Draw!");
//    }
//    else {
//      System.out.println("CPU wins!");
//    }
//  }
//  }

  /**
   * Display the numbers of fingers shown by both the user and the computer per
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
   * @author johnfrazer - x16138015
   */
  public boolean playAnotherGame(Scanner keyboardIn) {
    boolean playAgain = false;
    boolean playAgainLoopCondition = false;

    do {
      System.out.print("Would you like to play again? Y/N: ");
      String playAgainStr = keyboardIn.next();

      System.out.println(""); // extra line for console formatting

      if (playAgainStr.equalsIgnoreCase("Y")) {
        playAgain = true;
        playAgainLoopCondition = true;

      } else if (playAgainStr.equalsIgnoreCase("N")) {
        playAgain = false;
        playAgainLoopCondition = true;

      }
    } while (!playAgainLoopCondition);

    return playAgain;
  }
  
//  /**
//   * Alternate version by: 
//   * @author Marcos Figueira - x16135041
//   */
//  public boolean playAnotherGame(Scanner keyboardIn) {
//    boolean playAgain = false;
//    boolean playAgainLoopCondition = false;
//
//  char selection;
//
//  do{
//    System.out.println("Would you like to play again? (y/n)");
//    selection = keyboardIn.next().charAt(0);
//  } while (Character.toLowerCase(selection) != 'y' && Character.toLowerCase(selection) != 'n');
//
//  if (Character.toLowerCase(selection) == 'y'){
//    playAgain = true;
//    playAgainLoopCondition = true;
//  }
//  else {
//    playAgain = false;
//      playAgainLoopCondition = false;
//    }
//
//    return playAgain;
//  }

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

    System.out.println("Number of Player evens fingers: " + human.getEvenNumberCount());
    System.out.println("Number of Player odd fingers: " + human.getOddNumberCount());

    System.out.println("Number of CPU evens fingers: " + cpu.getEvenNumberCount());
    System.out.println("Number of CPU odd fingers: " + cpu.getOddNumberCount());

    System.out.println("Bonus points won: " + human.getExtraPointsWon());

  }

}
