/**
Dictionary class for Boggle game
@author Connor Burleson 
*/
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
public class Dictionary 
{
   // create instance variable for dictionary 
   private ArrayList<String> dictList;
   
    
   /** this constructor creates an array of words
   from a dictionary text file
   the constructor accepts the file name (String) as 
   an argument and creates the word array from such file
   @param filename The name of the dictionary text file
   */
   public Dictionary(String filename) throws IOException
   {
      // connect dictionary text file to read from
      Scanner infile = new Scanner(new File(filename));
      
      // create ArrayList for words in dictionary text file
      dictList = new ArrayList<>(); 
      
      // while the file containts more words, add such words
      // to the dictList array
      while (infile.hasNext())
      {
         String line = infile.nextLine();
         
         // add word to dictList array
         dictList.add(line.toUpperCase());
      }
      
      infile.close(); // close input file when finished
   }
   
   /**
   the isValidWord method accepts an ArrayList of tile objects
   as its argument and creates a String from the letters assigned
   to each object (in order)
   the method then searches the dictList array to see if the String
   (word) is a valid word, returning a corresponding boolean value
   @param tiles The ArrayList of tile objects
   @return true The Tile objects form a valid word
   @return false The Tile objects do not form a valid word
   */
   public boolean isValidWord(ArrayList<Tile> tiles)
   {
      StringBuilder tileWord = new StringBuilder(); // create String 
      
      // append letters of each Tile object to tileWord String
      for (int i = 0; i < tiles.size(); i++)
      {
         tileWord.append(tiles.get(i).showLetter().toUpperCase());
      }
      
      // initialize boolean isValid to false
      boolean isValid = false;
      
      // iterate through dictionary elements 
      for (int i = 0; i < dictList.size(); i++)
      {
         // if tileWord matches any of the dictionary elements, set 
         // isValid to true and exit for loop
         if (tileWord.toString().equals(dictList.get(i)))
         {   
            isValid = true;
            break;
         }
      }
      
      // return boolean value 
      return isValid;
       
   }
}