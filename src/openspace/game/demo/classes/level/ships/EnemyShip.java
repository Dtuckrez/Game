
package openspace.game.demo.classes.level.ships;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import openspace.Ships.ShipBaseClass;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

public class EnemyShip
{
    public boolean alive;
    
    public Image image;
    public float shipSpeed;
    public float shipTurnSpeed;
    public int shipHull;
    public int shipShield;
    
    float rotation;
    Vector2f position;
    //Weapon
    
    public EnemyShip(String fileIn) throws FileNotFoundException, 
            SlickException
    {
        // gets attributes from parsed in file
        Scanner file = new Scanner(new File(fileIn));
        this.image = new Image("src/openspace/Images/Ships/Human/" + String.valueOf(file.nextInt()) + ".png");
        this.shipSpeed = file.nextFloat();
        this.shipTurnSpeed = file.nextFloat();
        this.shipHull = file.nextInt();
        this.shipShield = file.nextInt();
        
        alive = true;
        position = new Vector2f();
        position.x = 100;
        position.y = 300;
    }
    
        public void draw(GameContainer gc, Graphics g)
    {
        if(this.alive)
        {
            image.setCenterOfRotation(image.getWidth()/2, image.getHeight()/2);
            image.setRotation(rotation);
            
            g.setColor(new org.newdawn.slick.Color(0,120,23));
            g.drawRect(position.x, position.y - image.getHeight() / 2 + 4, image.getWidth(), 4);
            g.fillRect(position.x, position.y - image.getHeight() / 2 + 4, image.getWidth() * shipHull / 100, 4);
            
            g.drawImage(image,position.x,position.y);
        }
    }
}
