
package openspace.Particle;

import java.awt.Canvas;
import java.awt.Font;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Vector2f;

public class BoltProjectilePartileClass extends BaseParticleClass{
    
    public BoltProjectilePartileClass(Vector2f position, Vector2f velocity, 
            float size, int ttl, Color color)
    {
        super(position, velocity, size, ttl);
    }
    
    @Override
    public void draw(GameContainer gc, Graphics g)
    {
        g.drawRect(position.x, position.y, size, size);
    }
}