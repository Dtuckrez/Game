
package openspace.game.demo.classes;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import openspace.game.demo.classes.level.Level;
import openspace.game.demo.classes.level.ships.PlayerShip;
import openspace.game.objects.camera.BaseCamera;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;


public class Manager 
{
    public int currentLevel;
    public PlayerShip playerShip;
    public BaseCamera camera;
    ArrayList<Level> levels = new ArrayList<>();
    
    public Manager() throws FileNotFoundException, SlickException
    {
        // -1 is the main game menu
        currentLevel = 1;
        playerShip = new PlayerShip();
        levels.add(null);
    }
    
    public void DrawGame(GameContainer gc, Graphics g)
    {
//        if(currentLevel >=0)
//        {
//            levels    .get(currentLcevel).drawLevel(gc, g);
//        }
        playerShip.Draw(gc, g);
    }
    
    public void RunGame(GameContainer gc, int delta)
    {
        playerShip.UpdateShip(gc, delta);
        levels.get(currentLevel).runLevel(gc, delta);
    }
    
    public void loadLevel() throws FileNotFoundException, SlickException
    {
        if(currentLevel >=0)
        {
            if(levels.size() != currentLevel + 1)
            {
                levels.add(new Level(currentLevel));
            }
        }
    }
    
    public float getplayerShipX(){return playerShip.position.x;}
    
    public float getplayerShipY(){return playerShip.position.y;}
}
