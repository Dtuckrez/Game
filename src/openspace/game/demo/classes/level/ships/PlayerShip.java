
package openspace.game.demo.classes.level.ships;

import java.util.Random;
import openspace.ParticleEngine.ParticleEngine;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

public class PlayerShip 
{
    Image image;
    public Vector2f position;    
    float rotation;
    
    float speed = 0;
    float turnSpeed;
    float hull;
    float shield;
    float maxSpeed = 1.0f;
    
    ParticleEngine particleEngine;
    
    Random random;
    
    public PlayerShip() throws SlickException{
        speed = 0;
        turnSpeed = 1;
        hull = 100;
        shield = 0;
        
        rotation = 0;
        
        position = new Vector2f(100,100);
        
        image = new Image("src/openspace/Images/Ships/Human/1.png");
        
        random = new Random();
        
        particleEngine = new ParticleEngine(position);
    }
    
    public void UpdateShip(GameContainer gc, int delta)
    {
        Move(gc, delta);
        ChangeSpeed(gc, delta);
        Rotate(gc, delta);
        
        particleEngine.emitterLocation = new Vector2f(position.x + image.getWidth() / 2,
                position.y + image.getHeight() / 2);
        particleEngine.update();
    }
    
    void Move(GameContainer gc, int delta){
        float angle = speed * delta;
        position.x+= angle * Math.sin(Math.toRadians(rotation));
        position.y-= angle * Math.cos(Math.toRadians(rotation));
    }
    
    void ChangeSpeed(GameContainer gc, int delta){
        Input input = gc.getInput();
 
        if(input.isKeyDown(Input.KEY_W))
        {
            if(speed > maxSpeed) {
                speed = maxSpeed;
            }
            
            speed += 0.001f * delta;
        }
        if(input.isKeyDown(Input.KEY_S))
        {
                        
            speed -= 0.001f * delta;
            if(speed <= 0) {
                speed = 0;
            }
        }
        
        
    }
    
    void Rotate(GameContainer gc, int delta){
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
    
    public void Draw(GameContainer gc, Graphics g){
        image.setCenterOfRotation(image.getWidth()/2, image.getHeight()/2);
        image.setRotation(rotation);
        
        g.setDrawMode(Graphics.MODE_ADD);
            particleEngine.draw(gc, g);
        g.setDrawMode(Graphics.MODE_NORMAL);
        
        g.drawImage(image, position.x, position.y);
    }
}
