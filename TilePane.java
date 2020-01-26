/**
TilePane class for Boggle game
@author Connor Burleson 
*/
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.geometry.Pos;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.paint.Paint; 
import javafx.scene.text.Text;
public class TilePane extends HBox
{
   // instance variables for TilePane objects
   private Tile tile;
   private String letter;
   private boolean clicked;
   
   /**
   this constructor takes a Tile object as its argument,
   and initializes the letter, tile, and clicked instance
   variables using the Tile's showLetter() method to construct
   a tile graphic for the 4X4 board of tiles
   @param tile The Tile object associated with the given TilePane  
   */
   public TilePane(Tile tile)
   { 
      // call super for HBox constructor
      super();
      
      // set tile equal to the Tile object
      this.tile = tile;
      
      // set letter equal to the Tile object character using showLetter()
      letter = tile.showLetter();
      
      // set size and alignment of TilePane
      this.setPrefSize(45,45);
      this.setAlignment(Pos.CENTER);
      defaultTile();
      
      // initialized clicked to false
      clicked = false;
      
      // create Text object from the TilePane letter and add to HBox
      Text t = new Text(letter);
      Font letterFont = new Font("Monotype Corsiva", 30);
      t.setFont(letterFont);
      t.setStyle("-fx-font-weight: bold");
      t.setFill(Color.WHITE);
      this.getChildren().add(t);
      
   }
   
   /** 
   the setSelected method changes the background color of the
   given TilePane, indicating to the user that the Tile has been
   selected, as well as setting the clicked variable equal to true
   */
   public void setSelected()
   {
      // change background color of TilePane 
      this.setStyle("-fx-border-width: 2;"
                 +"-fx-border-color: Maroon;" + 
                 "-fx-background-color:IndianRed;" +
                 "-fx-border-radius: 5;");   
                 
      // set clicked variable equal to true   
      clicked = true;
   }
   
   /**
   the setUnselected method calls the defaultTile() method
   in order to set the TilePane's background color to it's 
   original state (indicating to the user that the Tile has
   been unselected) and sets the clicked variable equal to false
   */
   public void setUnselected()
   {
      // call defaultTile to change background color of TilePane
      defaultTile();
      
      // set clicked to false
      clicked = false;
   }
   
   /** 
   the defaultTile method changes the background color of 
   the given TilePane back to its original state, indicating the 
   tile has been unselected 
   */
   public void defaultTile()
   {
      // change background color of TilePane to original state 
      this.setStyle("-fx-border-width: 2;"
                 +"-fx-border-color: Maroon;" + 
                 "-fx-background-color:FireBrick;" +
                 "-fx-border-radius: 5;");
   }
   
   /** 
   the getLetter method returns the letter instance variable
   associated with the given TilePane object (a String)
   */
   public String getLetter()
   {
      return letter;
   }
   
   /** 
   the getClicked method returns the clicked instance variable
   associated with the given TilePane object (boolean value)
   */
   public boolean getClicked()
   {
      return clicked;
   }
   
    /** 
   the getTile method returns the Tile object associated
   with the given TilePane object
   */
   public Tile getTile()
   {
      return tile; 
   }

   
   
}

