
package openspace.game.demo.classes.level.astroids;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import openspace.Weapons.Projectile.BulletBaseClass;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

public class AstroidBaseClass {
    Image image;
    Vector2f position;
    
    public AstroidBaseClass(String fileIn) throws SlickException, 
            FileNotFoundException{
        
        Scanner file = new Scanner(new File(fileIn));
        this.image = new Image("src/openspace/Images/Astroids/" 
                + String.valueOf(file.nextInt()) 
                + ".png");
        
        position = new Vector2f(file.nextFloat(), file.nextFloat());
        
    }
    
    public void draw(GameContainer gc, Graphics g){
        image.draw(position.x, position.y);
    }
}
