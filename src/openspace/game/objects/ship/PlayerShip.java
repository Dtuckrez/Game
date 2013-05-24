/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package openspace.game.objects.ship;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Vector2f;

/**
 *
 * @author Dean Tucker
 */
public class PlayerShip extends BaseShip
{
    private int sector;
    private boolean isPlayerControlled;
    
    float speed;
    
    public PlayerShip(String name, String race, String type, int weaponBayAmount,
            int hull, Vector2f position)
    {
        super(name, race, type, weaponBayAmount, hull, position);
        sector = 0;
        isPlayerControlled = true;
        speed = 0;
    }
    
    
    public void move(GameContainer gc, int delta)
    {
        position.x+= this.speed * Math.sin(Math.toRadians(rotation));
        position.y-= this.speed * Math.cos(Math.toRadians(rotation));
        
        if(isPlayerControlled)
        {
            increaseSpeed(gc, delta);
            rotate(gc,delta);
        }
    }
    
    private void increaseSpeed(GameContainer gc, int delta)
    {
        Input input = gc.getInput();
        
        if(input.isKeyDown(Input.KEY_W))
        {
            if(this.speed > this.engine.getMaxSpeed())
                this.speed = this.engine.getMaxSpeed();
            
            this.speed += this.engine.getAcceleration() * delta;
        }
        if(input.isKeyDown(Input.KEY_S))
        {   
            this.speed -= 0.002f * delta;
        }
        
        if(speed <= 0)
            speed = 0;   
    }
    
    private void rotate(GameContainer gc, int delta)
    {
        Input input = gc.getInput();
        if(input.isKeyDown(Input.KEY_A))
        {
            rotation -= 0.1f * delta;
        }
        
        if(input.isKeyDown(Input.KEY_D))
        {
            rotation += 0.1f * delta;
        }
    }
    
    @Override
    public void draw()
    {
        this.image.setCenterOfRotation(image.getWidth()/2, image.getHeight()/2);
        image.setRotation(rotation);
        image.draw(position.x, position.y);
    }
    
    public boolean isPlayerControlled()
    {
        return this.isPlayerControlled;
    }
    
    public void isPlayerControlled(boolean isPlayerControlled)
    {
        this.isPlayerControlled = isPlayerControlled;
    }
    
    public int getSector()
    {
        return this.sector;
    }
    
    public void setSector(int sector)
    {
        this.sector = sector;
    }
    
    public Vector2f getPosition()
    {
        return this.position;
    }
    
    public void setPosition(Vector2f position)
    {
        this.position = position;
    }
    
    public float getSpeed()
    {
        return this.speed;
    }
        
}
