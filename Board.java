/*
 * Activity 2.5.2
 *
 * A Board class the PhraseSolverGame
 */
import java.util.Scanner;
import java.io.File;

public class  Board
{
  private String phrase = "";
  private String solvedPhrase = "";
  private int currentLetterValue; 

  /* your code here - constructor(s) */ 
  public Board() {
    phrase = loadPhrase();
    setLetterValue();
  }

  
  /* your code here - accessor(s) */

  public String getPhrase() {
    return phrase;
  }

  public String getSolvedPhrase() {
    return solvedPhrase;
  }

  public int getLetterValue() {
    return currentLetterValue;
  }

  /* ---------- provided code, do not modify ---------- */
  public void setLetterValue()
  {
    int randomInt = (int) ((Math.random() * 10) + 1) * 100;    
    currentLetterValue = randomInt;
  }

  public boolean isSolved(String guess)
  {
    if (phrase.equals(guess))
    {
      return true;
    }
    return false;
  }

  private String loadPhrase()
  {
    String tempPhrase = "";
    
    int numOfLines = 0;
    try 
    {
      Scanner sc = new Scanner(new File("phrases.txt"));
      while (sc.hasNextLine())
      {
        tempPhrase = sc.nextLine().trim();
        numOfLines++;
      }
    } catch(Exception e) { System.out.println("Error reading or parsing phrases.txt"); }
    
		int randomInt = (int) ((Math.random() * numOfLines) + 1);
    
    try 
    {
      int count = 0;
      Scanner sc = new Scanner(new File("phrases.txt"));
      while (sc.hasNextLine())
      {
        count++;
        String temp = sc.nextLine().trim();
        if (count == randomInt)
        {
          tempPhrase = temp;
        }
      }
    } catch (Exception e) { System.out.println("Error reading or parsing phrases.txt"); }
    
    for (int i = 0; i < tempPhrase.length(); i++)
    {
      if (tempPhrase.substring(i, i + 1).equals(" "))
      {
        solvedPhrase += "  ";
      }  
      else
      {
        solvedPhrase += "_ ";
      }
    }  
    
    return tempPhrase;
  }  

  //This creates a guessLetter method and has a parameter that takes a letter or reprints the statement 
  //with blanks to show the letters that still need to be guessed 
  /* Preconditions: String guess because we need a letter to test and see if it
   is in the string (this is a parameter). */ 
  /* Postconditions: foundletter is returned, and solvedphrase is being updates based
  on the guess the player makes.*/ 

  public boolean guessLetter(String guess)
  {
    //This creates a foundLetter variable that is set to false
    boolean foundLetter = false;
    //This created a newSolvedPhrase variable that creates a new blank string 
    String newSolvedPhrase = "";
    
    //This is a for loop that sets a value to i and creates a condition for the loop to 
    //continue, each time it iterates through the loop it adds one to i
    //i must be smaller then the phraselength for the loop to continue working
    for (int i = 0; i < phrase.length(); i++)
    {
      //This creates a substring from i to i+1 that is set equal to  the guess string
      if (phrase.substring(i, i + 1).equals(guess))
      {
        newSolvedPhrase += guess + " ";
        //This adds on to the blank string by adding the guessed letter 
        foundLetter = true;
        //this changed the boolean value and sets it to true because all conditions were
        //true for the if statement and this letter is in the phrase
      }
      else
      {
        //This is what happend if the conditions are not met in the if statment
        //either adds letters already guessed or a blank underscore to represent a letter that needs 
        //to be guessed 
        newSolvedPhrase += solvedPhrase.substring(i * 2, i * 2 + 1) + " ";  
      }
    }
    //sets the phrases equal to each other, because they should display the same information
    solvedPhrase = newSolvedPhrase;
    //returns the found letter to show which letter has been guessed 
    return foundLetter;
  } 
} 