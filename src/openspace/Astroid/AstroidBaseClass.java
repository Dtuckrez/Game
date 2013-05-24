
package openspace.Astroid;

import openspace.Weapons.Projectile.BulletBaseClass;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

public class AstroidBaseClass {
    Image image;
    Vector2f position;
    int health;
    boolean isDestroyable;
    
    public AstroidBaseClass() throws SlickException{
        image = new Image("src/openspace/Images/Astroids/0.png");
        position = new Vector2f(120, 360);
        health = 50;
    }
    
    public void isHit(BulletBaseClass[] bullet){
        for(int i = 0; i < bullet.length; i++)
        {
            if(bullet[i].isAlive() && health > 0)
            {
                float dx = this.position.x - bullet[i].getX() + 8;
                float dy = this.position.y - bullet[i].getY() + 8;//4 / 2 - 1;

                float radii = 4 + image.getWidth();

                if ( ( dx * dx )  + ( dy * dy ) < radii * radii )
                {
                    bullet[i].alive = false;
                    health -= 10;
                }
            }
        }
    }
    
    public void draw(GameContainer gc, Graphics g){
        if(health > 0)
        {
            g.setColor(new org.newdawn.slick.Color(0,120,23));
            g.drawRect(position.x, position.y - image.getHeight() / 2 - 6, image.getWidth(), 4);
            g.fillRect(position.x, position.y - image.getHeight() / 2 - 6, image.getWidth() * health / 100, 4);
            image.draw(position.x, position.y);
        }
    }
}
