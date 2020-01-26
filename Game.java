/**
Game class for Boggle game
@author Connor Burleson 
*/
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Game
{
   // create instance variables
   private ArrayList<Tile> selected;
   private ArrayList<String> words;
   private int points;
   private Board board;
   private Word word;
   private Dictionary dict;
   private boolean valid;
   
   /**
   This no argument constructor creates a Game object
   with empty ArrayLists for the "selected" and "words"
   instance variables. A Board object is created for the 
   games randomly generated tile board, and a Dictionary 
   object is created to handle word validity within the game.
   The Game object's points value is initialized to zero.
   */
   public Game() throws IOException
   {
      // create new ArrayList for selected Tile objects
      selected = new ArrayList<>();
      
      // create new ArrayList for words formed from Tiles 
      words = new ArrayList<>();
      
      // create a new Board object (playing board of Tiles)
      board = new Board();
      

      // create a new Dictionary object (for word validation)
      dict = new Dictionary("dictionary.txt");
    
      
      // initialize points value to zero 
      points = 0;
   }
   
   /**
   the addToSelected method accepts a Tile object's row
   and column value in relation to the Tile board, and 
   adds that Tile object to the selected ArrayList of 
   Tile objects
   @param row The row value of the Tile object
   @param col The column value of the Tile object
   */
   public void addToSelected(int row, int col)
   {
      // add the Tile object at the given row and column
      // of the playing board to the selected ArrayList
      selected.add(board.getTile(row, col));
   }
   
   /**
   the removeFromSelected method accepts a Tile object's 
   row and column value in relation to the Tile board, and
   removes that Tile object from the selected ArrayList of
   Tile objects 
   @param row The row value of the Tile object
   @param col The column value of the Tile object 
   */
   public void removeFromSelected(int row, int col)
   {
      // remove the Tile object at the given row and column
      // of the playing board from the selected ArrayList
      selected.remove(board.getTile(row, col));
   }
   
   /** 
   the clearSelected method clears the selected ArrayList of
   Tile objects using the ArrayList clear method
   */
   public void clearSelected()
   {
      // clear the selected ArrayList of Tile objects 
      selected.clear();
   }
   
   /**
   the isValidSelection method accepts a Tile object's row 
   and column and returns a boolean value dependent on whether
   the given Tile is adjacent to the user's previously selected
   Tile object or not
   @param row The row value of the Tile object
   @param col The column value of the Tile object 
   @return isValid The boolean variable (depicting the validity
   of the Tile choice) 
   */
   public boolean isValidSelection(int row, int col)
   {
      // initialize isValid to true
      boolean isValid = true;
      
      // if the selected ArrayList is not empty 
      if (selected.size() >= 1)
      {
         // get previously selected tile from selected ArrayList
         Tile prevTile = getPrevSelected();
         
         // if the difference between the row values or the column 
         // values of the previously selected tile and the currently
         // selected tile are two or greater, set isValid to false
         if (Math.abs(prevTile.getCol() - col) >= 2 || 
            Math.abs(prevTile.getRow() - row) >= 2)
               isValid = false; 
      }
      
      // return the boolean value of isValid     
      return isValid;
   }
   
   /**
   the testSelected method determines whether or not the Tiles 
   selected by the user form a valid word in comparison to the 
   provided dictionary text file
   */
   public void testSelected() 
   {
      // if the selected ArrayList forms a valid word, execute
      // the following code
      if (dict.isValidWord(selected) && (!wordUsed()))
      {
         // create a new Word object using the selected Tiles
         word = new Word(selected);
         
         // add the word (String) to the words ArrayList 
         words.add(word.toString());
         
         // add the corresponding points value from the Word
         // object to the points instance variable 
         points += word.getPoints();
      }
   }
   
   /**
   the getSelectedTiles method simply returns the selected 
   ArrayList of Tile objects 
   @return selected The ArrayList of selected Tile objects
   */
   public ArrayList<Tile> getSelectedTiles()
   {
      return selected;
   }
   
   /** 
   the getTile method accepts a row and column value as 
   arguments, and calls the getTile method from the Board 
   class to return the given Tile object at that row and 
   column
   @return The Tile object at the given row and column 
   */
   public Tile getTile(int row, int col)
   {
      return board.getTile(row, col);
   }
   
   /**
   this toString method overrides Java's default toString
   method, printing out the playing board of Tiles, selected 
   ArrayList, the ArrayList of words created, and the number 
   of points the user has 
   @return The playing board, selected ArrayList, words 
   ArrayList, and the user's points
   */
   @Override
   public String toString()
   {
      return board + "\n" + "selected: " + selected + "\n\n" 
            + "words: " + words + "\n\n" + "score: " + points;
   }
   
   public Tile getPrevSelected()
   {
      return selected.get(selected.size() - 1);
   }
   
   public int getPoints()
   {
      return points;
   }
   
   public boolean validWord()
   {
      if (dict.isValidWord(selected))
         valid = true;
      else
         valid = false;
      return valid;
   }
   
   public ArrayList<String> getWordsList()
   {
      return words;
   }
   
   public boolean wordUsed()
   {
      boolean used = false;
      String theWord = word.createWord(selected);
      for (String word: words)
      {
         if (word.equals(theWord))
            used = true;
      }
      
      return used;
   }

}