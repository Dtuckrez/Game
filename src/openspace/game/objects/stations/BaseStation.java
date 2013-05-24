
package openspace.game.objects.stations;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

public class BaseStation 
{
    protected Image image;
    protected String name;
    protected String type;
    protected int health;
    protected int shields;
    //Ships> landed
    Vector2f position;
    
    public BaseStation()
    {
        name = "test";
        type = "test";
        health = 1000;
        shields = 1000;
        
        position = new Vector2f(100, 900);
        
        loadImage();
    }
    
    private void loadImage()
    {
        try     
        {
            image = new Image("src/openspace/game/images/stations/"+type+".png");
        } 
        catch (SlickException ex) 
        {
            Logger.getLogger(BaseStation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void draw(GameContainer gc, Graphics g)
    {
        image.draw(position.x, position.y);
    }
}
