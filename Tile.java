/**
Tile class for Boggle game
@author Connor Burleson 
*/
import java.util.ArrayList;
public class Tile 
{
   // create instance variables
   private char letter;
   private int row;
   private int col;
   private boolean show;
   
   // for cases of "Qu" tile
   private boolean quLetter = false;
   private String qu;
      
   /** 
   this Tile constructor accepts a character,
   row (int), and column (int) and assigns such
   values to the Tile object's instance variables
   @param let The letter of the Tile object
   @param r The row the Tile object is located in 
   on the playing board
   @param c The column the Tile object is located 
   in on the playing board
   */
   public Tile(char let, int r, int c)
   {
      letter = let;
      row = r;
      col = c;
   }
   
   /** 
   this Tile constructor is a replica of the first
   constructor, except the first parameter is defined
   as a String for cases of the "Qu" tile
   @param let The letter of the Tile object
   @param r The row the Tile object is located in 
   on the playing board
   @param c The column the Tile object is located 
   in on the playing board
   */
   public Tile(String let, int r, int c)
   {
      // if this constructor is called, set "Qu" tile flag
      // to true
      quLetter = true;
      qu = let;
      row = r;
      col = c;
   }
   
   /** 
   the showLetter method returns the character associated
   with a given Tile object as a String (handling cases if 
   there is a "Qu" Tile object)
   @return c The Tile character as a String
   @return qu The "Qu" String representing a "Qu" Tile object
   */
   public String showLetter()
   {
      // convert Tile object character to a String 
      String c = Character.toString(letter);
      // if not a "Qu" tile, return Tile char as a String
      if (!quLetter)
         return c;
      // otherwise, return the qu String 
      else
         return qu;
   }
   
   /** 
   this toString method overrides the default toString method,
   printing out the letter(s) of the Tile object depending on 
   its letter value (single character or "Qu") using the 
   showLetter method
   @return letter The letter of the Tile object 
   */
   @Override
   public String toString()
   {
      String letter = showLetter(); // call showLetter method
      return letter; 
   }
   
   /** the getRow method returns the row value of the
   Tile object
   @return row The row of the given Tile object
   */
   public int getRow()
   {
      return row;
   }
   
   /** the getCol method returns the column value of the
   Tile object
   @return col The column of the given Tile object
   */
   public int getCol()
   {
      return col;
   }
   
   /** this equals method overrides the default equals method,
   returning true if the two Tile objects are located in the same
   column and row, and false otherwise
   @return true If the two Tile objects are located in the same 
   row and column
   @return false If the two Tile objects are not in the same location
   */
   @Override
   public boolean equals(Object other)
   {
      if (this == other) // if the two objects are the same, return true
         return true;
      if (other == null) // if the object is empty, return false
         return false;
      // if the two objects are within different classes, return false
      if (getClass() != other.getClass())
         return false;
      Tile otherTile = (Tile)other; // cast "other" object as Tile object
      if (row == otherTile.getRow() && col == otherTile.getCol())
         return true; // if row and column are equal, return true
      else
         return false; // otherwise, return false
         
   }
   
   public void setShow(boolean s)
   {
      show = s;
   }
}
