
package openspace.Ships;

import java.io.FileNotFoundException;
import java.util.Random;
import openspace.Weapons.Projectile.BulletBaseClass;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

/**
 *
 * @author Dean Tucker
 */
public class EnemyShip extends ShipBaseClass
{
    
        int MoveDir = 0;
        
        float sheld; // Upgade with Power Cells <Equipment>
        float hull; //  Upgrade with Ship Upgrades <Stations>
        public boolean alive;
        
        Vector2f hero;
        Vector2f target;
        
        float shootTime;
        
        public BulletBaseClass[] bullet = new BulletBaseClass[50];
        
        public EnemyShip(String fileIn) throws FileNotFoundException, SlickException{
        super(fileIn);
        
            position = new Vector2f(400,350);
            rotation = 0;
            speed = 0;
            maxSpeed = 0.5f;
            turnSpeed = 5f;
            MoveDir = 0;
            
            hull = 100;
            sheld = 100;
            alive = true;
            
            for(int i = 0; i < 50; i++)
            {
                bullet[i] = new BulletBaseClass();
            }
            
        }
        
        public void move(int delta){
            if(alive)
            {
                speed = 0.2f;
                float angle = speed * delta;
                position.x+= angle * Math.sin(Math.toRadians(rotation));
                position.y-= angle * Math.cos(Math.toRadians(rotation));
                
                updateBullets(delta);
                updateParticles();
            }
            if(!alive)
            {
                destroy();
            }
        }
        
        public void spawn(Vector2f[] in){
            if(!alive && this.particleEngine.particles.isEmpty())
            {
                for(int i = 0; i < bullet.length; i++)
                {
                    bullet[i].alive = false;
                }
                
                Random random = new Random();
                
                this.position = in[random.nextInt(in.length)];
                
                this.hull = 100;
                this.alive = true;
                this.particleEngine.resetEngine();
            }
            
        }
        
        public void updateBullets(int delta){
            for(int i = 0; i < 50; i++)
            {
                    bullet[i].move(delta,4f);
                    if(!bullet[i].isAlive())
                    {
                        bullet[i] = new BulletBaseClass();
                    }
            }
        }
        
        public void updateParticles(){
            particleEngine.emitterLocation = new Vector2f(position.x + image.getWidth() / 2,
                    position.y + image.getHeight() / 2);
                    particleEngine.update();
        }
        
        public void shoot(int delta){
            shootTime += delta * 1;
            if(shootTime > 600)
            {
                shootTime = 0;
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
                        bullet[i].speed = 4.0f;
                        break;
                    }
                }
            }
        }
        
        public void rotate(TestPlayerShip playerShip, int delta){
             hero = new Vector2f(this.position.x, this.position.y);
             target = new Vector2f(playerShip.position.x, playerShip.position.y);
             target.sub(hero);
             float finalRotation = (int) target.getTheta();
             
             if((currentRotation <= finalRotation + 45 && currentRotation >= finalRotation - 45))
             {
                 shoot(delta);
             }
             
             if(!(currentRotation <= finalRotation + 1 && currentRotation >= finalRotation - 1))
             {   
                     //shoot(delta);
                 
                 double tempVal;
                 if(currentRotation  < finalRotation)
                 {
                     tempVal = finalRotation - currentRotation;
                     
                     if(tempVal > 180)
                     {
                         currentRotation-=0.1f*delta;
                     }
                     else
                     {
                         currentRotation+=0.1f*delta;
                     }
                 }
                 else if(currentRotation > finalRotation)
                 {
                     tempVal = currentRotation - finalRotation;
                     if(tempVal < 180)
                     {
                         currentRotation-=0.1f*delta;
                     }
                     else
                     {
                         currentRotation+=0.1f*delta;
                     }
                 }
             }
             if(currentRotation < 0)
                 currentRotation = 359;
    
             if(currentRotation > 360)
                 currentRotation = 1;

             rotation = ((int) (currentRotation+90));
        }
        
        public float getX(){
            return this.position.x;
        }
        
        public float getY(){
            return this.position.y;
        }
        
        public float getW(){
            return image.getWidth();
        }
        
        public float getH(){
            return image.getHeight();
        }
        
        public void set(int x, int y){
            position.x = x;
            position.y = y;
        }
        
        public void isHit(BulletBaseClass[] bullet){
           for(int i = 0; i < bullet.length; i++)
           {
               if(bullet[i].isAlive())
               {
                float dx = this.position.x - bullet[i].getX() + 32;
                float dy = this.position.y - bullet[i].getY() + 32;//4 / 2 - 1;

                float radii = 4 + 32;

                if ( ( dx * dx )  + ( dy * dy ) < radii * radii )

                {
                    bullet[i].alive = false;
                   //Random random = new Random();
                    damgeHull(25);
                }
               }
           }
       }
        
        public void damgeHull(int damage){
            hull -= damage;
            if(hull <= 0)
            {
                alive = false;
                particleEngine.lifeTime = 120;
                particleEngine.setColor(0.9f, 0.3f, 0.0f);
            }
        }
        
        public void destroy(){
            if(hull <= 0 && !alive)
            {
                alive = false;
            // Set particle Engine to postion of this ship
            particleEngine.emitterLocation = new Vector2f(position.x + image.getWidth() / 2,
                    position.y + image.getHeight() / 2);
            particleEngine.update();
            }
            if(particleEngine.particles.size() > 600)
               {    
                   alive = false;
                   particleEngine.isActive = false;
               }
        }
        
        @Override
        public void draw(GameContainer gc, Graphics g){
            g.setDrawMode(Graphics.MODE_ADD);
            particleEngine.draw(gc, g);
            g.setDrawMode(Graphics.MODE_NORMAL);
            
            if(alive)
            {
                image.setCenterOfRotation(image.getWidth()/2, image.getHeight()/2);
                image.setRotation(rotation);
                
//                g.setColor(new org.newdawn.slick.Color(0,0,120));
//                g.drawRect(position.x, position.y - image.getHeight() / 2, image.getWidth(), 4);
//                g.fillRect(position.x, position.y - image.getHeight() / 2, image.getWidth() * sheld / 100, 4);
//
                g.setColor(new org.newdawn.slick.Color(0,120,23));
                g.drawRect(position.x, position.y - image.getHeight() / 2 - 6, image.getWidth(), 4);
                g.fillRect(position.x, position.y - image.getHeight() / 2 - 6, image.getWidth() * hull / 100, 4);
//
//                g.drawRect(position.x + image.getWidth() / 2 - 16, position.y + image.getHeight() / 2 - 16, 32, 32);
                
                g.drawImage(image, position.x, position.y);
                
                for(int i = 0; i < 50; i++)
                {
                    bullet[i].draw(gc, g);
                }
                
            }
    } 

}