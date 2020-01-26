import javafx.application.Application; 
import javafx.stage.Stage; 
import javafx.scene.Scene; 
import javafx.scene.shape.Line;
import javafx.scene.paint.Color;
import javafx.scene.layout.GridPane; 
public class TilePaneTester extends Application 
{    
   public void start(Stage stage)
   {       
      Tile t1 = new Tile("Qu",0,0);       
      Tile t2 = new Tile('e',0,1);       
      Tile t3 = new Tile('d',1,0);       
      Tile t4 = new Tile('u',1,1);
           
      Tile t5 = new Tile("f",0,0);       
      Tile t6 = new Tile('j',0,1);       
      Tile t7 = new Tile('n',1,0);       
      Tile t8 = new Tile('m',1,1);
           
      Tile t9 = new Tile("w",0,0);       
      Tile t10 = new Tile('e',0,1);       
      Tile t11 = new Tile('i',1,0);       
      Tile t12 = new Tile('u',1,1);
           
      Tile t13 = new Tile("t",0,0);       
      Tile t14 = new Tile('c',0,1);       
      Tile t15 = new Tile('x',1,0);       
      Tile t16 = new Tile('r',1,1);  
                  
      TilePane tp1 = new TilePane(t1);       
      TilePane tp2 = new TilePane(t2);       
      tp1.setSelected();   
      TilePane tp3 = new TilePane(t3);       
      TilePane tp4 = new TilePane(t4);       
      tp4.setSelected();
      
      TilePane tp5 = new TilePane(t5);       
      TilePane tp6 = new TilePane(t6);       
      tp1.setSelected();  
      TilePane tp7 = new TilePane(t7);       
      TilePane tp8 = new TilePane(t8);       
      tp8.setSelected();
      
      TilePane tp9 = new TilePane(t9);       
      TilePane tp10 = new TilePane(t10);       
      tp10.setSelected();   
      TilePane tp11 = new TilePane(t11);       
      TilePane tp12 = new TilePane(t12);       
      tp2.setSelected();
      
      TilePane tp13 = new TilePane(t13);       
      TilePane tp14 = new TilePane(t14);       
      tp3.setSelected();   
      TilePane tp15 = new TilePane(t15);       
      TilePane tp16 = new TilePane(t16);       
      tp16.setSelected(); 
                   
      GridPane gp = new GridPane();       
      //remember, add takes col, row        
      gp.add(tp1,0,0);              
      gp.add(tp2,1,0);       
      gp.add(tp3,2,0);       
      gp.add(tp4,3,0);
      
      gp.add(tp5,0,1);              
      gp.add(tp6,1,1);       
      gp.add(tp7,2,1);       
      gp.add(tp8,3,1);
      
      gp.add(tp9,0,2);              
      gp.add(tp10,1,2);       
      gp.add(tp11,2,2);       
      gp.add(tp12,3,2);
      
      gp.add(tp13,0,3);              
      gp.add(tp14,1,3);       
      gp.add(tp15,2,3);       
      gp.add(tp16,3,3);
      
      // Line l1 = new Line(0, 0, 20, 20);
//       l1.setStroke(Color.GREEN);
//       gp.getChildren().add(l1);
      
             
      Scene scene = new Scene(gp);       
      stage.setScene(scene);       
      stage.show(); 
   }    
   
   public static void main(String [] args)
   {       
      launch(args);
   } 
}