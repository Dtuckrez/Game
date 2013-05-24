/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package openspace.game.objects.sector.Sector;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import openspace.game.objects.astroid.BaseAstroid;
import openspace.game.objects.stations.BaseStation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import sun.font.GraphicComponent;

/**
 *
 * @author Dean Tucker
 */
public class Sector 
{
    Image background;
    String name;
    String bio;
    int size; // if ship goes outside for too long the ship dies. 
    //Ship ships[]
    ArrayList<BaseStation> baseStations = new ArrayList<>();
    BaseAstroid astroid;
    //Cargo cargo[]
    
    public Sector(String backdrop, String name, String bio, int size)
    {
        this.name = name;
        this.bio = bio;
        loadAstroids();
        loadImage(backdrop);
        
        baseStations.add(new BaseStation());
    }
    
    private void loadAstroids()
    {
        astroid = new BaseAstroid("ore", "0", 100, 100, new Vector2f(900, 300)); 
    }
    
   private void loadImage(String backdrop)
   {
       try 
        {
           background = new Image("src/openspace/game/images/sectors/"+backdrop+".png");
        } 
        catch (SlickException ex) 
        {
            Logger.getLogger(Sector.class.getName()).log(Level.SEVERE, null, ex);
        } 
   }

   /**
    * this is draw first so it does not get effected in translate
    */
   public void drawSector(GameContainer gc, Graphics g)
   {
      background.draw();
   }
   
   public void drawSectorObjects(GameContainer gc, Graphics g)
   {
       drawAstroids(gc, g);
       drawStations(gc, g);
   } 
   
   protected void drawStations(GameContainer gc, Graphics g)
   {
       for(BaseStation baseStation : baseStations)
       {
           baseStation.draw(gc, g);
       }
   }
   
   protected void drawAstroids(GameContainer gc, Graphics g)
   {
       astroid.drawAstroid(gc, g);
   }
}
