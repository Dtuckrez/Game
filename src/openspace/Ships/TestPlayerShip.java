
package openspace.Ships;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import openspace.Weapons.Projectile.BulletBaseClass;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
    
public class TestPlayerShip extends ShipBaseClass{
    int fireTime;
    float shootTime;
    float health;
    
    //Weapon Clase Here
    public BulletBaseClass[] bullet = new BulletBaseClass[50];
    
    public TestPlayerShip(String fileIn) throws FileNotFoundException, SlickException{
        super(fileIn);
        
        position = new Vector2f(100,100);
        rotation = 0;
        speed = 0;
        maxSpeed = 0.1f;
        turnSpeed = .2f;
        fireTime = 1;
        shootTime = 0;  
        
        for(int i = 0; i < 50; i++)
        {
            bullet[i] = new BulletBaseClass();
        }
    }
    
    public void move(GameContainer gc, int delta){
        changeSpeed(gc, delta);
        rotate(gc, delta);
        float angle = speed * delta;
        position.x+= angle * Math.sin(Math.toRadians(rotation));
        position.y-= angle * Math.cos(Math.toRadians(rotation));
        
        shoot(gc, delta);
        
        updateBullet(delta);
        updateParticle();
    }
    
    public void updateBullet(int delta){
        for(int i = 0; i < 50; i++)
        {
            bullet[i].move(delta,7);
            if(!bullet[i].isAlive())
            {
                bullet[i] = new BulletBaseClass();
            }
        }
    }
    
    public void updateParticle(){
        particleEngine.emitterLocation = new Vector2f(position.x + image.getWidth() / 2,
                position.y + image.getHeight() / 2);
        particleEngine.update();
    }
    
    public void changeSpeed(GameContainer gc, int delta){
        Input input = gc.getInput();
 
        if(input.isKeyDown(Input.KEY_W))
        {
            if(speed > maxSpeed) {
                speed = maxSpeed;
            }
            
            speed += 0.002f * delta;
        }
        if(input.isKeyDown(Input.KEY_S))
        {
                        
            speed -= 0.002f * delta;
            if(speed <= 0) {
                speed = 0;
            }
        }
        
        
    }
    
    public void rotate(GameContainer gc, int delta){
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
    
    public void shoot(GameContainer gc, int delta){
        Input input = gc.getInput();
        
        if(input.isKeyDown(Input.KEY_SPACE))
        {
            shootTime += delta * 1;
            if(shootTime > 500)
            {
                shootTime = 0;
                for(int i = 0; i< bullet.length; i++)
                {
                    if(!bullet[i].alive)
                    {
                        bullet[i].alive = true;
                        bullet[i].position = new Vector2f(
                                position.x + this.image.getWidth()/2,
                                position.y + this.image.getHeight()/2);
                        bullet[i].angle = this.rotation;
                        bullet[i].speed = 3.0f;
                        break;
                    }
                }
            }
        }
        else
        {
            shootTime = 0;
        }
    }
    
    public BulletBaseClass[] getBullets(){
        return bullet;
    }
    
    
    // Drawing Methods 
    
    @Override
    public void draw(GameContainer gc, Graphics g){
        image.setCenterOfRotation(image.getWidth()/2, image.getHeight()/2);
        image.setRotation(rotation);
        
        drawBullet(gc, g);
        
        drawParticle(gc, g);
        g.drawImage(image, position.x, position.y);
        
    }
    
    public void drawBullet(GameContainer gc, Graphics g){
        for(int i = 0; i < 50; i++)
        {
            g.setColor(Color.yellow);
            bullet[i].draw(gc, g);
        }
    }
    
    public void drawParticle(GameContainer gc, Graphics g){
        g.setDrawMode(Graphics.MODE_ADD);
        particleEngine.draw(gc, g);
        g.setDrawMode(Graphics.MODE_NORMAL); 
    }
}
    