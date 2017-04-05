package sdev.ca.pbl.morra;

/**
 * MorraCPUPlayer is an extension of the MorraPlayer.
 * 
 * This means that a MorraCPUPlayer object will work in the exact same way as
 * teh MorraPlayer, except that the CPU player can also do the actions below.
 * 
 * This class will be used for any work that the computer needs to do in order
 * to replace human interaction.
 */
public class MorraCPUPlayer extends MorraPlayer {

  /**
   * Default constructor for MorraCPUPlayer.
   * 
   * @author johnfrazer - x16138015
   */
  public MorraCPUPlayer() {
    // This constructor is intentionally empty.
  }

  /**
   * This method uses Java ThreadLocalRandom to select a pseudo-random number
   * between 1 and 10 (inclusively) for the CPU controlled player.
   * 
   * @author
   */
  public void setFingers() {
    int randomFingers = 4; // https://xkcd.com/221/ :)

    // TODO: Investigate how you would use Java to get a random number between
    // 10 and 10 here.

    super.setFingers(randomFingers);
  }
}
