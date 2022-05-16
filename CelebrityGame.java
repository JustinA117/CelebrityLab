import java.util.ArrayList;
import java.util.Scanner;

/**
 * The framework for the Celebrity Game project
 * 
 * @author cody.henrichsen
 * @version 2.3 25/09/2018 refactored the prepareGame and play methods
 */
public class CelebrityGame
{
	/**
	 * A reference to a Celebrity or subclass instance.
	 */
	 Celebrity gameCelebrity()
{
		Celebrity gameCelebrity = new Celebrity();
  
}
	

	/**
	 * The GUI frame for the Celebrity game.
	 */  CelebrityFrame gameWindow; 

	/**
	 * The ArrayList of Celebrity values that make up the game
	 */private ArrayList<Celebrity> celebGameList;  

	/**
	 * Builds the game and starts the GUI
	 */
	public CelebrityGame()
	{
	  gameWindow = new CelebrityFrame(this);
    celebGameList = new ArrayList<Celebrity>();
	}

 /**
   * Prepares the game to start by re-initializing the celebGameList and having the gameFrame open the start screen.
   */
  public void prepareGame()
  {
    celebGameList = new ArrayList<Celebrity>();
    gameWindow.replaceScreen("START");
  }

	/**
	 * Determines if the supplied guess is correct.
	 * 
	 * @param guess
	 *            The supplied String
	 * @return Whether it matches regardless of case or extraneous external
	 *         spaces.
	 */
	public boolean processGuess(String guess)
	{
// uses the trum method to ignore spaces and ignore case to ignore the uppercase letters
    if (guess.trim().equalsIgnoreCase(gameCelebrity.getName())){
    celebGameList.remove(0); 
    if (celebGameList.size() > 0){
      gameCelebrity= celebGameList.get(0);
    } else
    {
    gameCelebrity = new Celebrity("",""); 
    }
		return true;
	}
else {
return false; 
}
}
  /**
   * Asserts that the list is initialized and contains at least one Celebrity.
   * Sets the current celebrity as the first item in the list. Opens the game
   * play screen.
   */
  public void play()
  {
    if (celebGameList != null && celebGameList.size() > 0)
    {
      this.gameCelebrity = celebGameList.get(0);
      gameWindow.replaceScreen("GAME");
    }
  }

	/**
	 * Adds a Celebrity of specified type to the game list
	 * 
	 * @param name
	 *            The name of the celebrity
	 * @param guess
	 *            The clue(s) for the celebrity
	 * @param type
	 *            What type of celebrity
	 */
	public void addCelebrity(String name, String guess, String type)
	{
    if (validateCelebrity(name) && validateClue(guess,"")){
      celebGameList.add(newCelebrity(name, guess));
    }
    else {
      System.out.println("Cannot add this celbrity)"); 
    }
	}

	/**
	 * Validates the name of the celebrity. It must have at least 4 characters.
	 * @param name The name of the Celebrity
	 * @return If the supplied Celebrity is valid
	 */
	public boolean validateCelebrity(String name)
	{
	
	if (name.trim().equals(name)&&(name.length()>=4))
	{
		return true; 
	}
    else{
		return false;
	}}

	/**
	 * Checks that the supplied clue has at least 10 characters or is a series of clues
	 * This method would be expanded based on your subclass of Celebrity.
	 * @param clue The text of the clue(s)
	 * @param type Supports a subclass of Celebrity 
	 * @return If the clue is valid.
	 */
	public boolean validateClue(String clue, String type)
	{
    if (clue.trim().equals(clue)&&(clue.length() >= 10)){
		return true;
	} else 
    {return false;}
    }


	/**
	 * Accessor method for the current size of the list of celebrities
	 * 
	 * @return Remaining number of celebrities
	 */
	public int getCelebrityGameSize()
{
    return celebGameList.size(); 
	}

	/**
	 * Accessor method for the games clue to maintain low coupling between
	 * classes
	 * 
	 * @return The String clue from the current celebrity.
	 */
	public String sendClue()
	{
    /* To be implemented */

return gameCelebrity.getClue();	}
}
