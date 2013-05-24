/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package openspace.game.objects.astroid;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

/**
 *
 * @author Dean Tucker
 */
public class BaseAstroid 
{
    private Image image;
    private String type;
    private String size;
    private int resource;
    private int health;
    
    private Vector2f position;
    
    public BaseAstroid(String type, String size, int resource, int health
            ,Vector2f position)
    {
        this.type = type;
        this.size = size;
        this.resource = resource;
        this.health = health;
        this.position = position;
        loadImage(this.type, this.size);
    }
    
    private void loadImage(String type, String size)
    {
        try 
        {
            image = new Image("src/openspace/game/images/astroids/"+type+"/"+size+".png");
        } 
        catch (SlickException ex) 
        {
            Logger.getLogger(BaseAstroid.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void drawAstroid(GameContainer gc, Graphics g)
    {
        image.draw(position.x, position.y);
    }
}
