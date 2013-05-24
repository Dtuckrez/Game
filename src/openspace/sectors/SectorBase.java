
package openspace.Sectors;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import openspace.Astroid.AstroidBaseClass;
import openspace.Weapons.Projectile.BulletBaseClass;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class SectorBase {
        String name;
        String race;
        int backDropNumber;
        int width, height;  
        Image backdrop;
        
        boolean isActive = true;
        
        AstroidBaseClass astroid;
        //Arraylist of objects e.g stations, comets and other space stuff    

        public SectorBase(String file, List<Image> backDrops) throws FileNotFoundException, SlickException{
            Scanner scan = new Scanner(new File(file));
            name = scan.next();
            race = scan.next();
            backDropNumber = scan.nextInt();
            width = scan.nextInt();
            height = scan.nextInt();
            backdrop = backDrops.get(backDropNumber);
            astroid = new AstroidBaseClass();
    }

        public void drawSector(GameContainer gc, Graphics g){
            if(isActive)
            {
                backdrop.draw();
                g.drawString(name, 0, 0);
                g.setDrawMode(Graphics.MODE_NORMAL);
            }
        }
        
        public void drawSectorAstroids(GameContainer gc, Graphics g){
            if(isActive)
            {
                astroid.draw(gc, g);
                g.setDrawMode(Graphics.MODE_NORMAL);
            }
        }
        
        public void hitAstroids(BulletBaseClass[] bullet){
            astroid.isHit(bullet);
        }
}
