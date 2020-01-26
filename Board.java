/**
Board class for Boggle game
@author Connor Burleson 
*/

import java.util.ArrayList;
import java.util.Random;
public class Board
{
   // instance variable for board object
   private ArrayList<ArrayList<Tile>> board;
   
   // declare constant for number of columns and rows
   public static final int NUM_ROWS = 4;
   public static final int NUM_COLS = 4;

   
   /**
   this no-arg constructor makes a method call to the
   generateBoard method, assigning the returned "board" 
   of Tiles to the board instance variable for each Board
   object created
   */
   public Board()
   {
      board = generateBoard();
   }
   
   /**
   the generateBoard method creates and ArrayList containing
   four ArrayLists of Tiles (simulating each dice row) 
   the method creates all 16 die, loops through to generate 
   each row of randomly selected letters, and adds such rows to 
   the final tile "board" returned from the method
   @return tiles The ArrayList containing four ArrayLists of Tile 
   objects 
   */  
   private ArrayList<ArrayList<Tile>> generateBoard()
   {
          
      // declare ArrayList for entire board
      ArrayList<ArrayList<Tile>> tiles;
      
      // declare ArrayLists of tiles for each row 
      ArrayList<Tile> row0, row1, row2, row3;
      
      // declare ArrayLists of strings for all 16 die
      ArrayList<String> die0, die1, die2, die3, die4, die5,
      die6, die7, die8, die9, die10, die11, die12, die13, 
      die14, die15;
      
      // declare ArrayList for all 16 die
      ArrayList<ArrayList<String>> dice = new ArrayList<>();
      
      // create random object for selecting dice and their sides
      Random rand = new Random();
 
      // ** The following comments follow for each of the 16 die ** 
      
      // create new ArrayList for each die
      die0 = new ArrayList<>();
      
      // create array of Strings (each individual letter for that specific
      // die?
      String[] die0lets = new String[]{"R", "I", "F", "O", "B", "X"};
      
      // for each letter in the die String array, add that letter to the 
      // given die ArrayList
      for (String s: die0lets)
      {
         die0.add(s);
      }
      
      // add die ArrayList to the dice ArrayList
      dice.add(die0); 
      
      die1 = new ArrayList<>();
      String[] die1lets = new String[]{"I", "F", "E", "H", "E", "Y"};
      for (String s: die1lets)
      {
         die1.add(s);
      }
      dice.add(die1);
      
      die2 = new ArrayList<>();
      String[] die2lets = new String[]{"D", "E", "N", "O", "W", "S"};
      for (String s: die2lets)
      {
         die2.add(s);
      }
      dice.add(die2);
      
      die3 = new ArrayList<>();
      String[] die3lets = new String[]{"U", "T", "O", "K", "N", "D"};
      for (String s: die3lets)
      {
         die3.add(s);
      }
      dice.add(die3);
      
      die4 = new ArrayList<>();
      String[] die4lets = new String[]{"H", "M", "S", "R", "A", "O"};
      for (String s: die4lets)
      {
         die4.add(s);
      }
      dice.add(die4);
      
      die5 = new ArrayList<>();
      String[] die5lets = new String[]{"L", "U", "P", "E", "T", "S"};
      for (String s: die5lets)
      {
         die5.add(s);
      }
      dice.add(die5);
      
      die6 = new ArrayList<>();
      String[] die6lets = new String[]{"A", "C", "I", "T", "O", "A"};
      for (String s: die6lets)
      {
         die6.add(s);
      }
      dice.add(die6);
      
      die7 = new ArrayList<>();
      String[] die7lets = new String[]{"Y", "L", "G", "K", "U", "E"};
      for (String s: die7lets)
      {
         die7.add(s);
      }
      dice.add(die7);
      
      die8 = new ArrayList<>();
      String[] die8lets = new String[]{"Qu", "B", "M", "J", "O", "A"};
      for (String s: die8lets)
      {
         die8.add(s);
      }
      dice.add(die8);
      
      die9 = new ArrayList<>();
      String[] die9lets = new String[]{"E", "H", "I", "S", "P", "N"};
      for (String s: die9lets)
      {
         die9.add(s);
      }
      dice.add(die9);
      
      die10 = new ArrayList<>();
      String[] die10lets = new String[]{"V", "E", "T", "I", "G", "N"};
      for (String s: die10lets)
      {
         die10.add(s);
      }
      dice.add(die10);
      
      die11 = new ArrayList<>();
      String[] die11lets = new String[]{"B", "A", "L", "I", "Y", "T"};
      for (String s: die11lets)
      {
         die11.add(s);
      }
      dice.add(die11);
      
      die12 = new ArrayList<>();
      String[] die12lets = new String[]{"E", "Z", "A", "V", "N", "D"};
      for (String s: die12lets)
      {
         die12.add(s);
      }
      dice.add(die12);
      
      die13 = new ArrayList<>();
      String[] die13lets = new String[]{"R", "A", "L", "E", "S", "C"};
      for (String s: die13lets)
      {
         die13.add(s);
      }
      dice.add(die13);
      
      die14 = new ArrayList<>();
      String[] die14lets = new String[]{"U", "W", "I", "L", "R", "G"};
      for (String s: die14lets)
      {
         die14.add(s);
      }
      dice.add(die14);
      
      die15 = new ArrayList<>();
      String[] die15lets = new String[]{"P", "A", "C", "E", "M", "D"};
      for (String s: die15lets)
      {
         die15.add(s);
      }
      dice.add(die15);
      
      // create tiles ArrayList containing each row of tiles
      tiles = new ArrayList<>();
      
      // create random die and random die side variables to fill each
      // row 
      int rand_die;
      int rand_side;
      
      // ** The following comments apply to each of the four die rows ** 
      
      // fill row zero
      // create new ArrayList for row of dice 
      row0 = new ArrayList<>();
      
      // the following for loop will iterate once for each of the four
      // spots available in each die ArrayList, filling each with a random 
      // letter chosen from one of the 16 die 
      for (int i = 0; i < NUM_ROWS; i++)
      {
         // generate a random number for the randomly selected die 
         rand_die = rand.nextInt(dice.size());
         
         // select a random die from the dice ArrayList 
         ArrayList<String> die = dice.get(rand_die);
         
         // generate a random number for the randomly selected letter 
         rand_side = rand.nextInt(die.size());
         
         // select random letter from the selected die 
         String letter = die.get(rand_side);
         
         // create and add a new Tile object to the dice row, using the
         // randomly selected letter 
         row0.add(new Tile(letter, 0, i));
         
         // remove the randomly selected die from the dice ArrayList
         dice.remove(die);
      }
      
      // add the filled row of dice to the tiles ArrayList (containing each 
      // rows ArrayList of Tile objects
      tiles.add(row0);
      
      // fill row one
      row1 = new ArrayList<>();
      for (int i = 0; i < NUM_ROWS; i++)
      {
         rand_die = rand.nextInt(dice.size());
         ArrayList<String> die = dice.get(rand_die);

         rand_side = rand.nextInt(die.size());
         String letter = die.get(rand_side);
           
         row1.add(new Tile(letter, 1, i));
         dice.remove(die);
      }
      tiles.add(row1);
      
      // fill row two
      row2 = new ArrayList<>();
      for (int i = 0; i < NUM_ROWS; i++)
      {
         rand_die = rand.nextInt(dice.size());
         ArrayList<String> die = dice.get(rand_die);

         rand_side = rand.nextInt(die.size());
         String letter = die.get(rand_side);
           
         row2.add(new Tile(letter, 2, i));
         dice.remove(die);
      }
      tiles.add(row2);
      
      // fill row three
      row3 = new ArrayList<>();
      for (int i = 0; i < NUM_ROWS; i++)
      {
         rand_die = rand.nextInt(dice.size());
         ArrayList<String> die = dice.get(rand_die);

         rand_side = rand.nextInt(die.size());
         String letter = die.get(rand_side);
           
         row3.add(new Tile(letter, 3, i));
         dice.remove(die);
      }
      tiles.add(row3);
      
      // return the complete tiles ArrayList (containing all 16 die)
      return tiles;
   }
   
