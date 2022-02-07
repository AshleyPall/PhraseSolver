/*
 * Activity 2.5.2
 *
 *  The PhraseSolver class the PhraseSolverGame
 */
import java.util.Scanner;
  
public class PhraseSolver
{
  /* your code here - attributes */
  private Player player1;
  private Player player2;
  private Board game;
  private boolean solved;


  /* your code here - constructor(s) */ 
public PhraseSolver(){
  player1 = new Player();
  player2 = new Player();
  game = new Board();
  solved = false;
}

  public void play()
  {
    boolean solved = false;
    int currentPlayer = 1;
    Scanner sc = new Scanner(System.in);
    String answer;
    Scanner input = new Scanner(System.in);
    
    boolean correct = true;
    while (!solved) 
    {
        correct = true;
    //set the current player to Player 1
    /* This if statment allows the players to switch from the prevous round, then if prints
    whose turn it is*/
      if (currentPlayer == 1){
        currentPlayer = 2;
        System.out.println(player2.getName() + " it is your turn.");
     }
      else {
        currentPlayer =1;
        System.out.println(player1.getName() + " it is your turn.");

     }


    //Prompt player for a guess
    /* This shows the player the solved phrase with blanks and tellls the player the letter value*/

      while(correct == true){
        game.setLetterValue();
        System.out.println(game.getSolvedPhrase());
        System.out.println(" ");
        System.out.println("The letter value right now is " + game.getLetterValue());
        /* This takes the user input of the player*/
        System.out.println("Please enter a letter to guess: ");
        answer = sc.nextLine();

      //see if letter is in the phrase, adds the points to whichever player's turn it is
          if(game.guessLetter(answer) == true){
            System.out.println(" ");
            System.out.println("Good job that letter is in the phrase!");
            if(currentPlayer == 1){
              player1.addToPoints(game.getLetterValue());
            }
            else{
              player2.addToPoints(game.getLetterValue());
            }
          }
          
             //see if the phrase is solved, breaks the loop if the correct phrase is guessed, adds points to winner
            else if(answer.equals(game.getPhrase())){
                solved = true;
                correct = false;
                //this ends the loop.
                System.out.println(" ");
                System.out.println("You guessed the right phrase, congrats!!! The game is now over.");
                if (currentPlayer == 1) {
                  player1.addToPoints(100);
                }
                else{
                  player2.addToPoints(100);
                }
             }
             else{
              correct = false;
              //switch players if the player 1 guesses wrong
              System.out.println(" ");
              System.out.println("This guess was wrong. It's the other player's turn");
             }
             // checks to make sure the whole phrase is solved and ends the loop if it is
            if (game.getSolvedPhrase().indexOf("_") == -1){
              solved = true;
              break;
            }

          
          }

    } 
    //Prints out the number of points each player has to show who won
    System.out.println(" ");
    System.out.println("Player 1's Points are:"+ player1.getPoints());
    System.out.println("Player 2's Points are:"+ player2.getPoints());
    if (player1.getPoints() > player2.getPoints()){
      System.out.println(" ");
      System.out.println("Player 1  won !!!");
    }
    else{
      System.out.println(" ");
      System.out.println("Player 2 won !!!");
    }
  }

  
}