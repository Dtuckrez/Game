
package openspace.Particle;

import java.awt.Canvas;
import java.awt.Font;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Vector2f;

public class BaseParticleClass {
    public Vector2f position;
    public Vector2f Velocity;
    public float angle;
    public float angleVolcity;
    public float size;
    public int TTL;
    
    public BaseParticleClass(Vector2f position, Vector2f velocity, float size, int ttl)
    {
        this.position = position;
        this.Velocity = velocity;
        this.size = size;
        this.TTL = ttl;
    }
    
    public void update()
    {
        TTL--;
        position.add(Velocity);
        angle+=angleVolcity;
    }
    
    public void draw(GameContainer gc, Graphics g)
    {
        g.fillOval(position.x, position.y, size, size);
    }
}