/**
Word class for Boggle game
@author Connor Burleson 
*/
import java.util.ArrayList;
import java.io.*;
public class Word
{
   // create instance variables
   private String word;
   static int points;
   
   /** 
   this constructor takes in an ArrayList of Tile objects,
   and makes a method call to createWord and calcPoints in 
   order to assign the Word object its value (a String) and 
   the number of points the Word object is worth
   @param tiles The ArrayList of Tile objects 
   */
   public Word(ArrayList<Tile> tiles)
   {
      word = createWord(tiles);
      points = calcPoints(word);
   }
   
   /** 
   the calcPoints method takes in a String (a word) and 
   assigns the point value of the given Word object according
   to the length of the word
   @word The String (word) of the Word object 
   */
   static int calcPoints(String word)
   {
      // assign points to specific integer value depending on 
      // the following word length conditions
      if (word.length() == 3 || word.length() == 4)
         points = 1;
      
      else if (word.length() == 5)
         points = 2;
      
      else if (word.length() == 6)
         points = 3;
         
      else if (word.length() == 7)
         points = 5;
         
      else
         points = 11;
      
      return points;
   }
   
   /** 
   the createWord method takes in an ArrayList of Tile objects
   and creates a StringBuilder "String" using the letters of 
   each Tile object within the ArrayList 
   @param tiles The ArrayList of Tile objects
   @return tileWord The String (word) created by the Tile objects
   */
   public static String createWord(ArrayList<Tile> tiles)
   {
      StringBuilder tileWord = new StringBuilder(); // create String 
      
      // append letters of each Tile object to tileWord String
      for (int i = 0; i < tiles.size(); i++)
      {
         tileWord.append(tiles.get(i).showLetter().toUpperCase());
      }
      
      // return tileWord as String 
      return tileWord.toString();
   }
   
   /** the getPoints method returns the points value of the given
   Word object
   @return points The points value of the given Word object 
   */
   public int getPoints()
   {
      return points;
   }
   
   /** this toString method overrides the default toString method 
   to return the Word object as a String rather than its address in 
   memory 
   @return word The word (String) associated with the Word object 
   */
   @Override
   public String toString()
   {
      return word;
   }
}