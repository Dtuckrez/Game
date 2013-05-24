package openspace.Weapons.Projectile;

import openspace.ParticleEngine.BoltProjectileParticleEngine;
import openspace.ParticleEngine.ParticleEngine;
import openspace.Ships.EnemyShip;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;

public class BulletBaseClass {
    Image image;
    //ParticleEngine particleEngine = new ParticleEngine(new Vector2f());
    float lifeTime = 3000;
    
    BoltProjectileParticleEngine boltParticleEngine = new BoltProjectileParticleEngine(
            new Vector2f(), 5, 8, new Color(0.7f, 0, 0.25f, 0.7f));
    
    public Vector2f position;
    public float speed;
    public float angle;
    public boolean alive;
    
    
    public void Bullet(){
        position = new Vector2f(0,0);
        speed = 3f;
        alive = false;
        angle = 0;

    }
    
    public void isHit(EnemyShip enemyShip){
        
        float dx = this.position.x - enemyShip.getX() + enemyShip.getW() / 2 - 16;
        float dy = this.position.y - enemyShip.getY() + enemyShip.getH() / 2 - 16;
        
        float radii = 4 + 16;
        
        if ( ( dx * dx )  + ( dy * dy ) < radii * radii ) 
        {
            alive = false;
            enemyShip.damgeHull(50);
        }
        
    }
    
    public float getX(){
        return this.position.x;
    }
    
    public float getY(){
        return this.position.y;
    }
    
    public float getW(){
        return this.image.getWidth();
    }
    
    public float getH(){
        return this.image.getHeight();
    }
    
    public void move(int delta){
        if(alive)
        {
            position.x+= speed * Math.sin(Math.toRadians(angle));
            position.y-= speed * Math.cos(Math.toRadians(angle));
//                particleEngine.emitterLocation = new Vector2f(position.x,position.y);
//                particleEngine.update();
                
                boltParticleEngine.emitterLocation = new Vector2f(position.x,position.y);
                lifeTime -= 1 * delta;
                if(lifeTime <0)
                {
                    alive = false;
                }
                
        }
        boltParticleEngine.update();
    }
    
        public void move(int delta, float speedIn){
        if(alive)
        {
            position.x+= speedIn * Math.sin(Math.toRadians(angle));
            position.y-= speedIn * Math.cos(Math.toRadians(angle));
//                particleEngine.emitterLocation = new Vector2f(position.x,position.y);
//                particleEngine.update();
                
                boltParticleEngine.emitterLocation = new Vector2f(position.x,position.y);
                lifeTime -= 1 * delta;
                if(lifeTime <0)
                {
                    alive = false;
                }
                
        }
        boltParticleEngine.update();
    }
    
   
    
    public boolean isAlive(){
        return alive;
    }
    
    public void draw(GameContainer gc, Graphics g){
        if(alive)
        {
            boltParticleEngine.draw(gc, g);
        }
    }
}
