/**
Boggle GUI - Full Game 
@author Connor Burleson 
*/

// import required classes for Java FX
import javafx.application.Application; 
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.text.*;
import javafx.geometry.Pos;
import javafx.scene.paint.Paint;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Hyperlink; 
import java.io.*;
public class BoggleGUI extends Application
{
   // declare variables for GUI
   private Game boggle;
   private GridPane dieGrid;
   private BorderPane mainPane; 
   private Scene scene;
   private VBox statusPane;
   private VBox bottomPane;
   private HBox buttonPane;
   private HBox statusBar;
   private HBox wordBuilder;
   private Text title;
   private Text status;
   private Text builtWord;
   private Text wordsLabel;
   private Text pointsLabel;
   private Text points;
   private Text pointNotif;
   private Text signature;
   private Button submit;
   private Button exit;
   private Button clear;
   private Button newGame;
   private VBox wordList;
   private VBox words;
   private VBox pointsPane;
   
   /** 
   this start method (part of JavaFX) contains all
   graphics, user interaction events, and game logic 
   required to play a fully functional Boggle game 
   @param primaryStage The standard JavaFX initial stage
   */
   @Override
   public void start(Stage primaryStage)
   {
      // error handling for possible IO exception when locating 
      // the dictionary.txt file (from creating a Game object)
      try
      {
         // create new Game object 
         boggle = new Game();
      }
      catch (IOException ex)
      {}
      
      // create GridPane for dice board 
      dieGrid = new GridPane();
      
      // CSS styling for the die grid
      dieGrid.setStyle("-fx-border-radius: 5;" +
                       "-fx-border-width: 3;" + 
                       "-fx-border-color: white;");
                       
      // align and resize die grid
      dieGrid.setAlignment(Pos.CENTER);
      
      // main pane for entire game 
      mainPane = new BorderPane();
      
      // add CSS styling to the BorderPane
      mainPane.setStyle("-fx-background-color: #2f4f4f;" + 
                       "-fx-border-width: 2;" + 
                       "-fx-border-color: white;");
      
      // set window title
      primaryStage.setTitle("Boggle");
      
      // call the drawBoard() method to generate game board
      drawBoard();
      
      // create status pane
      statusPane = new VBox();
      
      // add Boggle logo to top of status pane
      ImageView boggleLogo = new ImageView();
      Image bogglePic = new Image("boggleLogo.png", 269, 100, false, false);
      boggleLogo.setImage(bogglePic);
      
      // add Boggle logo to the statusPane
      statusPane.getChildren().add(boggleLogo);
      
      // create status bar for user notifications
      statusBar = new HBox();
      statusBar.setAlignment(Pos.CENTER);
      
      // create default status when game is started
      status = new Text("* Welcome to Boggle! *");
      status.setFont(Font.font("Calibri Light", 14));
      status.setFill(Color.WHITE);
      statusBar.getChildren().add(status);
      
      // create point notification for user (next to status)
      pointNotif = new Text("");
      pointNotif.setFill(Color.ORANGE);
      statusBar.getChildren().add(pointNotif);
      statusPane.getChildren().add(statusBar);
      statusPane.setAlignment(Pos.CENTER);
      mainPane.setTop(statusPane);
      
      // create bottom pane container for built word
      // and buttons
      bottomPane = new VBox(5);
      bottomPane.setAlignment(Pos.CENTER);
      mainPane.setBottom(bottomPane);

      
      // create pane for word builder
      wordBuilder = new HBox();
      wordBuilder.setAlignment(Pos.CENTER);
      builtWord = new Text("");
      builtWord.setStyle("-fx-font-weight: bold;");
      builtWord.setFont(Font.font("truetype", 15));
      builtWord.setFill(Color.WHITE);
      wordBuilder.getChildren().add(builtWord);
      bottomPane.getChildren().add(wordBuilder);
      
      // create button pane 
      buttonPane = new HBox(10);
      buttonPane.setAlignment(Pos.CENTER);
      bottomPane.getChildren().add(buttonPane);
      
      
      // create pane for word list
      wordList = new VBox(5);
      mainPane.setLeft(wordList);
      wordsLabel = new Text("Words Created");
      wordsLabel.setStyle("-fx-font-weight: bold;");
      wordsLabel.setFont(Font.font("Berlin Sans FB", 14));
      wordsLabel.setUnderline(true);
      wordList.getChildren().add(wordsLabel);
      
      // create VBox to contain user created words
      words = new VBox();
      wordList.getChildren().add(words);
      
      // create pane for user's points
      pointsPane = new VBox(5);
      mainPane.setRight(pointsPane);
      pointsLabel = new Text("Total Points");
      pointsLabel.setStyle("-fx-font-weight: bold;");
      pointsLabel.setFont(Font.font("Berlin Sans FB Demi", 14));
      pointsLabel.setUnderline(true);
      pointsPane.getChildren().add(pointsLabel);
      
      // make points a Text object that calls the Game
      // objects getPoints() method which returns the user's points
      points = new Text("\t " + Integer.toString(boggle.getPoints()));
      points.setFill(Color.ORANGE);
      points.setStyle("-fx-font-weight: bold;");
      points.setFont(Font.font("truetype", 15));
      pointsPane.getChildren().add(points);
      
      // create word submit button
      submit = new Button("Submit");
      submit.setStyle("-fx-background-color: #DC7B35");
      submit.setOnAction( new EventHandler<ActionEvent>() 
      {
         public void handle(ActionEvent e)
         {
            if (boggle.getSelectedTiles().size() >= 3)
            {
               // if user word is not valid, notify user and
               // deselect all tiles and clear the currently
               // built word  
               if (!boggle.validWord())
               {
                  status.setText("* Invalid Word *");
                  builtWord.setText("");
                  boggle.clearSelected();
                  unselectTiles();
                  pointNotif.setText("");
               }
               else
               {
                  // if the word has already been created, notify
                  // the user, deselect all tiles and clear the 
                  // currently built word
                  if (boggle.wordUsed())
                  {
                     status.setText("* Word Already Created *");
                     boggle.clearSelected();
                     unselectTiles();
                     builtWord.setText("");
                     pointNotif.setText("");
                  }
                  else
                  // otherwise, the word created is valid, notify
                  // the user, update user words and points by
                  // calling updateWords() and updatePoints()
                  {
                     status.setText("* Valid Word! *");
                     boggle.testSelected();
                     updateWords();
                     updatePoints();
                  }
               }
            }
            else
               // if user clicks submit with no tiles selected,
               // notify the user 
               if (boggle.getSelectedTiles().isEmpty())
               {
                     status.setText("* No Dice Selected *");
                     pointNotif.setText("");
               }
               else
               // if the user's word is less than 3 characters, 
               // notify the user, unselect all tiles and clear
               // the currently built word 
               {
                  status.setText("* Word must be 3 characters or greater *");
                  builtWord.setText("");
                  unselectTiles();
                  boggle.clearSelected();
                  pointNotif.setText("");
               }
         
      }});
      
      // add the submit button to the buttonPane
      buttonPane.getChildren().add(submit);
      
      // create clear tiles button
      clear = new Button("Clear");
      clear.setStyle("-fx-background-color: #DC7B35");
      clear.setOnAction( new EventHandler<ActionEvent>() {
         public void handle(ActionEvent e)
         {
            // unselect all tiles and clear all notification
            // messages and currently built word 
            unselectTiles();
            boggle.clearSelected();
            builtWord.setText("");
            status.setText("");
            pointNotif.setText("");
         }
       });
       
       // add the clear button to the buttonPane
       buttonPane.getChildren().add(clear);
       
       // create new game button
      newGame = new Button("New Game");
      newGame.setStyle("-fx-background-color: #DC7B35");
      newGame.setOnAction( new EventHandler<ActionEvent>() {
         public void handle(ActionEvent e) 
         {
            // close the current stage
            primaryStage.close();
            
            // call the default start method with the same stage
            start(primaryStage); 
         }
       });
       
       // add the new game button to the buttonPane 
       buttonPane.getChildren().add(newGame);

      // create exit button
      exit = new Button("Exit");
      exit.setStyle("-fx-background-color: #DC7B35");
      exit.setOnAction( new EventHandler<ActionEvent>() {
         public void handle(ActionEvent e)
         {
            // open message dialog box with closing message
            // and the user's final score
            JFrame frame = new JFrame("Thank you for playing!");
            JOptionPane.showMessageDialog(frame, "Great game! Your" +
                    " final score was " + boggle.getPoints() + ".");
            
            // terminate the program 
            System.exit(0);
         }
       });
       
       // add the exit button to the buttonPane
       buttonPane.getChildren().add(exit);
       
       // create background color effect for mouse hover
       for (Node b: buttonPane.getChildren())
       {
         Button btn = (Button)b;
         btn.addEventHandler(MouseEvent.MOUSE_ENTERED,
        new EventHandler<MouseEvent>() {
          @Override
          public void handle(MouseEvent e) {
            btn.setStyle("-fx-background-color: #F29552");
          }
        });

         btn.addEventHandler(MouseEvent.MOUSE_EXITED,
        new EventHandler<MouseEvent>() {
          @Override
          public void handle(MouseEvent e) {
            btn.setStyle("-fx-background-color: #DC7B35");
          }
        });
       }
       
      // create hyperlink for game instructions
      Hyperlink instr = new Hyperlink();
      instr.setText("Game Instructions");
      instr.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent e) {
         JFrame frame = new JFrame("Instructions");
         JOptionPane.showMessageDialog(frame, "The game is simple!" +
         "\n\nCreate as many words as possible using the 4X4 board of dice.\n" +
         "Click on the dice to build words with their corresponding" +
         " characters.\n\n However, there are some restrictions!\n\n- You can" +
         " only use each die once when building a word.\n- You can only" +
         " select dice adjacent to your previously selected die.\n" +
         "- Duplicate words are not allowed!\n- Words must be 3 characters or" +
         " greater in length.\n\nThe point system is listed here:" +
         "\n\n3 or 4 characters - 1 point\n5 characters - 2 points\n6 characters" +
         "- 3 points\n7 characters - 5 points\n8+ characters - 11 points\n\n" +
         "Now, go Boggle your heart out, winner.");         }
      });
      bottomPane.getChildren().add(instr);
            
      // create signature
      signature = new Text("Developed by Connor Burleson");
      signature.setFill(Color.WHITE);
      signature.setFont(Font.font("Calibri", 13));
      bottomPane.getChildren().add(signature);

      // center gridpane in the main pane
      mainPane.setCenter(dieGrid);
      
      // set scene with the following specifications
      // (non resizable)
      scene = new Scene(mainPane, 360, 385);
      primaryStage.setScene(scene);
      primaryStage.setResizable(false);
      primaryStage.show();
      
      // listen for mouse clicks on Tiles 
      for (Node node: dieGrid.getChildren())
      {
         // cast node to TilePane object 
         TilePane tp = (TilePane)node;
         
         // call the tileClicked() method on user click 
         tp.setOnMouseClicked(e -> tileClicked(tp));
      }
      
   }
   
   /** 
   the tileClicked void method accepts a TilePane object 
   as its argument, and determines whether or not to allow
   the user to select the tile depending on the given
   tile's state (tests tile adjacency and if the desired tile
   to deselect was the last tile selected)
   @param tp The TilePane clicked on by the user
   */
   public void tileClicked(TilePane tp)
   {
      // get the Tile object from the TilePane selected 
      Tile t = tp.getTile();
      
      // if the TilePane has already been clicked
      if (tp.getClicked())
      {
         // if the TilePane's Tile object was the previously
         // selected, allow user to deselect tile using the 
         // setUnselected() method on the TilePane
         if (t.equals(boggle.getPrevSelected()))
         {
           pointNotif.setText("");
           status.setText("");
           tp.setUnselected();
           
           // remove the selected tile from the selected tiles 
           boggle.removeFromSelected(t.getRow(), t.getCol()); 
         }
      }
      
      // if the TilePane hasn't been clicked  
      else if (!tp.getClicked())
      {
         // if the user selection is valid, allow the user to 
         // select the tile using the setSelected() method on
         // the TilePane 
         if (boggle.isValidSelection(t.getRow(), t.getCol()))
         {
            pointNotif.setText("");
            status.setText("");
            tp.setSelected();
            
            // add the selected tile to the selected tiles 
            boggle.addToSelected(t.getRow(), t.getCol());
         }
         
         // otherwise, the user selection was not valid (the tile
         // was not adjacent to the previously selected tile)
         else
         {
            // notify the user to make a valid selection 
            status.setText("* Please select a die adjacent to the" + 
                               " previously selected die *");
            pointNotif.setText("");
         }    
      }
      
      // call the buildWord() method to update the user's built word 
      // after each tile selection by the user 
      buildWord();
   }

   /**
   the drawBoard method holds a nested for loop that adds 16 
   TilePane objects to the dieGrid GridPane, forming a 4X4 grid 
   of dice visibile to the user 
   */
   public void drawBoard()
   {
      // for each of the 4 rows in the grid
      for (int r = 0; r < Board.NUM_ROWS; r++)
      {
         // for each of the 4 columns in the grid
         for (int c = 0; c < Board.NUM_COLS; c++)
         {
            // create a new TilePane object using the row
            // and column value from the Game objects board of dice 
            TilePane tp = new TilePane(boggle.getTile(r, c));
            
            // add that TilePane object to the dieGrid GridPane 
            dieGrid.add(tp, c, r);
         }
      }
   }
   
   /** 
   the buildWord method steps through the selected Tiles
   (obtained through the Game objects getSelectedTiles() method)
   and builds a string using the letters on each of the tiles, 
   and setting the value of the builtWord Text object to that string
   */
   public void buildWord()
   {
      // create an empty string
      String word = "";
      
      // for each Tile object in the users selected tiles 
      for (Tile tile: boggle.getSelectedTiles())
      {
         // append the Tile objects letter to the string 
         word += (" " + tile.showLetter());
      }
      
      // set the user's built word to the created string 
      builtWord.setText(word);
   }  
   
   /** 
   the updateWords method updates the user's created words
   list by creating Text objects for each word in the Game 
   objects words list, and adding those Text objects to the 
   words VBox
   */
   public void updateWords()
   {
      // clear the current Text objects (words) in the users
      // created words list
      words.getChildren().clear();
      
      // for each word in the words ArrayList
      int i = 1;
      for (String word: boggle.getWordsList())
      {
         // create a Text object using that word, numbered 
         // using the current value of i (initialized at 1)
         Text w = new Text(i + ".\t  " + word);
         w.setFill(Color.WHITE);
         
         // add the word Text object to the words VBox, and 
         // increment i by 1
         words.getChildren().add(w);
         i++; 
      }
   }
   
   /**
   the updatePoints method updates the value of the points Text
   object using the getPoints() method from the boggle Game object,
   along with adding the words individual point value to the right
   of the "Valid Word" status
   */
   public void updatePoints()
   {
      // set the points Text object value to the user's current 
      // points score, returned from the getPoints() method
      points.setText("\t " + Integer.toString(boggle.getPoints()));
      
      // set the point notification Text object value to the points 
      // value of the last word in the user's created words list 
      // (using the static calcPoints() method in the Word class)
      pointNotif.setText("+" + 
         Word.calcPoints(boggle.getWordsList().get(boggle.getWordsList().size() - 1)));
   }    
   
   /** 
   the unselectTiles method steps through each child of the 
   dieGrid (each TilePane,) and calls the setUnselected() method 
   on each TilePane object, unselecting all tiles within the grid
   */
   public void unselectTiles()
   {
      // for each TilePane in the GridPane 
      for (Node node: dieGrid.getChildren())
         {
            // cast the given node to a TilePane object 
            TilePane tp = (TilePane)node;
            
            // call the setUnselected() method on the given TilePane object
            tp.setUnselected();
         }
   }
   
   // call the launch(args) command to start the game 
   public static void main(String[] args)
   {
      launch(args);
   }
}