   /** this toString method overrides Java's default toString method,
   stepping through each row of the tiles ArrayList to print out their
   Tile object values (their letters)
   @return playingBoard The String of all 16 die letters 
   */
   @Override
   public String toString()
   {
      // create an empty playingBoard String 
      String playingBoard = "";
      
      // for each row in the board ArrayList, execute the following 
      // for loop 
      for (ArrayList<Tile> row: board)
      {
         // for each Tile object within the rows ArrayList, print out 
         // the Tile object's letter along with a space  
         for (int i = 0; i < NUM_ROWS; i++)
         {
            // if the Tile object's letter is the Qu tile, add one space
            // after it is added to playingBoard
            if (row.get(i).toString().equals("Qu"))
               // add the Tile's letter to the playingBoard string
               playingBoard += row.get(i) + " ";
            else
            // otherwise, add the Tile object's letter to playingBoard 
            // with two spaces 
               playingBoard += row.get(i) + "  ";
         }
         
         // after the row has been added to the playingBoard String, add 
         // a new line 
         playingBoard += "\n";
         
      }
      
      // return the complete playingBoard String 
      return playingBoard;
   }
   
   /**
   the getTile method returns the Tile object located
   at a specified row and column value on the board
   @param row The Tile's row 
   @param col The Tile's column
   @return The Tile at the specified row and column  
   */
   public Tile getTile(int row, int col)
   {
      return board.get(row).get(col);
   }
      
}