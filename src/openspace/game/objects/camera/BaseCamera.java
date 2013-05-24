/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package openspace.game.objects.camera;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

/**
 *
 * @author Dean Tucker
 */
public class BaseCamera 
{
    float xPos, yPos;
    boolean isActive;
    
    public BaseCamera()
    {
        isActive = true;
    }
    
    public void translate(GameContainer gc, Graphics g, float xPos, float yPos)
    {
        if(isActive)
            g.translate(xPos + gc.getWidth() /2, yPos + gc.getHeight() /2);
    }
}
