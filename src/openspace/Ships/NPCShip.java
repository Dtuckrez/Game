/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package openspace.Ships;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import javax.swing.text.Position;
import openspace.Commads.MoveCommand;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

/**
 *
 * @author Dean Tucker
 */
public class NPCShip extends ShipBaseClass{
    
    //ArrayList of Commands E.G 1 fly too, 2 mine rock, 3 fly too, 4 trade rock
    
    public ArrayList <MoveCommand> moveCommand = new ArrayList<>();
    
    public NPCShip(String fileIn) throws FileNotFoundException, SlickException{
        super(fileIn);
        
        position = new Vector2f(100,120);
        turnSpeed = 0.01f;
    }
    @Override
    public void draw(GameContainer gc, Graphics g){
        image.setCenterOfRotation(image.getWidth()/2, image.getHeight()/2);
        image.setRotation(rotation);
        g.drawImage(image, position.x, position.y);
        g.fillRect(position.x + image.getWidth() / 2, position.y + image.getHeight() / 2,9,9);
        g.setColor(Color.yellow);
        //g.fillRect(900, 800, 9, 9);
    }
}
